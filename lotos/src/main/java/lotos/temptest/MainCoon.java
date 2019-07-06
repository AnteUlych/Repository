package lotos.temptest;

import java.util.List;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
	DataController dc = new DataController();
		Recomendation r = new Recomendation();
		//r = dc.getRecomendationByDealId(1);
		 
	   
		System.out.println(r.getCompanytender());
	
	
	}

}
