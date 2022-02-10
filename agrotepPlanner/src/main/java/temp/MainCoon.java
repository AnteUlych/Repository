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
		
	    int days = calendar.calculateWorkingDaysBetweenDates(start, finish);
			
		DataBaseController base = new DataBaseController(); 
 		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		List<HistoryHTML> trucksHTMLtilt = new ArrayList();
		List<HistoryHTML> trucksHTMLref = new ArrayList();
		List<HistoryHTML> trucksHTMLbox = new ArrayList();
		
		
		for(Truck t:trucks){
			HistoryHTML histories = new HistoryHTML();
			
			histories.setDriver(t.getDriver());
			histories.setManagerName(t.getManagerName());
			histories.setTracktor(t.getTracktor());
			histories.setTrailer(t.getTrailer());
			
			List<Route> routes = base.getListOfRoutesBetweenDatesByTruckIdForHistory(t.getId(), start, finish);
			
			histories.setRoutes(routes);
			
			int totalUAH = 0; 
			int totalStops = 0;
			int totalColona = 0;
			int totalRemont = 0;
			
			for(Route r:routes){		
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
			}
			
			RuptelaLogic ruptela = new RuptelaLogic();
			int totalKm = ruptela.getKmFromRuptela(start, finish, t.getTruckKey());
			
			double totalUAHforKm = (int)(Math.round((double)totalUAH/(double)totalKm * 100))/100.0; 
			
			histories.setTotalUAHforKm(totalUAHforKm); 
			histories.setTotalUAH(totalUAH); 
			histories.setTotalKm(totalKm);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			
			int workdays = days-totalStops-totalColona-totalRemont;
			if(workdays==0){
				workdays=-1;
			}
			int kmday = totalKm/workdays;
			histories.setAvarageKmDay(kmday);
			histories.setTotalWork(workdays);
			
			trucksHTML.add(histories);
			
			if(t.getType().equals("тент")){
				trucksHTMLtilt.add(histories);
			}else 
			
			if(t.getType().equals("реф")){
				trucksHTMLref.add(histories);
			}else
			
			if(t.getType().equals("цільномет")){
				trucksHTMLbox.add(histories);
			}
		
		}
		
	
		StatisticKPI tiltKPI = calculateKPI("тент", start, finish, days, trucksHTMLtilt);
		StatisticKPI refKPI  = calculateKPI("реф", start, finish, days, trucksHTMLref);
		StatisticKPI boxKPI  = calculateKPI("цільномет", start, finish, days, trucksHTMLbox);
		
		List<StatisticKPI> trucksKPI = new ArrayList();
		trucksKPI.add(tiltKPI);
		trucksKPI.add(refKPI);
		trucksKPI.add(boxKPI);
		
		StatisticKPI totalKPI = calculateKPI("", start, finish, days, trucksHTML);
		
		
		
		System.out.println(totalKPI.getIndicator()+" "+totalKPI.getKm()+" "+totalKPI.getKmday()+" "+totalKPI.getUahkm());
		System.out.println(tiltKPI.getIndicator()+" "+tiltKPI.getKm()+" "+tiltKPI.getKmday()+" "+tiltKPI.getUahkm());
		System.out.println(refKPI.getIndicator()+" "+refKPI.getKm()+" "+refKPI.getKmday()+" "+refKPI.getUahkm());
		System.out.println(boxKPI.getIndicator()+" "+boxKPI.getKm()+" "+boxKPI.getKmday()+" "+boxKPI.getUahkm());
		
		for(StatisticKPI t: trucksKPI){
			System.out.println(t.getIndicator());
		}
		  
		List<StatisticKPI> managersKPI = new ArrayList();
		List<Manager> managers = base.getListOfManagers();
		for(Manager m:managers){
			
			if(base.isManagerHasReadyTruck(m.getId())){
			List<HistoryHTML> managerHistoryHTML = new ArrayList();
		      for(HistoryHTML h:trucksHTML){
			  if(h.getManagerName().equals(m.getName())){
				  managerHistoryHTML.add(h);
			  }
		      }
		      StatisticKPI managerKPI = calculateKPI(m.getName(), start, finish, days, managerHistoryHTML);
		      managersKPI.add(managerKPI);
		}
		
		}
		
		for(StatisticKPI mkpi:managersKPI){
			System.out.println(mkpi.getIndicator()+" - "+mkpi.getKm());
		}
		
		base.closeConnection();
	}
		
	private static StatisticKPI calculateKPI(String name, String start,
			String finish, int days, List<HistoryHTML> trucksHTML) {
		
		 String indicator = name;
	     double uahkm = 0;
	     int kmday = 0;
	     int km = 0;
	     int totalStops = 0;
	     int totalColona = 0;
	     int totalRemont = 0;
	     int totalWork = 0;
	
	     
	     int notConnectedTrucks = 0;
		 
		StatisticKPI kpi = new StatisticKPI();
				
		kpi.setIndicator(indicator);
		
		if(trucksHTML.size()==0){
			
			kpi.setKm(0);
			kpi.setUahkm(0);
			kpi.setKmday(0);
			kpi.setTotalWork(0);
			kpi.setTotalStops(0);
			kpi.setTotalRemont(0);
			kpi.setTotalColona(0);
		    kpi.setPercentLogisticColonaRemomt(0);
		    kpi.setPercentLogisticNoStops(0);
		    
		    return kpi;
			
		}
		
		for(HistoryHTML h:trucksHTML){
			
			uahkm = uahkm+h.getTotalUAHforKm();
			kmday = kmday+h.getAvarageKmDay();
			km = km+h.getTotalKm();
			totalStops = totalStops+h.getTotalStops();
			totalColona = totalColona+h.getTotalColona();
			totalRemont = totalRemont+h.getTotalRemont();
			totalWork = totalWork+h.getTotalWork();
			
			
			if(h.getTotalKm()<10){
				notConnectedTrucks++;
			}	
		}

		kpi.setTrucks(trucksHTML.size());
		
		if(km==0||days==0||trucksHTML.size()-notConnectedTrucks==0){
			
			kpi.setKm(0);
			kpi.setUahkm(0);
			kpi.setKmday(0);
			
		}else{
			
			kpi.setKm(km/(trucksHTML.size()-notConnectedTrucks));
			kpi.setUahkm((int)(Math.round((double)uahkm/(double)(trucksHTML.size()-notConnectedTrucks) * 100))/100.0);
			kpi.setKmday(kmday/(trucksHTML.size()-notConnectedTrucks)); 
		
		}
		
		kpi.setTotalWork(totalWork);
		kpi.setTotalStops(totalStops);
		kpi.setTotalRemont(totalRemont);
		kpi.setTotalColona(totalColona);
		
	    int percentLogisticColonaRemomt = (int) (100*((double)totalWork/(double)(totalWork+totalStops+totalRemont+totalColona)));
	    int percentLogisticNoStops  = (int) (100*((double)totalWork/(double)(totalWork+totalStops)));
	    
	    kpi.setPercentLogisticColonaRemomt(percentLogisticColonaRemomt);
	    kpi.setPercentLogisticNoStops(percentLogisticNoStops);
		
		return kpi;
	}

	
}
