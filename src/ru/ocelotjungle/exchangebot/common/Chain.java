package ru.ocelotjungle.exchangebot.common;

public class Chain {
	private String[] currencies;
	
	public Chain(String[] currencies) {
		this.currencies = currencies;
	}
	
	public String[] getCurrencies() {
		return currencies;
	}
	
	public String toString() {
		return Utils.concat(currencies);
	}
}
