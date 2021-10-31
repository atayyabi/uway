package com.uway.server.controller;

import com.uway.server.model.dto.ChargeRequest;
import com.uway.server.model.dto.PaymentSuccessResponse;
import com.uway.server.model.entity.User;
import com.uway.server.model.entity.UserOrder;
import com.uway.server.model.eshipper.ShippingRequestWrapper;
import com.uway.server.model.eshipper.EShipperShippingResponse;
import com.uway.server.model.eshipper.QuoteRequest;
import com.uway.server.repository.UserOrderRepository;
import com.uway.server.repository.UserRepository;
import com.uway.server.service.StripeService;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import lombok.RequiredArgsConstructor;

import java.security.Principal;

@RequiredArgsConstructor
public abstract class BaseCheckoutController {
    private final StripeService paymentsService;
    private final UserOrderRepository userOrderRepo;
    private final UserRepository userRepo;
    private final SpringEmailApi emailApi;
    private final ShippingController shipping;

    protected PaymentSuccessResponse getPaymentSuccessResponse(ShippingRequestWrapper srw, Principal principal) throws StripeException {
        QuoteRequest qr = new QuoteRequest();
        qr.setFrom(srw.getShippingRequest().getFrom());
        qr.setTo(srw.getShippingRequest().getTo());
        qr.setPackages(srw.getShippingRequest().getPackages());
        qr.setServiceId(srw.getShippingRequest().getServiceId());

        double costPrice = shipping.getQuotePriceById(qr);
        System.out.println(costPrice);
        double stripePrice = (costPrice) * 100;

        ChargeRequest chargeRequest = new ChargeRequest();
		chargeRequest.setCurrency(ChargeRequest.Currency.CAD);
        chargeRequest.setDescription("Charge  for shipping label");
        chargeRequest.setAmount((int) stripePrice);
        chargeRequest.setStripeToken(srw.getStripeToken());
        chargeRequest.setStripeEmail(srw.getShippingRequest().getFrom().getEmail());

        Charge charge = paymentsService.charge(chargeRequest);
        PaymentSuccessResponse paymentSuccessresponse = new PaymentSuccessResponse();

        if ((!charge.getPaid())) {

            paymentSuccessresponse.setStatus(charge.getStatus());

            return paymentSuccessresponse;

        }

        EShipperShippingResponse eshipperShippingResponse = shipping.getLabel(srw.getShippingRequest());

        paymentSuccessresponse.setStatus(charge.getStatus());
        paymentSuccessresponse.setId(eshipperShippingResponse.getShippingReply().getOrder().getId().toString());
        paymentSuccessresponse
                .setCarrierName(eshipperShippingResponse.getShippingReply().getCarrier().getCarrierName());
        paymentSuccessresponse
                .setCarrierService(eshipperShippingResponse.getShippingReply().getCarrier().getServiceName());
        paymentSuccessresponse
                .setTrackingNumber(eshipperShippingResponse.getShippingReply().getTrackingnumber().getTrackingNumber());
        paymentSuccessresponse.setTrackingUrl(eshipperShippingResponse.getShippingReply().getTrackingURL());
        paymentSuccessresponse.setEncodedLabel(eshipperShippingResponse.getShippingReply().getLabels());

//        try {
//            emailApi.createOrderDocumentsPdf(paymentSuccessresponse);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        String toCountry = cfw.getShippingRequest().getTo().getCountry();
//        String itemType = cfw.getShippingRequest().getPackages().getType();
//
//        if ((!toCountry.equals("CA")) && (itemType.equals("package"))) {
//            try {
//                emailApi.testCustomsFormPdf(paymentSuccessresponse, cfw);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }


        try {

            UserOrder userOrder = new UserOrder();
            userOrder.setOrderNumber(eshipperShippingResponse.getShippingReply().getOrder().getId().toString());
            userOrder.setCarrierName(eshipperShippingResponse.getShippingReply().getCarrier().getCarrierName());
            userOrder.setCarrierService(eshipperShippingResponse.getShippingReply().getCarrier().getServiceName());
            userOrder.setEmailAddress(srw.getShippingRequest().getFrom().getEmail());
//			  userOrder.setEncodedLabel(eshipperShippingResponse.getShippingReply().getLabels());
            userOrder.setOrderTrackingUrl(eshipperShippingResponse.getShippingReply().getTrackingURL());
            userOrder.setTotalCharge(stripePrice); //edit this later to correct unitPrice
            userOrder.setShipFrom(srw.getShippingRequest().getFrom().getCity() + ", "
                    + srw.getShippingRequest().getFrom().getState() + ", " + srw.getShippingRequest().getFrom().getCountry());
            userOrder.setShipTo(srw.getShippingRequest().getTo().getCity() + ", "
                    + srw.getShippingRequest().getTo().getState() + ", " + srw.getShippingRequest().getTo().getCountry());

            if (principal != null) {
                User user = userRepo.findUserByUsername(principal.getName());
                userOrder.setUser(user);
            }

            userOrderRepo.save(userOrder);
//            emailApi.sendOrderConfirmationEmail(paymentSuccessresponse, cfw);
        } catch (Exception e) {

            e.printStackTrace();
        }


        return paymentSuccessresponse;
    }
}
