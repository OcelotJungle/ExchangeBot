package ru.ocelotjungle.exchangebot.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;

public class WebInteractor {
	private static WebInteractor instance;

	public static WebInteractor getInstance() {
		if(instance == null) {
			instance = new WebInteractor();
		}
		return instance;
	}
	
	public void test() throws IOException {
		System.setProperty("http.agent", "Chrome");
		
		String url = "https://yobit.net/api/3/depth/ltc_btc?limit=1";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("GET");

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
		    response.append(inputLine);
		}
		in.close();
		connection.disconnect();

		Printer.getInstance().printDebugInfo(response);
	}
	
	public Double calcProfit(Chain chain) {
		double profit = Math.pow(0.998d, chain.getCurrencies().length);
			// ...
		return new Double(profit);
	}

	public LinkedHashMap<MainCurrency, Long> getBalanceList() {
		
		return null;
	}
}
