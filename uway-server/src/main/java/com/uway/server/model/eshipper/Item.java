package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Item  {
	
	@JacksonXmlProperty(isAttribute=true)
	protected String code;
	@JacksonXmlProperty(isAttribute=true)
	protected String description;
	@JacksonXmlProperty(isAttribute=true)
	protected String originCountry;
	@JacksonXmlProperty(isAttribute=true)
	protected String quantity;
	@JacksonXmlProperty(isAttribute=true)
	protected String unitPrice;
	
	public Item() {
		
	}
	

	public Item(String code, String description, String originCountry, String quantity, String unitPrice) {
		this.code = code;
		this.description = description;
		this.originCountry = originCountry;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}




	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOriginCountry() {
		return originCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.originCountry = originCountry;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}


	@Override
	public String toString() {
		return "Item [code=" + code + ", description=" + description + ", originCountry=" + originCountry
				+ ", quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}
	
	

	
	
	
	

}
