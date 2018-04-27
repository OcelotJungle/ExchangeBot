package ru.ocelotjungle.exchangebot.common;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Configurator {
	private static Configurator instance;
	private final String configFileName = "config.cfg";
	private String infoKey, tradeKey, chainsFileName;
	private int infoKeyNonce, tradeKeyNonce;
	
	public static Configurator getInstance() throws IOException {
		if (instance == null) {
			instance = new Configurator();
		}
		try {
			instance.loadConfig();
			instance.saveConfig();
		} catch (IOException ioe) { }
		return instance;
	}
	
	public void loadConfig() throws IOException {
		File configFile = new File(configFileName);
		if (!configFile.exists()) {
			configFile.createNewFile();
		}
		FileReader config = new FileReader(configFileName);
		Scanner scanner = new Scanner(config);
		try {
			String line;
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				String key = line.substring(0, line.indexOf(": ")), value = line.substring(line.indexOf(": ") + 2);
				if (key != null) {
					switch (key) {
					case "chainsFileName":
						chainsFileName = value;
						break;
					case "infoKey":
						infoKey = value;
						break;
					case "tradeKey":
						tradeKey = value;
						break;
					case "infoKeyNonce":
						infoKeyNonce = Integer.parseInt(value.replaceAll("[^0-9]", ""));
						break;
					case "tradeKeyNonce":
						tradeKeyNonce = Integer.parseInt(value.replaceAll("[^0-9]", ""));
						break;
					default:
						throw new IOException();
					}
				}
			}
		} catch (NullPointerException|IndexOutOfBoundsException e) {
			Printer.getInstance().printDebugInfo("Invalid config file.");
		}
		scanner.close();
		config.close();
	}
	
	private void saveConfig() throws IOException {
		StringBuilder newConfig = new StringBuilder();
		newConfig.append("chainsFileName: ").append(chainsFileName)
				.append("\r\ninfoKey: ").append(infoKey).append("\r\ntradeKey: ").append(tradeKey)
				.append("\r\ninfoKeyNonce: ").append(infoKeyNonce).append("\r\ntradeKeyNonce: ").append(tradeKeyNonce);
		new File(configFileName).delete();
		FileWriter config = new FileWriter(configFileName);
		config.write(newConfig.toString());
		config.close();
	}
	
	public String getChainsFileName() {
		return chainsFileName;
	}
	
	public KeyNoncePair getInfoKey() throws IOException {
		infoKeyNonce++;
		saveConfig();
		return new KeyNoncePair(infoKey, infoKeyNonce);
	}
	
	public KeyNoncePair getTradeKey() throws IOException {
		tradeKeyNonce++;
		saveConfig();
		return new KeyNoncePair(tradeKey, tradeKeyNonce);
	}

	@SuppressWarnings("unused")
	private class KeyNoncePair {
		public final String key;
		public final Integer nonce;
		
		public KeyNoncePair(String key, int nonce) {
			this.key = key;
			this.nonce = new Integer(nonce);
		}
	}
}
