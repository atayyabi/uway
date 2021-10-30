package com.uway.server.model.eshipper;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

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
 *         &lt;element name="Quote">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="carrierId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="carrierName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="serviceId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="serviceName" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="modeTransport" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="transitDays" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="deliveryDate" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="currency" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="baseCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="totalTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="baseChargeTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="fuelSurchargeTariff" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="fuelSurcharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *                 &lt;attribute name="totalCharge" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@JacksonXmlRootElement(localName = "QuoteReply")
public class QuoteReply implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(localName = "Quote")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Quote> quote;

    public QuoteReply() {
    	
    }

	public List<Quote> getQuote() {
		return quote;
	}

	public void setQuote(List<Quote> quote) {
		this.quote = quote;
	}
    
    

}