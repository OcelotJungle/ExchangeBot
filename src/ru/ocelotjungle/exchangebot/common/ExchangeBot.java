package ru.ocelotjungle.exchangebot.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import ru.ocelotjungle.exchangebot.common.Chain;
import ru.ocelotjungle.exchangebot.views.Window;
import sun.awt.image.BufferedImageDevice;

@SuppressWarnings("unused")
public class ExchangeBot {
	private static ExchangeBot instance;
	private Printer printer;
	private ArrayList<Chain> bufferedChains;
	private LinkedHashMap<Chain, Double> visibleChains;
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
	
	public void reloadList() {
		try {
			bufferedChains = ChainInitializer.getChainList();
			printer.printDebugInfo("Buffered chains reloaded.");
		} catch (IOException ioe) { printer.printDebugInfo(ioe);}
	}
	
	public void reloadInfo() {
		visibleChains = new LinkedHashMap<Chain, Double>();
		for(Chain chain : bufferedChains) {
			visibleChains.put(chain, WebInteractor.getInstance().calcProfit(chain));
		}
		printer.printChainList(visibleChains);
		printer.printBalanceList(WebInteractor.getInstance().getBalanceList());
	}
	
	public void makeProfit(long value, boolean isButtonForAllEnabled) {
		try {
			WebInteractor.getInstance().test();
		} catch (IOException ioe) { 
			printer.printDebugInfo(ioe); 
		}
	}
}
