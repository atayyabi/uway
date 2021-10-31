package com.uway.server.model.eshipper;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.io.Serializable;
import java.util.List;

@JacksonXmlRootElement
public class Packages implements Serializable {

	@JacksonXmlProperty(localName = "Package")
	@JacksonXmlElementWrapper(useWrapping = false)
    protected List<Package> _package;
	
    @JacksonXmlProperty(isAttribute = true)
    protected String type;

    public Packages() {
    	
    }

	public List<Package> get_package() {
		return _package;
	}

	public void set_package(List<Package> _package) {
		this._package = _package;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}