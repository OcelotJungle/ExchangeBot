package ru.ocelotjungle.exchangebot.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;

import ru.ocelotjungle.exchangebot.views.Window;

@SuppressWarnings("unchecked")
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
	
	public void printChainList(LinkedHashMap<Chain, Double> chainList) {
		DefaultListModel<String> model = new DefaultListModel<>();
		chainList = Utils.sortByProfit((HashMap<Chain, Double>)chainList);
		for (Entry<Chain, Double> entry : chainList.entrySet()) {
			model.addElement(entry.getKey().toString().toUpperCase() + " (" + (Math.floor((entry.getValue() - 1) * 10e3) / 10e3) + "%)");
		}
		window.chainList.setModel(model);;
	}
	
	public void printBalanceList(LinkedHashMap<MainCurrency, Long> balanceList) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Entry<MainCurrency, Long> entry : balanceList.entrySet()) {
			model.addElement(new Double(entry.getValue() / 10e8).toString() + entry.getKey().getSymbol());
		}
		window.balanceList.setModel(model);
	}
	
	public void printLimitList(LinkedHashMap<String, Long> limitList) {
		DefaultListModel<String> model = new DefaultListModel<>();
		for (Entry<String, Long> entry : limitList.entrySet()) {
			model.addElement(new Double(entry.getValue() / 10e8).toString() + " " + entry.getKey());
		}
		window.balanceList.setModel(model);
	}
	
	public void printDebugInfo(Object debugInfo) {
		if(debugInfo instanceof Exception) {
			((Exception) debugInfo).printStackTrace();
			//window.debugInfo.setText(((Exception)debugInfo).get);
		} else {
			window.debugInfo.append("[" + System.currentTimeMillis() + "] " + debugInfo.toString() + "\n");
		}
	}
	
	public void print(Object toPrint) {
		System.out.println(toPrint.toString());
	}
}
