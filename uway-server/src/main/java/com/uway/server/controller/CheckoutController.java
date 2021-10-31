package com.uway.server.controller;

import com.uway.server.model.dto.PaymentSuccessResponse;
import com.uway.server.model.eshipper.ShippingRequestWrapper;
import com.uway.server.repository.UserOrderRepository;
import com.uway.server.repository.UserRepository;
import com.uway.server.service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class CheckoutController extends BaseCheckoutController {

    private final URI eshipperTestUrl = UriComponentsBuilder.fromUriString("http://test.eshipper.com/rpc2").build().toUri();

	CheckoutController(StripeService paymentsService,
                       UserOrderRepository userOrderRepo,
                       UserRepository userRepo, SpringEmailApi emailApi,
                       ShippingController shipping) {
		super(paymentsService, userOrderRepo, userRepo, emailApi, shipping);
	}

	@PostMapping(value = "/api/v1/payment/charge", consumes = MediaType.APPLICATION_XML_VALUE)
    public PaymentSuccessResponse charge(@RequestBody ShippingRequestWrapper cfw) throws StripeException {
        return getPaymentSuccessResponse(cfw, null);
    }

}
