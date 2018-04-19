package ru.ocelotjungle.exchangebot.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Utils {
	public static void buttonReloadListClick() {
		ExchangeBot.getInstance().reloadList();
	}
	
	public static void buttonReloadInfoClick() {
		ExchangeBot.getInstance().reloadInfo();
	}
	
	public static void buttonMakeProfitClick(String value, boolean isButtonForAllEnabled) {
		ExchangeBot.getInstance().makeProfit((long) Math.floor(Double.parseDouble(value.replaceFirst("", "0").replaceAll("[^0-9.]", "")) * 10e8), isButtonForAllEnabled);
	}
	
	public static String concat(String[] array) {
		StringBuilder temp = new StringBuilder("[");
		if (array.length > 0) {
			temp.append(array[0]);
			for (int i = 1; i < array.length; i++) {
				temp.append(", ").append(array[i]);
			}
		}
		return temp.append("]").toString();
	}
	
	public static String[] getInvertedArray(String[] array) {
		String[] invertedArray = new String[array.length];
		for (int i = 0, j = array.length - 1; i < array.length ; i++, j--) {
			invertedArray[j] = array[i];
		}
		return invertedArray;
	}
	
	public static LinkedHashMap<Chain, Double> sortByProfit(HashMap<Chain, Double> chainList) {
		LinkedHashMap<Chain, Double> sortedChainList = new LinkedHashMap<>();
		for (int i = chainList.size(); i > 0; i--) {
			Chain maxProfitChain = null;
			Double maxProfit = new Double(0.0d);
			for (Entry<Chain, Double> entry : chainList.entrySet()) {
				if (entry.getValue() >= maxProfit) {
					maxProfitChain = entry.getKey();
					maxProfit = entry.getValue();
				}
			}
			sortedChainList.put(maxProfitChain, maxProfit);
			chainList.remove(maxProfitChain);
		}
		return sortedChainList;
	}
	
	public static String getVisibleChain(Double profit, Chain chain) {
		return chain.toString() + " (" + profit.toString() + ")";
	}
}
