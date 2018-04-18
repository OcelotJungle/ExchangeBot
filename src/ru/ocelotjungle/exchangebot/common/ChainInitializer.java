package ru.ocelotjungle.exchangebot.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import ru.ocelotjungle.exchangebot.common.Chain;

public class ChainInitializer {
	public static Chain getChain(String currencyString) {
		return new Chain(currencyString);
	}
	
	public static ArrayList<Chain> getAllChainsFromFile(File chainsFile) throws IOException {
		ArrayList<Chain> chains = new ArrayList<>();
		for(String line : Files.readAllLines(Paths.get(chainsFile.getAbsolutePath()))) {
			chains.add(getChain(line));
		}
		return chains;
	}
	
	public static ArrayList<Chain> getChainList() throws IOException {
		return getAllChainsFromFile(new File("chains.txt"));
	}
}
