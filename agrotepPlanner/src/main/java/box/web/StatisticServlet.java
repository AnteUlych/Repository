package box.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Route;
import box.model.Statistic;

@Controller
@RequestMapping("/statistic")
public class StatisticServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		CalendarLogic calendar = new CalendarLogic();
		
		String start = calendar.getNeedoneDayForDataBasePlusDays(0);
		String finish = calendar.getNeedoneDayForDataBasePlusDays(1);
		
		DataBaseController base = new DataBaseController(); 
		
		List<Manager> managers = base.getListOfManagers();
		List<Statistic> statistics = new ArrayList();
		
		for(Manager m:managers){
			
			Statistic s = new Statistic();
			
			int idOfManager = m.getId();
			String managerName = m.getName();
			int numberOfCalculating = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_CALCULATE).size();
			int numberOfbooking = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_BOOKING).size();
			int numberOfHelp = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_HELP).size();
			int numberOfDeletes = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_DELETE).size();
			int numberOfNewClients = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_NEW_CLIENT).size();
			
			s.setId(idOfManager);
			s.setManagerName(managerName);
			s.setNumberOfbooking(numberOfbooking);
			s.setNumberOfCalculating(numberOfCalculating);
			s.setNumberOfDeletes(numberOfDeletes);
			s.setNumberOfHelp(numberOfHelp);
			s.setNumberOfNewClients(numberOfNewClients);
			
			statistics.add(s);
		}
		
		List<Route> routes = base.getListOfRoutesByRouteStatusBetweenDates(Constants.TRUCK_READY, start, finish);
		
		int totalTransportations = routes.size();
		int totalPricesForKm = 0;
		for(Route r:routes){
			totalPricesForKm = totalPricesForKm+r.getPiceForKilometr();
		}
		int  avaragePricesForKm;
		if(totalTransportations==0){
			avaragePricesForKm = 0;
		}else{
			avaragePricesForKm = (totalPricesForKm/totalTransportations);
		}
		
		int avaragePricesForKmInPercent = avaragePricesForKm*3;
		
		String colorkm = "w3-red";
		if(avaragePricesForKm>18){
			colorkm = "w3-green";
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("statistics", statistics);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		model.addAttribute("avaragePricesForKm", avaragePricesForKm);
		model.addAttribute("avaragePricesForKmInPercent", avaragePricesForKmInPercent);
		
		model.addAttribute("colorkm", colorkm);
		
		return "statistic";
		
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");;
		
		DataBaseController base = new DataBaseController(); 
		
		List<Manager> managers = base.getListOfManagers();
		List<Statistic> statistics = new ArrayList();
		
		for(Manager m:managers){
			
			Statistic s = new Statistic();
			
			int idOfManager = m.getId();
			String managerName = m.getName();
			int numberOfCalculating = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_CALCULATE).size();
			int numberOfbooking = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_BOOKING).size();
			int numberOfHelp = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_HELP).size();
			int numberOfDeletes = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_DELETE).size();
			int numberOfNewClients = base.getListOfHistoryByActionAndManageridBetweenDates(start, finish, m.getId(), Constants.ACTION_NEW_CLIENT).size();
			
			s.setId(idOfManager);
			s.setManagerName(managerName);
			s.setNumberOfbooking(numberOfbooking);
			s.setNumberOfCalculating(numberOfCalculating);
			s.setNumberOfDeletes(numberOfDeletes);
			s.setNumberOfHelp(numberOfHelp);
			s.setNumberOfNewClients(numberOfNewClients);
			
			statistics.add(s);
		}
		
		List<Route> routes = base.getListOfRoutesByRouteStatusBetweenDates(Constants.TRUCK_READY, start, finish);
		
		int totalTransportations = routes.size();
		int totalPricesForKm = 0;
		for(Route r:routes){
			totalPricesForKm = totalPricesForKm+r.getPiceForKilometr();
		}
		int  avaragePricesForKm;
		if(totalTransportations==0){
			avaragePricesForKm = 0;
		}else{
			avaragePricesForKm = (totalPricesForKm/totalTransportations);
		}
		
		int avaragePricesForKmInPercent = avaragePricesForKm*3;
		
		String colorkm = "w3-red";
		if(avaragePricesForKm>18){
			colorkm = "w3-green";
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("statistics", statistics);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		model.addAttribute("avaragePricesForKm", avaragePricesForKm);
		model.addAttribute("avaragePricesForKmInPercent", avaragePricesForKmInPercent);
		
		model.addAttribute("colorkm", colorkm);
		
		return "statistic";
		
		
	}
}
