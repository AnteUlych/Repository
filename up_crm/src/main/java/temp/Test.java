package temp;

import racoon.logic.Encoder;

public class Test {

	public static void main(String[] args)  {
/**
		BaseController b = new BaseController();
		List<Proposition> list = b.getAllPropositionsByRequest(2);
		for(Proposition p:list){
			System.out.println(p.getDelivery());
		}
		*/

		Encoder e = new Encoder();
		
		System.out.println(e.isCodeCompanyExist("10"));
		
	}

}
