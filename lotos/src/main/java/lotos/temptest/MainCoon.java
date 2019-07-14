package lotos.temptest;

import java.util.List;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Company;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Request;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
	DataController dc = new DataController();
	
	List<Company> r = dc.getAllCompanies();
	
	for(Company re:r){
		System.out.println(re.getCompany());
	}
	   
	}

}
