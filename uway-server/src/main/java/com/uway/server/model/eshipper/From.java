package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;


@JacksonXmlRootElement
public class From implements Serializable {

	@JacksonXmlProperty(isAttribute = true)
    protected Integer id;
	@JacksonXmlProperty(isAttribute = true)
    protected String company;
	@JacksonXmlProperty(isAttribute = true)
    protected String address1;
	@JacksonXmlProperty(isAttribute = true)
    protected String city;
	@JacksonXmlProperty(isAttribute = true)
    protected String state;
    @JacksonXmlProperty(isAttribute = true)
    protected String country;
    @JacksonXmlProperty(isAttribute = true)
    protected String zip;
    @JacksonXmlProperty(isAttribute = true)
    protected String phone;
    @JacksonXmlProperty(isAttribute = true)
    protected String attention;
    @JacksonXmlProperty(isAttribute = true)
    protected String email;
    @JacksonXmlProperty(isAttribute = true)
    protected Boolean residential;


    public From() {
    	
    }

	public From(Integer id, String company, String address1, String city, String state, String country,
			String zip) {
		this.id = id;
		this.company = company;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zip = zip;
	}
	
	public From(Integer id, String company, String address1, String city, String state, String zip, String country, String phone, String attention, String email, Boolean residential) {
		this.id = id;
    	this.company = company;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		this.attention = attention;
		this.email = email;
		this.residential = residential;
    }
	
	

	/**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the company property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompany(String value) {
        this.company = value;
    }

    /**
     * Gets the value of the address1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress1() {
        return address1;
    }

    /**
     * Sets the value of the address1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress1(String value) {
        this.address1 = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the state property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the value of the state property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setState(String value) {
        this.state = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZip() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZip(String value) {
        this.zip = value;
    }

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAttention() {
		return attention;
	}

	public void setAttention(String attention) {
		this.attention = attention;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getResidential() {
		return residential;
	}

	public void setResidential(Boolean residential) {
		this.residential = residential;
	}

	@Override
	public String toString() {
		return "From [id=" + id + ", company=" + company + ", address1=" + address1 + ", city=" + city + ", state="
				+ state + ", country=" + country + ", zip=" + zip + ", phone=" + phone + ", attention=" + attention
				+ ", email=" + email + ", residential=" + residential + "]";
	}
	
	
    
    

}