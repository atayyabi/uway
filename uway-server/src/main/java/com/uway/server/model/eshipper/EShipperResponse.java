package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QuoteReply">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Quote">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="carrierId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="carrierName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="serviceId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="modeTransport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="transitDays" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                           &lt;attribute name="baseCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="totalTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="baseChargeTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="fuelSurchargeTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="fuelSurcharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                           &lt;attribute name="totalCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@JacksonXmlRootElement(localName = "EShipper")
public class EShipperResponse implements Serializable {


	@JacksonXmlProperty(localName = "QuoteReply")
    private QuoteReply quoteReply;
    
	@JacksonXmlProperty(localName = "ErrorReply")
    private ErrorReply errorReply;
    
	@JacksonXmlProperty(isAttribute = true)
	private String version;
	
	public EShipperResponse() {}
	

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
    public QuoteReply getQuoteReply() {
        return quoteReply;
    }

    /**
     * Sets the value of the quoteReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuoteReply }
     *     
     */
    public void setQuoteReply(QuoteReply value) {
        this.quoteReply = value;
    }


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}
}