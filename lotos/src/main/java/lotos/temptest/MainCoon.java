package lotos.temptest;

import java.util.List;

import lotos.logic.DataController;
import lotos.model.Company;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Request;
import lotos.model.Statistic;
import lotos.model.Tender;

public class MainCoon {

	public static void main(String[] args) {
		
		System.out.println("Lotos begining!");
		DataController data = new DataController();
		
		List<Company> com = data.getAllCompanies();
		List<Deal> dea = data.getAllDeals();
		List<Proposition> pro = data.getAllPropositions();
		List<Recomendation> rec = data.getAllRecomendations();
		List<Request> req = data.getAllRequests();
		List<Statistic> sta = data.getAllStatistic();
		List<Tender> ten = data.getAllTenders();
		
		for(Company c:com){
			System.out.println(c.getId());
			System.out.println("Company");
		}
		for(Deal c:dea){
			System.out.println(c.getId());
			System.out.println("Deal");
		}
		for(Proposition c:pro){
			System.out.println(c.getId());
			System.out.println("Proposition");
		}
		for(Recomendation c:rec){
			System.out.println(c.getId());
			System.out.println("Recomendation");
		}
		for(Request c:req){
			System.out.println(c.getId());
			System.out.println("Request");
		}
		for(Statistic c:sta){
			System.out.println(c.getId());
			System.out.println("Statistic");
		}
		for(Tender c:ten){
			System.out.println(c.getId());
			System.out.println("Tender");
		}

	}

}
