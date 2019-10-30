package temp;

import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Auction;
import box.model.Bet;
import box.model.Manager;
import box.model.Sold;

public class MainTest {

	public static void main(String[] args) {
		
		//System.out.println(",,,^._.^,,,");
		
		DataBaseController db = new DataBaseController();
		
		List<Bet> list = db.getListOfBetsByAuctionId(3);
	
		
		//System.out.println(db.getAuctionByAuctionId(2).getRoute()+" "+db.getAuctionByAuctionId(2).getImportance());
		//db.editImportanceOfAuction(2, 1);
		//System.out.println(db.getAuctionByAuctionId(2).getRoute()+" "+db.getAuctionByAuctionId(2).getImportance());
		
		
		for(Bet a:list){
			System.out.println(a.getClient());
		}
		

	}

}
