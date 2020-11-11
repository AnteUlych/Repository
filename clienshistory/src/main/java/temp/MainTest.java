package temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.model.Records;

public class MainTest {

	public static void main(String[] args) {
		/**
		DataBaseController db = new DataBaseController();
		List<Records> rs = db.getListOfRecordsByManagerIdIdAndStatusBetweenDates(1, 1, "2020-09-01", "2020-11-29");
	 
	    for(Records r:rs){
	    	System.out.println(r.getId());
	    }
      
	
	*/
		DataBaseController base = new DataBaseController();
		
		String string1 = "p&_2&_0";
		String string2 = "m&_2&_2&_2020-11-02&_2020-11-07";
		
		String encoderforSplit = "&_";
		
		String [] comand = string2.split(encoderforSplit);
		
		if(comand[0].equals("p")){
			int productid = Integer.parseInt(comand[1]);
			String needProduct = base.getProductById(productid).getProduct();
			int funel = Integer.parseInt(comand[2]);
			List<Client> clients = base.getClientsByFunelAndOpenProduct(funel, needProduct);
		}
		
		if(comand[0].equals("m")){
			
			int managerid = Integer.parseInt(comand[1]);
			int recordsStatus = Integer.parseInt(comand[2]);
			String fromDate = comand[3];
			String toDate = comand[4];		
			List<Records> records = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(managerid, recordsStatus, fromDate, toDate);			
		}

	}

}
