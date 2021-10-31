package com.uway.server.model.eshipper;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName="ShippingRequestWrapper")
public class ShippingRequestWrapper implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@JacksonXmlProperty(localName="CustomsInvoice")
	private CustomsInvoice customsInvoice;
	
	@JacksonXmlProperty(localName="ShippingRequest")
	private ShippingRequest shippingRequest;
	
	@JacksonXmlProperty(localName="StripeToken", isAttribute = true)
	private String stripeToken;
	
	@JacksonXmlProperty(localName="Email", isAttribute = true)
	private String orderEmail;
	
	
	
	public ShippingRequestWrapper() {
		
	}

	

	public CustomsInvoice getCustomsInvoice() {
		return customsInvoice;
	}



	public void setCustomsInvoice(CustomsInvoice customsInvoice) {
		this.customsInvoice = customsInvoice;
	}



	public ShippingRequest getShippingRequest() {
		return shippingRequest;
	}

	public void setShippingRequest(ShippingRequest shippingRequest) {
		this.shippingRequest = shippingRequest;
	}

	public String getStripeToken() {
		return stripeToken;
	}

	public void setStripeToken(String stripeToken) {
		this.stripeToken = stripeToken;
	}



	public String getOrderEmail() {
		return orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	

	
	
	
	
	

	
	
	
	
	
	
	

}