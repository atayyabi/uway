package com.uway.server.model.dto;

public class Markup {

	public static double setMarkup(double costPrice, double markup) {
		double markupPrice = (costPrice * markup);
		return markupPrice;
	}
	
	public static double calculatePaymentFee(double costPrice, double fee) {
		return costPrice * fee;
	}
	
	public static double calculateUwayServiceAndPaymentFee(double costPrice, double fee) {
		return costPrice * fee ;
	}

}
