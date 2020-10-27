package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController db = new DataBaseController();
		List<Product> ps = db.getListOfOpenProducts();
		
		for(Product p:ps){
			System.out.println(p.getProduct());
		}
	

	}

}
