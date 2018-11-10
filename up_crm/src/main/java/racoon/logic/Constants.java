package racoon.logic;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public String RESULT_WAITING = "waiting";
	public String RESULT_BOOKING= "booking";
	public String RESULT_NOT_INTERESTING = "not interesting";
	
	public List<String> getAllServices(){
		
		List<String> services = new ArrayList();
		
		services.add("truck");
		services.add("conteiner");
		services.add("avia");
		
		return services;
	}

}
