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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import box.logic.CalendarLogic;
import box.logic.City;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.model.CalendarTruckHtml;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
import box.model.History;
import box.model.HistoryHTML;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;
import box.model.VariantsHtml;


public class MainCoon {

	public static void main(String[] args){
		
		DataBaseController base = new DataBaseController();
		String p = base.getCircleParametrByRoutes(13, "2021-07-09");
		//List<Route> cs = base.getLastTenRoutesByTruckId(10, "2021-07-09");
		
		//for(Route c:cs){
			System.out.println(p);
		//}
		
	/**
		int needPriceForKm = 17;
		String city = "Черкаси";
		String oblast = "Черкаська область";
		
		double longitude = 49.408268;
		double latitude = 32.016262;
		

		
		DataBaseController base = new DataBaseController();
		List<VariantsHtml> listOfVariants = new ArrayList();

				VariantsHtml v1 = new VariantsHtml(); 		
				v1.setNextClients(1);
				listOfVariants.add(v1);
				
				VariantsHtml v2 = new VariantsHtml(); 		
				v2.setNextClients(3);
				listOfVariants.add(v2);
				
				VariantsHtml v3 = new VariantsHtml(); 		
				v3.setNextClients(1);
				listOfVariants.add(v3);
	
		
				for(VariantsHtml v:listOfVariants){
					System.out.println(v.getNextClients());
				}
				
				*/	
               
		
		
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
