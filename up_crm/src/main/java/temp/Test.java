package temp;

import java.util.List;

import racoon.logic.BaseController;
import racoon.logic.Encoder;
import racoon.logic.Sender;
import racoon.model.Client;
import racoon.model.Manager;
import racoon.model.Request;

public class Test {

	public static void main(String[] args)  {
		BaseController encoder = new BaseController();
Request request = encoder.getRequestById(90);
		
		//Sender bird = new Sender();
String manager = request.getManager();
System.out.println(manager);
		String mail = encoder.getManagersMailByName(manager);
		//System.out.println(mail);
		System.out.println(mail);
		
	}

}
