package racoon.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import racoon.model.Client;
import racoon.service.ClientService;


public class BaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	
	public List<Client> getClientsByManager(String manager){
		ClientService clientService = (ClientService) ctx
				.getBean("clientService");
		return clientService.getAllClientsByManager(manager);
	}
	
	

}
