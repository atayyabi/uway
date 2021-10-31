package com.uway.server.model.dto;


import lombok.Data;

import java.io.Serializable;

@Data
public class ChargeRequest implements Serializable  {
	
	public enum Currency {
		CAD, USD
	}
	private String description;
	private int amount;
	private Currency currency;
	private String stripeEmail;
	private String stripeToken;

}