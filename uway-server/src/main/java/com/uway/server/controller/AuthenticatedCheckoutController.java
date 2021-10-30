package com.uway.server.controller;

import com.uway.server.model.dto.PaymentSuccessResponse;
import com.uway.server.model.eshipper.ShippingRequestWrapper;
import com.uway.server.repository.UserOrderRepository;
import com.uway.server.repository.UserRepository;
import com.uway.server.service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticatedCheckoutController extends BaseCheckoutController {

	private final URI eshipperTestUrl = UriComponentsBuilder.fromUriString("http://test.eshipper.com/rpc2").build().toUri();

	AuthenticatedCheckoutController(StripeService paymentsService,
                                    UserOrderRepository userOrderRepo,
                                    UserRepository userRepo, SpringEmailApi emailApi,
                                    ShippingController shipping) {
		super(paymentsService, userOrderRepo, userRepo, emailApi, shipping);
	}

	@PostMapping(value = "/api/v1/authenticated/payment/charge", consumes = MediaType.APPLICATION_XML_VALUE)
	public PaymentSuccessResponse charge(@RequestBody ShippingRequestWrapper cfw, Principal principal) throws StripeException {
		return getPaymentSuccessResponse(cfw, principal);
	}
}
