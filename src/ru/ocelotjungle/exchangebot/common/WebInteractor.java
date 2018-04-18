package ru.ocelotjungle.exchangebot.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebInteractor {
	private static WebInteractor instance;

	public static WebInteractor getInstance() {
		if(instance == null) {
			instance = new WebInteractor();
		}
		return instance;
	}
	
	public void test() throws IOException {
		String url = "http://yobit.net/api/3/depth/ltc_btc";

		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

		connection.setRequestMethod("GET");
		//connection.setRequestProperty("User-Agent", "Mozilla/5.0");
		connection.setRequestProperty("limit", "1");

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
		return 0.0d;
	}
}
