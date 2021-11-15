package box.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.RuptelaLogic;
import box.model.HistoryHTML;
import box.model.Route;
import box.model.Truck;

@Controller
@RequestMapping("/history")
public class HistoryServlet {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
        CalendarLogic calendar = new CalendarLogic();	
		String start = calendar.getNeedoneDayForDataBasePlusDays(-6);
		String finish = calendar.getNeedoneDayForDataBasePlusDays(0);
		
		DataBaseController base = new DataBaseController(); 
		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
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
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				dateText.add(datetext);
			
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
			histories.setDates(dateText);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			
			trucksHTML.add(histories);
		
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("name", name);
		model.addAttribute("trucksHTML", trucksHTML);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		return "history";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
        CalendarLogic calendar = new CalendarLogic();	
        String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		
		DataBaseController base = new DataBaseController(); 
		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
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
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				dateText.add(datetext);
	
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
			histories.setDates(dateText);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			
			trucksHTML.add(histories);
		
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("trucksHTML", trucksHTML);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		return "history";
		
	}

}
