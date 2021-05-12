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
		
		//GoogleLogic g = new GoogleLogic();
		//int i  = g.calculateDistanceInKmBetweenCoordinates(50.426202, 30.415924, 46.482526, 30.7233095);
		DataBaseController b = new DataBaseController();
	  //  b.deleteRoute(13);
	}

}
