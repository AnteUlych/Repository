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
import box.model.Truck;
import box.model.VariantsHtml;


public class MainCoon {

	public static void main(String[] args){
	
		DataBaseController b = new DataBaseController();
	    List <Route> rs = b.getListOfRoutesBetweenDatesByTruckIdForHistory(29, "2021-11-01", "2021-11-15");
	    
	    for(Route r:rs){
	    	System.out.println(r.getFromDate()+" "+r.getInfo());
	    }

			
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
