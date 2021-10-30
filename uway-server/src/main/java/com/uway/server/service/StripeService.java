package com.uway.server.service;

import com.uway.server.model.dto.ChargeRequest;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class StripeService {

    @PostConstruct
    public void init() {
        Stripe.apiKey = "sk_test_Bs6q4kECB72Uu2DRRYoYkYFb00SHYEAFmR";
    }

    //Creates customer by email, assigns a customerId on Stripe dashboard, saves customer card and charges them for the order amount
    public Charge charge(ChargeRequest chargeRequest) throws StripeException {

        Map<String, Object> newCustomerParams = new HashMap<>();
        newCustomerParams.put("email", chargeRequest.getStripeEmail());

        Customer newCustomer = Customer.create(newCustomerParams);
        Map<String, Object> sourceParams = new HashMap<>();
        sourceParams.put("source", chargeRequest.getStripeToken());


        newCustomer.getSources().create(sourceParams);
        String customerId = newCustomer.getId();
        return getCharge(chargeRequest, customerId);
    }

    private Charge getCharge(ChargeRequest chargeRequest, String customerId) throws StripeException {
        Map<String, Object> params = new HashMap<>();
        params.put("amount", chargeRequest.getAmount());
        params.put("currency", chargeRequest.getCurrency());
        params.put("description", chargeRequest.getDescription());
        params.put("customer", customerId);
        return Charge.create(params);
    }

    //Use this method if you need to charge an adjustment to a specific customer. Requires customerId(can be obtained from Stripe dashboard))
    public Charge customerAdjustment(ChargeRequest chargeRequest, String customerId) throws StripeException {

        return getCharge(chargeRequest, customerId);


    }


}