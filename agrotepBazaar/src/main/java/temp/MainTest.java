package temp;

import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Archiveauction;
import box.model.Archivebet;
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;
import box.model.Manager;
import box.model.Sold;

public class MainTest {

	public static void main(String[] args) {
		
		//System.out.println(",,,^._.^,,,");
		
		DataBaseController b = new DataBaseController();
				
		
		List <Sold> all = b.getListOfAllSold();
		
		for(Sold s:all){
			System.out.println(s.getId()+" "+s.getRoute());
		}
		
		System.out.println(",,,^._.^,,,");
		
	}

}
