package box.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.RuptelaLogic;
import box.model.HistoryHTML;
import box.model.Route;
import box.model.Truck;

@Controller
public class HistoryExcelServlet {
	
	@RequestMapping(value = "/historyexcel/{somecode}", method = RequestMethod.GET)
	public String doGet(@PathVariable("somecode") String somecode,
			ModelMap model, HttpServletRequest request) {
		
		String code [] = somecode.split("&_");
				
		String start = code[0];
		String finish = code[1];;
		
		DataBaseController base = new DataBaseController(); 
		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
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
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			
			trucksHTML.add(histories);
		
		}
		
		base.closeConnection();
		
		model.addAttribute("trucksHTML", trucksHTML);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		return "historyexcel";
	}

}
