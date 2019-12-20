package temp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
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
		
		String start = "2019-12-19";
		String ending = "2019-12-21";
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date dateStart = new Date();
		Date dateFinish = new Date();
		
		try {
			dateStart = formatter.parse(start);
			dateFinish = formatter.parse(ending);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		DataBaseController b = new DataBaseController();
		List<Deal> ds = b.getListOfDealsBetweenDates(start, ending);
		
		System.out.println(dateStart);
		System.out.println(dateFinish);
		
		for(Deal d:ds){
			System.out.println(d.getDateoftransportation());
		}
		
	}
}
