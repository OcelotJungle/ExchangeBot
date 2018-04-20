package ru.ocelotjungle.exchangebot.common;

public class Configurator {
	private static Configurator instance;
	private String infoKey, tradeKey;
	private int infoKeyNonce, tradeKeyNonce;
	
	public Configurator() {
		loadConfig();
	}
	
	public static Configurator getInstance() {
		if (instance == null) {
			instance = new Configurator();
		}
		return instance;
	}
	
	public void loadConfig() {
		
	}
	
	private void saveConfig() {
		
	}
	
	public Entry getInfoKey() {
		infoKeyNonce++;
		saveConfig();
		return new Entry(infoKey, infoKeyNonce);
	}
	
	public Entry getTradeKey() {
		tradeKeyNonce++;
		saveConfig();
		return new Entry(tradeKey, tradeKeyNonce);
	}

	@SuppressWarnings("unused")
	private class Entry {
		public final String key;
		public final Integer nonce;
		
		public Entry(String key, int nonce) {
			this.key = key;
			this.nonce = new Integer(nonce);
		}
	}
}
