package racoon.logic;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public List<String> getAllServices(){
		
		List<String> services = new ArrayList();
		
		services.add("truck");
		services.add("conteiner");
		services.add("avia");
		
		return services;
	}

}
