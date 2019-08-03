package lotos.temptest;

import java.util.List;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Company;
import lotos.model.CompanyForStatistic;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Request;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
		DataController data = new DataController();
		Recomendation recomendation = data.getRecomendationById(7);
		
		System.out.println(recomendation.getRecomendationdate());
		System.out.println(recomendation.getRate());
		System.out.println( recomendation.getCompanytender());
		System.out.println( recomendation.getCompanyproposition());
		System.out.println( recomendation.getTransport());
		System.out.println( recomendation.getIncoterms());
		System.out.println( recomendation.getCountryfrom());
		System.out.println( recomendation.getCountryto());
		System.out.println( recomendation.getWeight());
		System.out.println( recomendation.getWhyinfo());
		

	   
	}

}
