package ru.ocelotjungle.exchangebot.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import ru.ocelotjungle.exchangebot.common.Chain;
import ru.ocelotjungle.exchangebot.views.Window;

public class Printer {
	private static Printer instance;
	private Window window;
	
	private Printer() {
		window = Window.getInstance();
	}
	
	public static Printer getInstance() {
		if(instance == null) {
			instance = new Printer();
		}
		return instance;
	}
	
	public void printChainList(ArrayList<Chain> chainList) {
		
	}
	
	public void printBalanceList(LinkedHashMap<MainCurrency, Long> balanceList) {
		
	}
	
	public void printLimitList(LinkedHashMap<String, Long> limitList) {
		
	}
	
	public void printDebugInfo(Object debugInfo) {
		if(debugInfo instanceof Exception) {
			((Exception) debugInfo).printStackTrace();
			//window.debugInfo.setText(((Exception)debugInfo).get);
		} else {
			window.debugInfo.append("[" + System.currentTimeMillis() + "] " + debugInfo.toString() + "\n");
		}
	}
}
