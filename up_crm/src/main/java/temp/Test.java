package temp;


import java.util.List;

import racoon.logic.BaseController;
import racoon.logic.Encoder;
import racoon.model.Client;
import racoon.model.Request;

public class Test {

	public static void main(String[] args)  {
/**
	BaseController bc = new BaseController();
	List<Client> clients = bc.getClientsByManager("Marina");
	for(Client c:clients){
		System.out.println(c.getCompany()+" "+c.getManager()+" "+c.getAnswer()+" "+c.getFunnel());  
	}
		*/
		
		Encoder e = new Encoder();
		List<Request> list = e.getRequestsByServiceFromCodeConsole("31234truck");
		for(Request c:list){
			System.out.println(c.getRoute());  
		}
	}

}
