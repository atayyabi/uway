package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement
public class CustomsInvoice implements Serializable  {
	
	@JacksonXmlProperty(localName = "Item")
	@JacksonXmlElementWrapper(useWrapping=false)
	protected List<Item> _item;
	@JacksonXmlProperty(localName="BillTo")
	protected BillTo billTo;
	@JacksonXmlProperty(localName="Contact")
	protected Contact contact;
	
	public CustomsInvoice() {
		
	}
	
	public CustomsInvoice(List<Item> _item, BillTo billTo, Contact contact) {
		this._item = _item;
		this.billTo = billTo;
		this.contact = contact;
	}
	

	public List<Item> getItem() {
		return _item;
	}
	public void setItem(List<Item> _item) {
		this._item = _item;
	}
	public BillTo getBillTo() {
		return billTo;
	}
	public void setBillTo(BillTo billTo) {
		this.billTo = billTo;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}	

}
