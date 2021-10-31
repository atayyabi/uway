package com.uway.server.model.eshipper;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.math.BigDecimal;

@JacksonXmlRootElement
public class Quote implements Serializable {

    @JacksonXmlProperty(isAttribute = true)
    protected Integer carrierId;
    @JacksonXmlProperty(isAttribute = true)
    protected String carrierName;
    @JacksonXmlProperty(isAttribute = true)
    protected Integer serviceId;
    @JacksonXmlProperty(isAttribute = true)
    protected String serviceName;
    @JacksonXmlProperty(isAttribute = true)
    protected String modeTransport;
    @JacksonXmlProperty(isAttribute = true)
    protected Integer transitDays;
    @JacksonXmlProperty(isAttribute = true)
    protected String deliveryDate;
    @JacksonXmlProperty(isAttribute = true)
    protected String currency;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal baseCharge;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal totalTariff;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal baseChargeTariff;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal fuelSurchargeTariff;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal fuelSurcharge;
    @JacksonXmlProperty(isAttribute = true)
    protected BigDecimal totalCharge;

    /**
     * Gets the value of the carrierId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCarrierId() {
        return carrierId;
    }

    /**
     * Sets the value of the carrierId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCarrierId(Integer value) {
        this.carrierId = value;
    }

    /**
     * Gets the value of the carrierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCarrierName() {
        return carrierName;
    }

    /**
     * Sets the value of the carrierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCarrierName(String value) {
        this.carrierName = value;
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
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the modeTransport property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModeTransport() {
        return modeTransport;
    }

    /**
     * Sets the value of the modeTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModeTransport(String value) {
        this.modeTransport = value;
    }

    /**
     * Gets the value of the transitDays property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransitDays() {
        return transitDays;
    }

    /**
     * Sets the value of the transitDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransitDays(Integer value) {
        this.transitDays = value;
    }

    /**
     * Gets the value of the deliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public String getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the value of the deliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDeliveryDate(String value) {
        this.deliveryDate = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the baseCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseCharge() {
        return baseCharge;
    }

    /**
     * Sets the value of the baseCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseCharge(BigDecimal value) {
        this.baseCharge = value;
    }

    /**
     * Gets the value of the totalTariff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalTariff() {
        return totalTariff;
    }

    /**
     * Sets the value of the totalTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalTariff(BigDecimal value) {
        this.totalTariff = value;
    }

    /**
     * Gets the value of the baseChargeTariff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseChargeTariff() {
        return baseChargeTariff;
    }

    /**
     * Sets the value of the baseChargeTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseChargeTariff(BigDecimal value) {
        this.baseChargeTariff = value;
    }

    /**
     * Gets the value of the fuelSurchargeTariff property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFuelSurchargeTariff() {
        return fuelSurchargeTariff;
    }

    /**
     * Sets the value of the fuelSurchargeTariff property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFuelSurchargeTariff(BigDecimal value) {
        this.fuelSurchargeTariff = value;
    }

    /**
     * Gets the value of the fuelSurcharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getFuelSurcharge() {
        return fuelSurcharge;
    }

    /**
     * Sets the value of the fuelSurcharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setFuelSurcharge(BigDecimal value) {
        this.fuelSurcharge = value;
    }

    /**
     * Gets the value of the totalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalCharge() {
        return totalCharge;
    }

    /**
     * Sets the value of the totalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalCharge(BigDecimal value) {
        this.totalCharge = value;
    }

}