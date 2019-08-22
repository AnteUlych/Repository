package jobinterview;

public class CompanyFactory {

	public Company getCompany(String name){
		return new Store(name);
	      
	   }
	
}
