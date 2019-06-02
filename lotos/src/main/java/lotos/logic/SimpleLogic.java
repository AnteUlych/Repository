package lotos.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class SimpleLogic {
	
	public String fixDateInString(){
		
		String pattern = "HH:mm MM.dd.yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);
		
		return todayAsString;
		
	}
	
        public Date convertStringToDate(String string){
        	try {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(string);
	
		return date;
        	} catch (ParseException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
			return new Date();
	}

}
