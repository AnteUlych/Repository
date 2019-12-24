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
import box.model.Contract;
import box.model.Deal;
import box.model.Manager;
import box.model.Message;
import box.model.Proposition;
import box.model.Sold;

public class MainTest {

	public static void main(String[] args) {
		
	    //DataBaseController base = new DataBaseController();
		Date today = new Date();
		Calendar cal = Calendar.getInstance();

		cal.setTime(today);
		System.out.println(cal.getTime());
		
		System.out.println();
		cal.add(Calendar.DAY_OF_YEAR, -7);	
		//System.out.println(cal.getTime());
		
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);	
		System.out.println(cal.getTime());
		/**
		String lastMonday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);	
		System.out.println(cal.getTime());
		
		String lastTuesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);	
		System.out.println(cal.getTime());
		
		String lastWednesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);	
		System.out.println(cal.getTime());
		
		String lastThursday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String lastFriday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String lastSaturday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);	
		System.out.println(cal.getTime());
		
		String lastSunday = getDateInString(cal);
	
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentMonday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);	
		System.out.println(cal.getTime());
		
		String presentTuesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentWednesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentThursday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentFriday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentSaturday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String presentSunday = getDateInString(cal);
		// 30 не вик оф ер - змынити алгоритм
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextMonday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextTuesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextWednesday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextThursday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextFriday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextSaturday = getDateInString(cal);
		cal.add(Calendar.DAY_OF_YEAR, 1);
		System.out.println(cal.getTime());
		
		String nextSunday = getDateInString(cal);
		*/
		//System.out.println(calendar.getFirstDayOfWeek());
		
		
	}
	
private static String getDateInString(Calendar cal){
		       
        Date date = cal.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM");
        String dateString = dateFormat.format(date);
        
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        
        String resultWeek = "";
        
        if(dayOfWeek==1){
        	resultWeek = "нед≥л€, ";
        }else if(dayOfWeek==2){
        	resultWeek = "понед≥лок, ";
        }else if(dayOfWeek==3){
        	resultWeek = "в≥второк, ";
        }else if(dayOfWeek==4){
        	resultWeek = "середа, ";
        }else if(dayOfWeek==5){
        	resultWeek = "четвер, ";
        }else if(dayOfWeek==6){
        	resultWeek = "п'€тниц€, ";
        }else if(dayOfWeek==7){
        	resultWeek = "суббота, ";
        }
        System.out.println(resultWeek+dateString);
        System.out.println();
		return resultWeek+dateString;
	}
}
