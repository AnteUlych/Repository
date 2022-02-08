package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import box.logic.CalendarLogic;
import box.logic.City;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.logic.RuptelaLogic;
import box.model.CalendarTruckHtml;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
import box.model.Documents;
import box.model.Garant;
import box.model.History;
import box.model.HistoryHTML;
import box.model.Manager;
import box.model.Route;
import box.model.StatisticKPI;
import box.model.Truck;
import box.model.VariantsHtml;


public class MainCoon {

	public static void main(String[] args) throws ParseException{
		
CalendarLogic calendar = new CalendarLogic();
		
		String start = calendar.getFirstDateOfThatMounth();
		String finish = calendar.getNeedoneDayForDataBasePlusDays(0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	    		
	    Date firstDate = sdf.parse(start);
	    Date secondDate = sdf.parse(finish);
			

	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    int days = (int) diff;
			
		DataBaseController base = new DataBaseController(); 
 		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
			HistoryHTML histories = new HistoryHTML();
			
			histories.setDriver(t.getDriver());
			histories.setManagerName(t.getManagerName());
			histories.setType(t.getType());
			histories.setTracktor(t.getTracktor());
			histories.setTrailer(t.getTrailer());
			
			List<Route> routes = base.getListOfRoutesBetweenDatesByTruckId(t.getId(), start, finish);
			
			histories.setRoutes(routes);
			
			int totalUAH = 0; 
			int totalStops = 0;
			int totalColona = 0;
			int totalRemont = 0;
			int totalWork = 0;
			
			for(Route r:routes){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				dateText.add(datetext);
			
				totalUAH = totalUAH + r.getPrice(); 
				
				if(r.getRouteStatus()==Constants.TRUCK_NOT_READY){
					totalStops=totalStops+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_COLONA){
					totalColona=totalColona+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_REMOMT){
					totalRemont=totalRemont+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_READY||r.getRouteStatus()==Constants.TRUCK_REPEAT){
					totalWork = totalWork+1;
				}
			}
			
			RuptelaLogic ruptela = new RuptelaLogic();
			int totalKm = ruptela.getKmFromRuptela(start, finish, t.getTruckKey());
			
			double totalUAHforKm = (int)(Math.round((double)totalUAH/(double)totalKm * 100))/100.0; 
			
			histories.setTotalUAHforKm(totalUAHforKm); 
			histories.setTotalUAH(totalUAH); 
			histories.setTotalKm(totalKm);
			histories.setDates(dateText);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			histories.setTotalWork(totalWork);
			
			trucksHTML.add(histories);
		
		}
		
		//before was history and no start statistic
		
		StatisticKPI refKPI = calculateKPIbyTruckType(days, trucksHTML, "цільномет");
		
		
		
		//
	
		
		base.closeConnection();
		
		
			System.out.println(refKPI.getIndicator()+" "+refKPI.getTrucks());
		
		    
	}
		
	private static StatisticKPI calculateKPIbyTruckType(int days, List<HistoryHTML> trucksHTML,
			String typeOftruck) {
		int km = 0;
		double uahkm = 0;
		//int kmday = 0;
		 
    	int totalStops = 0;
		int totalColona = 0;
		int totalRemont = 0;
		//int percentLogisticColonaRemomt = 0;
		//int percentLogisticNoStops = 0;
		
		int totalWork = 0;
		int count = 0;
		//int countOfTrucks = 0;
		
		StatisticKPI truckKpi = new StatisticKPI();
		
		for(HistoryHTML th : trucksHTML){
			if(th.getType().equals(typeOftruck)){
				
			count++;
			
			km = km+th.getTotalKm();
			uahkm = uahkm+th.getTotalUAHforKm();
			totalStops = totalStops+th.getTotalStops();
			totalColona = totalColona + th.getTotalColona();
			totalRemont = totalRemont + th.getTotalRemont();
			totalWork = totalWork + th.getTotalWork();
		}
		}
		
		if(count==0){
			truckKpi.setIndicator(typeOftruck);
			truckKpi.setKm(0);
			truckKpi.setKmday(0);
			truckKpi.setTotalColona(0);
			truckKpi.setTotalRemont(0);
			truckKpi.setTotalStops(0);
			truckKpi.setTotalWork(0);
			truckKpi.setUahkm(0);

			truckKpi.setPercentLogisticColonaRemomt(0);
			truckKpi.setPercentLogisticNoStops(0);
			truckKpi.setTrucks(count);
			
			return truckKpi;
		}
		
		truckKpi.setIndicator(typeOftruck);
		truckKpi.setKm(km/count);
		truckKpi.setKmday(km/(days-totalColona-totalRemont));
		truckKpi.setTotalColona(totalColona);
		truckKpi.setTotalRemont(totalRemont);
		truckKpi.setTotalStops(totalStops);
		truckKpi.setTotalWork(totalWork);
		truckKpi.setUahkm((Math.round((double)uahkm/(double)count * 100))/100.0);
		double percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
		double percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));
		truckKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
		truckKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
		truckKpi.setTrucks(count);
	
		return truckKpi;
	}
		

	
	   private static VariantsHtml calculateTheVariant(double cityLongitude, double cityLatitude, int cityCity, String cityName, DataBaseController base, int needPriceForKm, String oblast, String city, double longitude, double latitude){
			
			GoogleLogic google = new GoogleLogic();
			
	        VariantsHtml variant = new VariantsHtml();
			
			variant.setFinishPoint(City.KYIV_NAME); //not change
			variant.setFinishPrice((int) Math.round(cityCity*google.correctkilometr*needPriceForKm));
			List<Client> nextClients = base.getListOfClientsByOblastFtomAndOblastTo(cityName, City.KYIV_NAME);
			variant.setListNextClients(nextClients);
			List<Client> startClients = base.getListOfClientsByOblastFtomAndOblastTo(oblast, cityName);
			variant.setListStartClients(startClients);
			variant.setNextClients(nextClients.size());
			variant.setNextPoint(cityName);
			
			int distanceOfVariant = google.calculateDistanceInKmBetweenCoordinates(longitude, latitude, cityLongitude, cityLatitude);
			int priceOfVariant = distanceOfVariant*needPriceForKm;
			
			variant.setNextPrice(priceOfVariant);
			variant.setStartAddress(city+", "+oblast);
			variant.setStartClients(startClients.size());
			
			return variant;
		}

}
