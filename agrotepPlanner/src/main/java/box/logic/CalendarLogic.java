package box.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import box.model.Route;

public class CalendarLogic {

	String pattern = "yyyy-MM-dd";
	DateFormat df = new SimpleDateFormat(pattern);
	
	public List<String> convertRoutesCircle(List<Route> routes){
		
		List <String> dates = new ArrayList();
				
		for(Route r:routes){
			
			Date date = r.getFromDate();
			DateFormat df = new SimpleDateFormat("dd.MM");      
			String stringDate = df.format(date);
			
			dates.add(stringDate);
		}
		
		return dates;
		
	}
	
	public Date addToStringOneMinute(String stringDate){
		
		try {
			
			Date	date = df.parse(stringDate);
			Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.add(Calendar.MINUTE, 1);
	        
	        return calendar.getTime();
	        
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Date changeStringToDate(String stringDate){		
	
		try {
			
			Date	date = df.parse(stringDate);
			return date;
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getNeedoneDayForDataBasePlusDays(int plusDay) {

		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.add(Calendar.DATE, plusDay);
		Date needDate = c.getTime();
		String textDay = df.format(needDate);
		return textDay;

	}
	
	public String getFirstDateOfThatMounth() {

		Date today = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(today);
		c.set(Calendar.DAY_OF_MONTH, 1);
		Date needDate = c.getTime();
		String textDay = df.format(needDate);
		return textDay;

	}

	public boolean isDayTheWeekend(String stringDay) {

		try {

			Calendar calendar = Calendar.getInstance();
			Date date = df.parse(stringDay);
			calendar.setTime(date);

			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

			if ((dayOfWeek == Calendar.SATURDAY)
					|| (dayOfWeek == Calendar.SUNDAY)) {
				return true;
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String getHeaderDate(String stringDay) {
		
		try {
			String patternHeader = "dd/MM";
			Calendar calendar = Calendar.getInstance();
			Date date = df.parse(stringDay);

			DateFormat dfHeader = new SimpleDateFormat(patternHeader);
			String headerSecondPart = dfHeader.format(date);

			calendar.setTime(date);

			int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

			String headerFirstPart = "";

			if (dayOfWeek == Calendar.MONDAY) {
				headerFirstPart = "понед≥лок";
			} else if (dayOfWeek == Calendar.TUESDAY) {
				headerFirstPart = "в≥второк";
			} else if (dayOfWeek == Calendar.WEDNESDAY) {
				headerFirstPart = "середа";
			} else if (dayOfWeek == Calendar.THURSDAY) {
				headerFirstPart = "четвер";
			} else if (dayOfWeek == Calendar.FRIDAY) {
				headerFirstPart = "п'€тниц€";
			} else if (dayOfWeek == Calendar.SATURDAY) {
				headerFirstPart = "субота";
			} else if (dayOfWeek == Calendar.SUNDAY) {
				headerFirstPart = "нед≥л€";
			}
			
			return headerFirstPart + "<br>" + headerSecondPart;

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

}
