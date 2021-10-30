package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement(localName = "ShippingReply")
public class ShippingReply implements Serializable {
	

	private static final long serialVersionUID = 1L;
	@JacksonXmlProperty(localName = "Quote")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Quote> quote;
	@JacksonXmlProperty(localName = "Order")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Order order;
	@JacksonXmlProperty(localName = "TrackingURL")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String trackingURL;
	@JacksonXmlProperty(localName = "Labels")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String labels;
	@JacksonXmlProperty(localName = "CustomsInvoice")
    @JacksonXmlElementWrapper(useWrapping = false)
    private String customsInvoice;
	@JacksonXmlProperty(localName = "Carrier")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Carrier carrier;
	@JacksonXmlProperty(localName = "Package")
    @JacksonXmlElementWrapper(useWrapping = false)
    private PackageTrackingNumber trackingnumber;
	@JacksonXmlProperty(localName = "Pickup")
    @JacksonXmlElementWrapper(useWrapping = false)
    private Pickup pickup;
    
	

    public ShippingReply() {
    	
    }


	public List<Quote> getQuote() {
		return quote;
	}


	public void setQuote(List<Quote> quote) {
		this.quote = quote;
	}


	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public String getTrackingURL() {
		return trackingURL;
	}


	public void setTrackingURL(String trackingURL) {
		this.trackingURL = trackingURL;
	}


	public String getLabels() {
		return labels;
	}


	public void setLabels(String labels) {
		this.labels = labels;
	}


	public Carrier getCarrier() {
		return carrier;
	}


	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}


	public PackageTrackingNumber getTrackingnumber() {
		return trackingnumber;
	}


	public void setTrackingnumber(PackageTrackingNumber trackingnumber) {
		this.trackingnumber = trackingnumber;
	}


	public Pickup getPickup() {
		return pickup;
	}


	public void setPickup(Pickup pickup) {
		this.pickup = pickup;
	}


	public String getCustomsInvoice() {
		return customsInvoice;
	}


	public void setCustomsInvoice(String customsInvoice) {
		this.customsInvoice = customsInvoice;
	}
	
	
	
	
    
    
    
    

}