package ru.ocelotjungle.exchangebot.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import ru.ocelotjungle.exchangebot.common.Chain;
import ru.ocelotjungle.exchangebot.views.Window;

@SuppressWarnings("unused")
public class ExchangeBot {
	private static ExchangeBot instance;
	private Printer printer;
	private ArrayList<Chain> bufferedChains;
	private HashMap<Double, Chain> visibleChains;
	private LinkedHashMap<MainCurrency, Long> balanceList;
	
	private ExchangeBot() {
		printer = Printer.getInstance();
	}
	
	public static ExchangeBot getInstance() {
		if(instance == null) {
			instance = new ExchangeBot();
		}
		return instance;
	}
	
	public void reloadBufferedChains() {
		try {
			bufferedChains = ChainInitializer.getChainList();
		} catch (IOException ioe) { printer.printDebugInfo(ioe);}
	}
	
	public void reloadVisibleChains() {
		for(Chain chain : bufferedChains) {
			HashMap<Double, Chain> visibleChains = new HashMap<Double, Chain>(bufferedChains.size());
			visibleChains.put(WebInteractor.getInstance().calcProfit(chain), chain);
		}
	}
	
	public void doExchange(long value, boolean isButtonForAllEnabled) {
		try {
			WebInteractor.getInstance().test();
		} catch (IOException ioe) { 
			printer.printDebugInfo(ioe); 
		}
	}
}
