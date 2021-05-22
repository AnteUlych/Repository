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
import box.model.HistoryHTML;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;


public class MainCoon {

	public static void main(String[] args){
		//HttpSession session = request.getSession();
		//String name = (String) session.getAttribute("name");
		
        CalendarLogic calendar = new CalendarLogic();	
		String start = calendar.getNeedoneDayForDataBasePlusDays(0);
		String finish = calendar.getNeedoneDayForDataBasePlusDays(1);
		
		DataBaseController base = new DataBaseController(); 
		
		List<Truck> trucks = base.getListOfTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
			HistoryHTML histories = new HistoryHTML();
			
			histories.setDriver(t.getDriver());
			histories.setManagerName(t.getManagerName());
			histories.setTracktor(t.getTracktor());
			histories.setTrailer(t.getTrailer());
			
			List<Route> routes = base.getListOfRoutesBetweenDatesByTruckId(t.getId(), start, finish);
			
			histories.setRoutes(routes);
			
			for(Route r:routes){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				System.out.println(datetext);
				dateText.add(datetext);
			}
			
			histories.setDates(dateText);
			
			trucksHTML.add(histories);
			
			
			
		}
		
		
	
		
	}

}
