package com.uway.server.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaymentSuccessResponse {
	
	String id;
	String trackingUrl;
	String trackingNumber;
	String carrierName;
	String carrierService;
	String status;
	String encodedLabel;
	String encodedCustomsInvoice;

}