package ru.ocelotjungle.exchangebot.common;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import ru.ocelotjungle.exchangebot.views.Window;

public class ChainInitializer {
	
	@SuppressWarnings("unchecked")
	public static void initialize(Window window) {
		try {
			Object[] chains = getChainList();
			window.listChains.setListData(chains);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public static Object[] getChainList() throws IOException {
		Object[] chains = Files.readAllLines(Paths.get("./chains.txt"), StandardCharsets.UTF_8).toArray();
		return chains;
	}
}
