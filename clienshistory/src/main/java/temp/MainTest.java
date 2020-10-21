package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Product;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController db = new DataBaseController();
		List<Product> m = db.getListOfProducts();
		
		for(Product ma:m){
			System.out.println(ma.getProduct());
		}

	}

}
