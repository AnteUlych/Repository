package temp;

import java.util.List;

import racoon.logic.BaseController;
import racoon.logic.Encoder;
import racoon.model.Client;
import racoon.model.Manager;
import racoon.model.Request;

public class Test {

	public static void main(String[] args)  {
		
		Encoder e = new Encoder();
		String code = "512355";
		Client client = e.getClientByIdCodeFromConsole(code);
		Manager manager = e.getFullInfoByManagerByCode(code);
		System.out.println (client.getManager());
		System.out.println (manager.getName());
		String mayIClick = "disabled";
		if(client.getManager().equals(manager.getName())){
			mayIClick = "";
		}
		System.out.println(mayIClick);
	}

}
