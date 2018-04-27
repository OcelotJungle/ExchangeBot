package ru.ocelotjungle.exchangebot.common;

public enum MainCurrency {
	BTC(4, 'B'), ETH(3, 'E'), DOGE(1, 'D'), WAVES(2, 'W'), USD(5, '$'), RUR(6, '₽');
	
	private int priority;
	private char symbol;
	
	MainCurrency(int priority, char symbol) {
		this.priority = priority;
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public static int getPriority(String currency) {
		try {
			return MainCurrency.valueOf(currency.toUpperCase()).priority;
		} catch (IllegalArgumentException iae) {
			return 0;
		}
	}
	
	public static boolean isFirstCurrencyMain(String[] currencies) {
		return (getPriority(currencies[0]) >= getPriority(currencies[1])) ? true : false;
	}
}
