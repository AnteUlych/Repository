package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController db = new DataBaseController();
		//System.out.println(db.getManagersByCode("111").getName());
		
		List<Manager> cs = db.getListOfNotAdminManagers();
		
		for(Manager c:cs){
			System.out.println(c.getName()+" "+c.getRank());
		}

	}

}
