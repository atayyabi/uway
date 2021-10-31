package com.uway.server.model.dto;

import lombok.Value;

@Value
public class SupportRequest {
	
	String name;
	String email;
	String reasonType;
	String description;
	String status;
}
