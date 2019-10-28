package temp;

import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Auction;
import box.model.Manager;

public class MainTest {

	public static void main(String[] args) {
		
		//System.out.println(",,,^._.^,,,");
		
		DataBaseController db = new DataBaseController();
		
		List<Auction> list = db.getListOfAuctionsByDirection("export");
		
		for(Auction a:list){
			System.out.println(a.getDirection()+" "+a.getRoute()+" "+a.getImportance());

		}
		

	}

}
