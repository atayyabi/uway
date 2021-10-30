package com.uway.server.model.eshipper;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
public class Package {

    @JacksonXmlProperty(isAttribute = true)
    protected Integer length;
    @JacksonXmlProperty(isAttribute = true)
    protected Integer width;
    @JacksonXmlProperty(isAttribute = true)
    protected Integer height;
    @JacksonXmlProperty(isAttribute = true)
    protected Integer weight;

    
    public Package() {
    	
    }
    
    public Package(Integer length, Integer width, Integer height, Integer weight) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
	}


    public Integer getLength() {
        return length;
    }

    public void setLength(Integer value) {
        this.length = value;
    }


    public Integer getWidth() {
        return width;
    }


    public void setWidth(Integer value) {
        this.width = value;
    }


    public Integer getHeight() {
        return height;
    }


    public void setHeight(Integer value) {
        this.height = value;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer value) {
        this.weight = value;
    }

}