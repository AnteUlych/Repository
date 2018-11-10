package temp;


import java.util.List;

import racoon.logic.BaseController;
import racoon.logic.Encoder;
import racoon.model.Client;
import racoon.model.Proposition;
import racoon.model.Request;

public class Test {

	public static void main(String[] args)  {
/**
		BaseController b = new BaseController();
		List<Proposition> list = b.getAllPropositionsByRequest(2);
		for(Proposition p:list){
			System.out.println(p.getDelivery());
		}
		*/
		
		Encoder encode = new Encoder();
		String password = encode.getPasswordById(1);
		
		System.out.println(password);
		System.out.println(encode.getAccess(password));
		
	}

}
