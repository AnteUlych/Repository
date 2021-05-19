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
		
		GoogleLogic g = new GoogleLogic();
		CalendarLogic calendar = new CalendarLogic();
		//int i  = g.calculateDistanceInKmBetweenCoordinates(50.426202, 30.415924, 45.182872, 33.726518);
		//String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		//String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		
		DataBaseController db = new DataBaseController();
		List<Route> rs =db.getListOfRoutesByRouteStatusBetweenDates(0, "2020-05-11", "2021-05-29");
		for(Route r:rs){
			System.out.println(r.getId()+" "+r.getFromDate()+" "+r.getRouteStatus());	
		}
		//System.out.println(secondDay);
		
		//base.editTruckById(2, "Вася Л", 3, 1, "2323333", "KK9090KK", "ТТ5555ЖЖ", "реф");
	
		
	
		
	}

}
