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

	public static void main(String[] args) {
		
		int r = new RuptelaLogic().getKmFromRuptela("2022-06-01", "2022-06-21", "70d9acb8-1dc7-11e7-a83c-ef93fff3fb1f");
		System.out.println(r);
	//	String answer = r.getLocation("5d42733a-1e1e-11e8-bd6a-8326186e25a0");
		//String answer = r.getLocation("70dd5a98-1dc7-11e7-b131-a3a8f7f0e4d9");
	//	System.out.println();
	//	System.out.println(answer);
	}

	
}
