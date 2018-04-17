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
	
	public static void buttonMakeProfitClick(boolean isButtonForAllEnabled) {
		ExchangeBot.getInstance().doExchange(isButtonForAllEnabled);
		Printer.getInstance().printDebugInfo("Pressed button Make Profit with " + (isButtonForAllEnabled ? "enabled" : "disabled") + " button For All");
	}
}
