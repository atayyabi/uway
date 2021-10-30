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
 *         &lt;element name="From">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="company" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="address1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="zip" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="To">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="company" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="address1" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="city" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="state" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 &lt;attribute name="zip" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                 &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Packages">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Package">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                           &lt;attribute name="weight" type="{http://www.w3.org/2001/XMLSchema}int" />
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="serviceId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="stackable" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@JacksonXmlRootElement
public class QuoteRequest implements Serializable {

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

    public QuoteRequest() {
    	
    }
    
    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link From }
     *     
     */
    public From getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link From }
     *     
     */
    public void setFrom(From value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link To }
     *     
     */
    public To getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link To }
     *     
     */
    public void setTo(To value) {
        this.to = value;
    }

    /**
     * Gets the value of the packages property.
     * 
     * @return
     *     possible object is
     *     {@link Packages }
     *     
     */
    public Packages getPackages() {
        return packages;
    }

    /**
     * Sets the value of the packages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Packages }
     *     
     */
    public void setPackages(Packages value) {
        this.packages = value;
    }

    /**
     * Gets the value of the serviceId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServiceId() {
        return serviceId;
    }

    /**
     * Sets the value of the serviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServiceId(Integer value) {
        this.serviceId = value;
    }

    /**
     * Gets the value of the stackable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStackable() {
        return stackable;
    }

    /**
     * Sets the value of the stackable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStackable(Boolean value) {
        this.stackable = value;
    }

}