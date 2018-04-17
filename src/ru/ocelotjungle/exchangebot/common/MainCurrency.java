package ru.ocelotjungle.exchangebot.common;

public enum MainCurrency {
	BTC(6, 'B'), ETH(5, 'E'), DOGE(4, 'D'), WAVES(3, 'W'), USD(2, '$'), RUR(1, '₽');
	
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
}
