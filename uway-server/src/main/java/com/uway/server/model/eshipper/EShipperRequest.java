package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;


@JacksonXmlRootElement(localName = "EShipper")
public class EShipperRequest implements Serializable {
	

	@JacksonXmlProperty(localName = "QuoteRequest")
	private QuoteRequest quoteRequest;
	
	@JacksonXmlProperty(isAttribute = true)
	private String username;
	
	@JacksonXmlProperty(isAttribute = true)
	private String password;
	
	@JacksonXmlProperty(isAttribute = true)
	private String version;

	public EShipperRequest() {}
	
	public EShipperRequest(QuoteRequest quoteRequest, String username, String password, String version) {
		this.quoteRequest = quoteRequest;
		this.username = username;
		this.password = password;
		this.version = version;
	}

	public QuoteRequest getQuoteRequest() {
		return quoteRequest;
	}

	public void setQuoteRequest(QuoteRequest quoteRequest) {
		this.quoteRequest = quoteRequest;
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