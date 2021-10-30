package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;


@JacksonXmlRootElement(localName = "EShipper")
public class EShipperShippingRequest implements Serializable {
	
	
	@JacksonXmlProperty(localName="ShippingRequest")
	private ShippingRequest shippingRequest;
	
	@JacksonXmlProperty(isAttribute = true)
	private String username;
	
	@JacksonXmlProperty(isAttribute = true)
	private String password;
	
	@JacksonXmlProperty(isAttribute = true)
	private String version;

	public EShipperShippingRequest() {}
	
	public EShipperShippingRequest(ShippingRequest shippingRequest, String username, String password, String version) {
		this.shippingRequest = shippingRequest;
		this.username = username;
		this.password = password;
		this.version = version;
	}

	public ShippingRequest getShippingRequest() {
		return shippingRequest;
	}

	public void setShippingRequest(ShippingRequest shippingRequest) {
		this.shippingRequest = shippingRequest;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	
	
	
	
}
