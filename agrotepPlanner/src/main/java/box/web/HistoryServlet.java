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
import box.logic.DataBaseController;
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
				dateText.add(datetext);
			}
			
			histories.setDates(dateText);
			
			trucksHTML.add(histories);
		
		}
		
		base.closeConnection();
		
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
				dateText.add(datetext);
			}
			
			histories.setDates(dateText);
			
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
