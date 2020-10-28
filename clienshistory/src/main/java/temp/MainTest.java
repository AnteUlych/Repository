package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController db = new DataBaseController();
		
		List<Client> ps = db.getClientsByCodeOrCompany("2");
		
		for(Client p:ps){
			System.out.println(p.getCompany()+" "+p.getEdrpo());
		}
	

	}

}
