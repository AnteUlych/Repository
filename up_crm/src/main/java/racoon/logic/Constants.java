package racoon.logic;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public String RESULT_WAITING = "waiting";
	public String RESULT_BOOKING = "booking";
	public String RESULT_NOT_INTERESTING = "not interesting";
	public String RESULT_EMPTY = "";
	
	public String USERNAME = "uplg.monitoring@gmail.com";
	public String PASSWORD = "Klug0506";
	
	public String AUTO_MAIL = "auto@uplg.com.ua";
	public String SAR_MAIL = "sar@uplg.com.ua";
	
	public String ERROR_MAIL = "anton.ulych@gmail.com";
	
	public String getDepartmentMail(String service){
	
		if(service.equals("AUTO")){
			return AUTO_MAIL;
		}else if(service.equals("SAR")){
			return SAR_MAIL;
		}
		
		return ERROR_MAIL;
		
	}

	public List<String> getAllServices() {

		List<String> services = new ArrayList();

		services.add("AUTO");
		services.add("SAR");

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
