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
		
		DataBaseController base = new DataBaseController();
		
		//int n = base.getNumberOfArchivebetByManagerIdAndStatusDates("2019-10-07", "2019-11-25", 3, "bet_win");
        //int n = base.getSummOfArchivebetByManagerIdAndStatusDates("2019-10-07", "2019-12-25", 2, "bet_win", "USD");
		//int n = base.getListOfArchiveauctionDates("2019-11-03", "2019-11-25");
		//System.out.println(n);
	
		//System.out.println(base.generateCodeForManager());
	
		//Manager m = base.getManagerById(4);
		
		//base.addManager(m);
		
	
		//System.out.println(m.getId()+" "+m.getName()+" "+m.getRank());
		/**
		List<Manager> all = base.getListOfManagersByRank("manager");
				
		for(Manager s:all){
			System.out.println(s.getId()+" "+s.getName()+" "+s.getRank());
		}
	*/
	

		/**
		List <Deal> all = b.getListOfallDealsByManagerIdAndDirection(2, "import");
		
		for(Deal s:all){
			System.out.println(s.getId()+" "+s.getDateoftransportation());
		}
		*/
		//System.out.println(",,,^._.^,,,");
		
	}

}
