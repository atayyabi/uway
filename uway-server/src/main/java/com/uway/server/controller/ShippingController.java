package com.uway.server.controller;


import com.uway.server.model.eshipper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ShippingController {

    private final URI eshipperTestUrl = UriComponentsBuilder.fromUriString("http://test.eshipper.com/rpc2").build().toUri();
    @Autowired
    private RestTemplate restTemplate;

    @Value("${eshipper.username}")
    private String eshipperUser;

    @Value("${eshipper.password}")
    private String eshipperPass;

    @CrossOrigin
    @PostMapping(path = "/api/v1/quote", consumes = MediaType.APPLICATION_XML_VALUE)
    public EShipperResponse getRates(@RequestBody QuoteRequest quoteRequest) {
		return getQuoteRequest(quoteRequest);
    }

	private EShipperResponse getQuoteRequest(@RequestBody QuoteRequest quoteRequest) {
		EShipperRequest eshipperRequest = new EShipperRequest();
		eshipperRequest.setQuoteRequest(quoteRequest);
		eshipperRequest.setUsername(eshipperUser);
		eshipperRequest.setPassword(eshipperPass);
		eshipperRequest.setVersion("3.0.0");

		RequestEntity<EShipperRequest> payload = RequestEntity.post(eshipperTestUrl)
				.contentType(MediaType.APPLICATION_XML).accept(MediaType.TEXT_XML).body(
						eshipperRequest);

		return restTemplate.postForObject(eshipperTestUrl, payload,
				EShipperResponse.class);
	}


	public double getQuotePriceById(QuoteRequest quoteRequest) {

		EShipperResponse response = getQuoteRequest(quoteRequest);

		double costPrice = 0;

        for (Quote quote : response.getQuoteReply().getQuote()) {
            costPrice = quote.getTotalCharge().doubleValue();
        }

        return costPrice;


    }

    @CrossOrigin
    @PostMapping(path = "/api/v1/confirm", consumes = MediaType.APPLICATION_XML_VALUE)
    public EShipperShippingResponse getLabel(@RequestBody ShippingRequest shippingRequest1) {

        EShipperShippingRequest eshipperShippingRequest = new EShipperShippingRequest();
        eshipperShippingRequest.setShippingRequest(shippingRequest1);
        eshipperShippingRequest.setUsername(eshipperUser);
        eshipperShippingRequest.setPassword(eshipperPass);
        eshipperShippingRequest.setVersion("3.0.0");


        System.out.println(eshipperShippingRequest);


        RequestEntity<EShipperShippingRequest> payload = RequestEntity.post(eshipperTestUrl)
                .contentType(MediaType.APPLICATION_XML).accept(MediaType.TEXT_XML).body(eshipperShippingRequest);

        EShipperShippingResponse eshipperShippingResponse = restTemplate.postForObject(eshipperTestUrl, payload,
                EShipperShippingResponse.class);

        System.out.println(eshipperShippingResponse);


        return eshipperShippingResponse;

    }

}
	 

