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
import box.model.History;
import box.model.HistoryHTML;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;
import box.model.VariantsHtml;


public class MainCoon {

	public static void main(String[] args){
		
			//String requestUrl = "https://api.fm-track.com/objects/a7bad126-1436-11eb-809d-ffcd6f0d46e5/coordinates?version=2&from_datetime=2021-02-15T00:00:01.000Z&to_datetime=2021-02-15T03:00:00.000Z&api_key=A82MBFH6QijEY1RnKTkDL-u3uqdm9nJS";
		
		DataBaseController db = new DataBaseController();
		
		db.editTruckKmruptela0131tById(16, 101, 101);
		
		System.out.println("done");
		
		/**
		RuptelaLogic rl = new RuptelaLogic();
		
		List <String> list = new ArrayList();
		
		list.add("7088ac5a-1dc7-11e7-8fff-6be60e3f0f4f");
		list.add("7084b6ea-1dc7-11e7-b700-e71228f967fa");
		list.add("7088abe2-1dc7-11e7-8ffe-eb26ed606264");
		list.add("7088a764-1dc7-11e7-8ff6-e3465b6c4a13");
		list.add("7088a9bc-1dc7-11e7-8ffa-d3c2bb3613ee");
		list.add("7088aa16-1dc7-11e7-8ffb-53aa49034c67");
		list.add("70ce8b6c-1dc7-11e7-b43c-a73941e7a1ae");
		list.add("70bfe01c-1dc7-11e7-9118-77f0279a43b1");
		list.add("708196c2-1dc7-11e7-af6b-2710768fc626");
		list.add("7081923a-1dc7-11e7-af5f-2bcaec080159");
		list.add("70cbd76e-1dc7-11e7-ad96-a3638a2e0c99");
		list.add("18ba5e90-b6dc-11ea-be11-176ca3215e69");
		list.add("70ce34fa-1dc7-11e7-b36b-43589bf70017");
		list.add("710c224c-1dc7-11e7-8a99-9770d23108e3");
		list.add("70fdee84-1dc7-11e7-b010-cb46444fc31a");
		list.add("70cf5cd6-1dc7-11e7-b63e-3f806aaf1ca4");
		list.add("70e66ec6-1dc7-11e7-8d90-67afcb8cfc45");
		list.add("7085cc1a-1dc7-11e7-b992-bf0f96eabafc");
		list.add("70e23d92-1dc7-11e7-bc1c-db6211ad1b51");
		list.add("70b6ddd2-1dc7-11e7-bdc5-8749ad02fe71");
		list.add("70b67e6e-1dc7-11e7-bcda-cbf9dfb53423");
		list.add("708409de-1dc7-11e7-b563-3b267d4e0c24");
		list.add("7082d73a-1dc7-11e7-b290-9f53cb765d60");
		list.add("7079dd24-1dc7-11e7-9bf9-eb3206152427");
		list.add("70a5ee46-1dc7-11e7-9f35-fb7f67f84b44");
		list.add("5aab2568-25bd-11e7-8650-b3f35398fc14");
		list.add("70ca027c-1dc7-11e7-a929-f7da244a3b1c");
		list.add("7084bdde-1dc7-11e7-b712-8b7655c9ac80");
		list.add("70bfcfe6-1dc7-11e7-90f2-0301537f64bb");
		list.add("71004be8-1dc7-11e7-b39f-6b6e6c7d92cd");
		list.add("70d9acb8-1dc7-11e7-a83c-ef93fff3fb1f");
		list.add("7084c568-1dc7-11e7-b723-c3636d07b8df");
		list.add("70ca504c-1dc7-11e7-a9e2-177042688791");
		list.add("70cbb842-1dc7-11e7-ad47-67cdc3a44863");
		list.add("70dddc98-1dc7-11e7-b255-d701bf5ac5b0");

		
		//String key = "7088ac5a-1dc7-11e7-8fff-6be60e3f0f4f";
		
		for(String k:list){
			System.out.println(rl.getKmFromRuptela("2021-08-01", "2021-08-28", k));
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
