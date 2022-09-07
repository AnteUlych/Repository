package temp;

import java.text.ParseException;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;


public class MainTest {

	public static void main(String[] args) throws ParseException {
  
		DataBaseController base = new DataBaseController();
		List<Client> clients = base.getClientsSortedByName();
		
		for(Client c:clients){
			System.out.println(c.getCompany());
		}
	}
}
