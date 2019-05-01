package lotos.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SimpleLogic {
	
	public String fixDateInString(){
		
		String pattern = "HH:mm MM.dd.yyyy";
		DateFormat df = new SimpleDateFormat(pattern);
		Date today = Calendar.getInstance().getTime();        
		String todayAsString = df.format(today);
		
		return todayAsString;
		
	}

}
