package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

import org.springframework.http.HttpRequest;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.model.CalendarTruckHtml;
import box.model.Direction;
import box.model.History;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;


public class MainCoon {

	public static void main(String[] args) throws IOException {
		
		Double longitudeFrom = 50.4851493;
		Double latitudeFrom = 30.4721233;
		Double longitudeTo = 50.3701007;
		Double latitudeTo = 28.6271224;
		
		GoogleLogic google = new GoogleLogic();
		System.out.println(google.calculateDistanceInKmBetweenCoordinates(54.0, 29.0, 51.0, 28.0));
		
		String googleKey = "AIzaSyDvzr8p07fENAftZAumRG2tdfOE8VJQDwE";
		
			/**
		String requestUrl = "https://maps.googleapis.com/maps/api/distancematrix/json?units=metric&origins="+longitudeFrom+","+latitudeFrom+"&destinations="+longitudeTo+","+latitudeTo+"&key="+googleKey;

		
	    URL url = new URL(requestUrl);
        URLConnection connection = url.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                		connection.getInputStream()));
     //   StringBuilder sb = new StringBuilder();
        String inputLine;
        String resultURL = "";
        while ((inputLine = in.readLine()) != null){ 
        	
        	System.out.println(inputLine);
        	if(inputLine.contains("value")){
        		resultURL = inputLine;
        		break;
        	}
        }
        in.close();
         
        resultURL = resultURL.replaceAll("\\s+","").replaceAll("\"value\":", "");
         
        int distance = Integer.parseInt(resultURL);  
        System.out.println(distance);
	*/
	}

}
