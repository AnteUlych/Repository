package temp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;
import box.model.Manager;
import box.model.Message;
import box.model.Sold;

public class MainTest {

	public static void main(String[] args) {
		
		String rank = "top";
		
 List <Manager> managers = new ArrayList();
		 
 
		 if(rank.equals("top")){
			 DataBaseController base = new DataBaseController();
			 managers = base.getListOfManagers();
			 
			 managers.remove(0);
			 for(Manager manager:managers){
				System.out.println(manager.getName());
			 }

			  //base.closeConnection();
		 }
		
	}

}
