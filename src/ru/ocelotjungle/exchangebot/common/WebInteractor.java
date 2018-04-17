package ru.ocelotjungle.exchangebot.common;

public class WebInteractor {
	private static WebInteractor instance;

	public static WebInteractor getInstance() {
		if(instance == null) {
			instance = new WebInteractor();
		}
		return instance;
	}
}
