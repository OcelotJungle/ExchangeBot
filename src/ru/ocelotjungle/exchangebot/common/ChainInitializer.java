package ru.ocelotjungle.exchangebot.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import ru.ocelotjungle.exchangebot.common.Chain;

public class ChainInitializer {
	public static Chain getChain(String[] currencies) {
		return new Chain(currencies);
	}
	
	public static String[] verifyChain(String currenciesString) throws IllegalArgumentException {
		String[] currencies = currenciesString.toLowerCase().replaceAll("[^a-z0-9,]", "").split(",");
		if (currencies.length > 2) {
			boolean isLastCurrencyMain = false;
			for (String currency : currencies) {
				if (currency.length() <= 0) {
					throw new IllegalArgumentException("Wrong currency in the chain.");
				} else if (MainCurrency.getPriority(currency) > 0) {
					isLastCurrencyMain = true;
				} else {
					if (isLastCurrencyMain) {
						isLastCurrencyMain = false;
					} else {
						throw new IllegalArgumentException("Currencies are in wrong order.");
					}
				}
			}
			return currencies;
		} else {
			throw new IllegalArgumentException("Currencies count is too small.");
		}
	}
	
	public static ArrayList<Chain> getAllChainsFromFile(File chainsFile) throws IOException {
		ArrayList<Chain> chains = new ArrayList<>();
		for (String line : Files.readAllLines(Paths.get(chainsFile.getAbsolutePath()))) {
			try {
				String[] verifiedChain = verifyChain(line);
				chains.add(getChain(verifiedChain));
				chains.add(getChain(Utils.getInvertedArray(verifiedChain)));
			} catch(IllegalArgumentException iae) {}
		}
		if(chains.size() > 0) {
			return chains;
		} else {
			throw new IOException("Chains file is empty.");
		}
	}
	
	public static ArrayList<Chain> getChainList() throws IOException {
		return getAllChainsFromFile(new File(Configurator.getInstance().getChainsFileName()));
	}
}
