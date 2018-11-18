package racoon.logic;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public String RESULT_WAITING = "waiting";
	public String RESULT_BOOKING = "booking";
	public String RESULT_NOT_INTERESTING = "not interesting";
	public String RESULT_EMPTY = "";

	public List<String> getAllServices() {

		List<String> services = new ArrayList();

		services.add("truck");
		services.add("conteiner");
		services.add("avia");

		return services;
	}

	public List<String> getAllFunnel() {

		List<String> funnel = new ArrayList();

		funnel.add("cold");
		funnel.add("calculation");
		funnel.add("interest");
		funnel.add("partner");
		funnel.add("black list");

		return funnel;
	}

	public List<String> getAllCategories() {

		List<String> categories = new ArrayList();

		categories.add("A");
		categories.add("B");
		categories.add("C");
		categories.add("D");

		return categories;

	}

}
