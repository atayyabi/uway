package com.uway.server.model.eshipper;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.io.Serializable;

@JacksonXmlRootElement
public class ErrorReply implements Serializable {
	@JacksonXmlProperty(localName = "Error")
	@JacksonXmlText
    protected String message;

	public ErrorReply() {
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}