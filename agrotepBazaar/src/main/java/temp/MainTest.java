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
				
		 Deal deal = base.getDealById(8);
		 System.out.println(deal.getBetid());
	
		Archivebet arbet = base.getArchivebetByBetid(deal.getBetid());//
		
		System.out.println(arbet.getId());
		//base.editArchivebetById(arbet.getId(), "canc");
		
		
		
		
	//	System.out.println(bet.getClient());
		

		/**
		List <Deal> all = b.getListOfallDealsByManagerIdAndDirection(2, "import");
		
		for(Deal s:all){
			System.out.println(s.getId()+" "+s.getDateoftransportation());
		}
		*/
		//System.out.println(",,,^._.^,,,");
		
	}

}
