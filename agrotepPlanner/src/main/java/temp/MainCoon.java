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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.model.CalendarTruckHtml;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
import box.model.History;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;


public class MainCoon {

	public static void main(String[] args){
		
		int truckid = 1;
		String dateStart = "2021-05-11";
		

		
		double longitude = 46.445911;
		double latitude = 30.711748;
		
		

		
		DataBaseController base = new DataBaseController(); 
		
		Route lastRoute = base.getLastRouteByTruckId(truckid, dateStart);
		
		GoogleLogic google = new GoogleLogic();
		System.out.println(lastRoute.getId());
		System.out.println(lastRoute.getToLon());
		System.out.println(lastRoute.getToLat());
		System.out.println(48.340664);
		System.out.println(25.947644);
		
		//int priceForKilometr = google.calculateDistanceInKmBetweenCoordinates(lastRoute.getToLon(), lastRoute.getToLat(), longitude, latitude);
       // System.out.println(priceForKilometr);
        
        int totalPrice = 8000;
		int kilometrs = google.calculateDistanceInKmBetweenCoordinates(lastRoute.getToLon(), lastRoute.getToLat(), longitude, latitude);
        int priceForKilometr1 =totalPrice/kilometrs;
        
        System.out.println(priceForKilometr1);


		List<Client> clientsFromBase = base.getListOfClients();
		List<ClientForRouteHTML> clients = new ArrayList();
		
		for(Client c:clientsFromBase){
			
			if(base.isClientHasOblastFromByDirection(c.getId(), lastRoute.getToOblast())){
			ClientForRouteHTML client = new ClientForRouteHTML();
			
			
			client.setCargo(c.getCargo());
			client.setCompany(c.getCompany());
			client.setId(c.getId());			
			client.setTypetruck(c.getTypetruck());
			
			List<Direction> directions = base.getListOfDirectionsByOblastAndClientid(c.getId(), lastRoute.getToOblast());
			String whereWeCanGo ="";
				for(Direction d:directions){
					whereWeCanGo = whereWeCanGo+d.getOblastTo()+" ";
				}
			
			
			client.setPosibilityToGo(whereWeCanGo);
			
			String blacklist = "";
			if(c.getBlacklist()==Constants.CLIENT_IN_BLACK_LIST){
				blacklist = "w3-red";
			}
			client.setBlacklist(blacklist);
			
			clients.add(client);
			}
			
		}

	}

}
