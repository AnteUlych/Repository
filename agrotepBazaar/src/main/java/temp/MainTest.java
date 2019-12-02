package temp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import box.model.Proposition;
import box.model.Sold;

public class MainTest {

	public static void main(String[] args) {
		
		
	Calendar calendar = Calendar.getInstance();
					
			calendar.setTime(new Date());
			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
			
			System.out.println(dayOfWeek);

			
		
		
		/**
		DataBaseController d = new DataBaseController();


		d.editStatusOfProposition(4, "confirmed");
		
		List<Proposition> pi = d.getListOfPropositionsByDirection("import");
		System.out.println("import");
		for(Proposition pr:pi){
		System.out.println(pr.getRoute()+" "+pr.getId());
		}
		System.out.println("export");
        List<Proposition> pe = d.getListOfPropositionsByDirection("export");
		
		for(Proposition pr:pe){
		System.out.println(pr.getRoute()+" "+pr.getId()+" "+pr.getStatus());
		}
		*/
	}

}
