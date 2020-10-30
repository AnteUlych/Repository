package temp;

import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.model.Records;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController db = new DataBaseController();
		
	
		//db.addRecords(r);
		
		
		List<Records> ps = db.getListOfRecordsByClientId(3);
		
		for(Records p:ps){
			System.out.println(p.getManager());
		}
	

	}

}
