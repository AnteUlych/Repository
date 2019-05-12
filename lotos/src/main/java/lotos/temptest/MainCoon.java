package lotos.temptest;

import java.util.List;

import lotos.logic.DataController;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
		System.out.println("class start");
		DataController data = new DataController();
	
			System.out.println(data.getNumberofClosingDealsByCompanyId(1));
			System.out.println(data.getNumberWinningDealsByCompanyId(40));
		
		System.out.println("class end");
	}

}
