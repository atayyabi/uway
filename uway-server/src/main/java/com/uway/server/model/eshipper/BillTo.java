package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class BillTo {
	
	@JacksonXmlProperty(isAttribute = true)
	protected String company;
	@JacksonXmlProperty(isAttribute = true)
	protected String name;
	@JacksonXmlProperty(isAttribute = true)
	protected String address1;
	@JacksonXmlProperty(isAttribute = true)
	protected String city;
	@JacksonXmlProperty(isAttribute = true)
	protected String state;
	@JacksonXmlProperty(isAttribute = true)
	protected String zip;
	@JacksonXmlProperty(isAttribute = true)
	protected String country;
	
	public BillTo() {
		
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

}
