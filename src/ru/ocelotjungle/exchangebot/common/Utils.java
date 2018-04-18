package ru.ocelotjungle.exchangebot.common;

public class Utils {
	public static void buttonReloadListClick() {
		ExchangeBot.getInstance().reloadBufferedChains();
		Printer.getInstance().printDebugInfo("Pressed button Reload List");
	}
	
	public static void buttonReloadInfoClick() {
		ExchangeBot.getInstance().reloadVisibleChains();
		Printer.getInstance().printDebugInfo("Pressed button Reload Info");
	}
	
	public static void buttonMakeProfitClick(String value, boolean isButtonForAllEnabled) {
		ExchangeBot.getInstance().doExchange((long) Math.floor(Double.parseDouble(value.replaceFirst("", "0").replaceAll("[^0-9.]", "")) * 10e8), isButtonForAllEnabled);
	}
}
