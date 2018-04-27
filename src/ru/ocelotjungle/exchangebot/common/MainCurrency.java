package ru.ocelotjungle.exchangebot.common;

public enum MainCurrency {
	BTC(4, 'B'), ETH(3, 'E'), DOGE(1, 'D'), WAVES(2, 'W'), USD(5, '$'), RUR(6, '₽');
	
	private int priority;
	private char symbol;
	
	MainCurrency(int priority, char symbol) {
		this.priority = priority;
		this.symbol = symbol;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public static boolean exist(String currency) {
		try {
			MainCurrency.valueOf(currency.toUpperCase());
			return true;
		} catch (IllegalArgumentException iae) {
			return false;
		}
	}
}
