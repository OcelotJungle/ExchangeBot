package ru.ocelotjungle.exchangebot.common;

public class Chain {
	private String[] currencies;
	private Double profit;
	
	public Chain(String currencyString) {
		currencies = currencyString.toUpperCase().replaceAll("[^a-zA-Z0-9,]", "").split(",");
		profit = Math.pow(0.998d, currencies.length);
	}
	
	public String[] getCurrencies() {
		return currencies;
	}
	
	public Double getProfit() {
		return profit;
	}
}
