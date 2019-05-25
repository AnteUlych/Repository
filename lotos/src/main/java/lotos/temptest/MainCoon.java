package lotos.temptest;

import java.util.List;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
		System.out.println("class start");
		DataController cb = new DataController();
		
		List<Tender> t = cb.getOpenTenders();
		for(Tender te:t){
		System.out.println(te.getId());
		}
	}

}
