package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement
public class ShippingRequest implements Serializable {

	@JacksonXmlProperty(localName = "From")
    protected From from;
	
	@JacksonXmlProperty(localName = "To")
    protected To to;
	
	@JacksonXmlProperty(localName = "Packages")
    protected Packages packages;
	
	
	
	@JacksonXmlProperty(isAttribute = true)
    protected Integer serviceId;
    
	@JacksonXmlProperty(isAttribute = true)
    protected Boolean stackable;

    public ShippingRequest() {
    	
    }
    



	public From getFrom() {
        return from;
    }

    public void setFrom(From value) {
        this.from = value;
    }

    public To getTo() {
        return to;
    }

    public void setTo(To value) {
        this.to = value;
    }


    public Packages getPackages() {
        return packages;
    }
  

    public void setPackages(Packages value) {
        this.packages = value;
    }

    public Integer getServiceId() {
        return serviceId;
    }


    public void setServiceId(Integer value) {
        this.serviceId = value;
    }

    public Boolean isStackable() {
        return stackable;
    }

   
    public void setStackable(Boolean value) {
        this.stackable = value;
    }


}
