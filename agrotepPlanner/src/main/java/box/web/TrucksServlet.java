package box.web;

import java.io.UnsupportedEncodingException;
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
import box.model.Truck;

@Controller
@RequestMapping("/trucks")
public class TrucksServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		List<Manager> managers= base.getListOfManagers();
		List<Truck> trucks = base.getListOfTrucksSortedByManager();
		
		List<String> statusTrucks = new ArrayList();
		
		for(Truck t:trucks){
			String status = "";
			if(t.getNotReady()==Constants.TRUCK_NOT_READY){
				status = "w3-red";
			}
			statusTrucks.add(status);
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("managers", managers);
		model.addAttribute("trucks", trucks);
		model.addAttribute("statusTrucks", statusTrucks);
		
		return "trucks";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String tracktor = request.getParameter("tracktor");
		String trailor = request.getParameter("trailor");
		String driver = request.getParameter("driver");
		String phone = request.getParameter("phone");
		String typetruck = request.getParameter("typetruck");
		String manager = request.getParameter("manar");
		
		if (tracktor != null){
			try {
				tracktor = new String(tracktor.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (trailor != null){
			try {
				trailor = new String(trailor.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (driver != null){
			try {
				driver = new String(driver.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (phone != null){
			try {
				phone = new String(phone.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (typetruck != null){
			try {
				typetruck = new String(typetruck.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if (manager != null){
			try {
				manager = new String(manager.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		
		Manager m = base.getManagersByName(manager);
		
		int idOfmanager = m.getId();
		
		Truck newTruck = new Truck();
		
		newTruck.setComment("");
		newTruck.setDriver(driver);
		newTruck.setManagerid(idOfmanager);
		newTruck.setManagerName(manager);
		newTruck.setNotReady(Constants.TRUCK_READY);
		newTruck.setPhone(phone);
		newTruck.setPriority(Constants.TRUCK_PRIORITY_REGULAR);
		newTruck.setStatusTruck("Київська область");
		newTruck.setTracktor(tracktor);
		newTruck.setTrailer(trailor);
		newTruck.setType(typetruck);
		
		base.addTruck(newTruck);
		int idOfNewTruck = base.gettruckByTracktorAndTrailer(tracktor, trailor).getId();
		
		Route routeForNewTruck = new Route();
		
		CalendarLogic c = new CalendarLogic();
		Date today = new Date();
		String twoDaysBefore = c.getNeedoneDayForDataBasePlusDays(-2);
		String oneDaysBefore = c.getNeedoneDayForDataBasePlusDays(-1);
		
		routeForNewTruck.setAddressFrom("вулиця Академіка Бутлерова, 8, Київ, 02000");
		routeForNewTruck.setAddressTo("вулиця Академіка Бутлерова, 8, Київ, 02000");
		routeForNewTruck.setFromCity("Київ");
		routeForNewTruck.setFromDate(c.changeStringToDate(twoDaysBefore));
		routeForNewTruck.setFromLat(30.649562);
		routeForNewTruck.setFromLon(50.449546);
		routeForNewTruck.setFromOblast("Київська область");
		routeForNewTruck.setInfo("готовий до роботи");
		routeForNewTruck.setKilometrs(0);
		routeForNewTruck.setPiceForKilometr(0);
		routeForNewTruck.setPrice(0);
		routeForNewTruck.setRouteStatus(0);
		routeForNewTruck.setToCity("Київ");
		routeForNewTruck.setToDate(c.changeStringToDate(oneDaysBefore));
		routeForNewTruck.setToLat(30.649562);
		routeForNewTruck.setToLon(50.449546);
		routeForNewTruck.setToOblast("Київська область");
		routeForNewTruck.setTruckid(idOfNewTruck);
		
		base.addRoute(routeForNewTruck);
		
		List<Manager> managers= base.getListOfManagers();
		List<Truck> trucks = base.getListOfTrucksSortedByManager();
		
		List<String> statusTrucks = new ArrayList();
		
		for(Truck t:trucks){
			String status = "";
			if(t.getNotReady()==Constants.TRUCK_NOT_READY){
				status = "w3-red";
			}
			statusTrucks.add(status);
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("managers", managers);
		model.addAttribute("trucks", trucks);
		model.addAttribute("statusTrucks", statusTrucks);
		
		return "trucks";
	}

}
