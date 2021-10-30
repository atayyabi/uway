package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;

@JacksonXmlRootElement(localName = "EShipper")
public class EShipperShippingResponse implements Serializable {


	@JacksonXmlProperty(localName = "ShippingReply")
    private ShippingReply shippingReply;
    
	@JacksonXmlProperty(localName = "ErrorReply")
    private ErrorReply errorReply;
    
	@JacksonXmlProperty(isAttribute = true)
	private String version;
	
	public EShipperShippingResponse() {}
	

    public ErrorReply getErrorReply() {
    	return errorReply;
    }
    public void setErrorReply(ErrorReply errorReply) {
    	this.errorReply = errorReply;
    }
    
    /**
     * Gets the value of the quoteReply property.
     * 
     * @return
     *     possible object is
     *     {@link QuoteReply }
     *     
     */
    public ShippingReply getShippingReply() {
        return shippingReply;
    }

    /**
     * Sets the value of the quoteReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteReply }
     *     
     */
    public void setShippingReply(ShippingReply value) {
        this.shippingReply = value;
    }


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}
}
