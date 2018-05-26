package box.logic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class BeltService {
	
	DataBase base = new DataBase();
	String separator = "\\|";
	int timeToWH = 11;
	
	public String getClientInfo(String name){
		
        List<String> data = base.getClientsBase();
		
		String info = "";
		for(String client:data){
			if(client.contains(name)){
				info = client;
				break;
			}			
		}
		data = null;
		return info;
	}
	
	public String getPrice(String address, String pallets){
		
		int number = Integer.parseInt(pallets);
		List<String> data = base.getData();
		
		String direction = "";
		for(String route:data){
			if(route.contains(address)){
				direction = route;
				break;
			}			
		}
		data = null;
		
		String [] course = direction.split(separator);
		String price = course[number];
		
		if(address.contains("Ulucak")||address.contains("Istambul")||address.contains("Bolgesi")){
			return price + " USD";
		}
		
		return price + " euro";
	}
	
	public String getDeliveryDate(String address, String pickUpDate){
		
		try {
			
		List<String> data = base.getData();
		String direction = "";
		for(String route:data){
			if(route.contains(address)){
				direction = route;
				break;
			}			
		}
		data = null;
		
		String [] course = direction.split(separator);
		String time = course[timeToWH];
		int deliveryToWH = Integer.parseInt(time);
		
		 DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		 Calendar freightPickUp = Calendar.getInstance();
		 freightPickUp.setTime(df.parse(pickUpDate));
		 freightPickUp.add(Calendar.DATE, deliveryToWH);
		 
		 Date deliveryDate = freightPickUp.getTime();
		 LocalDate deliveryLocalDate = deliveryDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		 LocalDate friday = deliveryLocalDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		 LocalDate monday = friday.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		 
		 String destination =
		     DateFormat.getDateInstance(SimpleDateFormat.MEDIUM, new Locale("en")).format(Date.from(monday.atStartOfDay(ZoneId.systemDefault()).toInstant()));
		 return "in Kyiv on " + destination;
		 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "select the pick-up date";
	}

}
