package box.web;

import java.io.IOException;
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
import box.logic.GoogleLogic;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
import box.model.History;
import box.model.Route;
import box.model.Truck;

@Controller
public class NewRouteServlet {
	
	@RequestMapping(value = "/newRoute/{cellForNewRoute}", method = RequestMethod.GET)
	public String doGet(@PathVariable("cellForNewRoute") String cellForNewRoute,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		String cell [] = cellForNewRoute.split("&");
		
		int truckid = Integer.parseInt(cell [0]);
		String dateStart = cell [1];
		
		DataBaseController base = new DataBaseController(); 
		
		Route lastRoute = base.getLastRouteByTruckId(truckid, dateStart);

		List<Client> clientsFromBase = base.getListOfClients();
		List<ClientForRouteHTML> clients = new ArrayList();
		
		for(Client c:clientsFromBase){
			
			if(base.isClientHasOblastFromByDirection(c.getId(), lastRoute.getToOblast())){
			ClientForRouteHTML client = new ClientForRouteHTML();
			
			
			client.setCargo(c.getCargo());
			client.setCompany(c.getCompany());
			client.setId(c.getId());			
			client.setTypetruck(c.getTypetruck());
			
			List<Direction> directions = base.getListOfDirectionsByOblastAndClientid(c.getId(), lastRoute.getToOblast());
			String whereWeCanGo ="";
				for(Direction d:directions){
					whereWeCanGo = whereWeCanGo+d.getOblastTo()+" ";
				}
			
			
			client.setPosibilityToGo(whereWeCanGo);
			
			String blacklist = "";
			if(c.getBlacklist()==Constants.CLIENT_IN_BLACK_LIST){
				blacklist = "w3-red";
			}
			client.setBlacklist(blacklist);
			
			clients.add(client);
			}
			
		}
		
		Truck truckForHtml = base.getTruckbyId(truckid);
		String truckHtml = truckForHtml.getTracktor()+"/"+truckForHtml.getTrailer();
		String circleinfo = base.getCircleParametrByRoutes(truckid, dateStart);
		List<Route> routescircle= base.getListOfRoutesForCircle(truckid, dateStart);
		
		base.closeConnection();
		
		model.addAttribute("routescircle", routescircle);
		model.addAttribute("circleinfo", circleinfo);
	
		model.addAttribute("clients", clients);
		model.addAttribute("name", name);
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("truckHtml", truckHtml);
		
		model.addAttribute("lastOblast", lastRoute.getToOblast());
		model.addAttribute("lastAddress", lastRoute.getAddressTo());
	
		
		
	
		model.addAttribute("calculateTo", lastRoute.getAddressTo() + " - "+lastRoute.getAddressTo());
		model.addAttribute("priceForKm", 0 + " грн/км");
		
		model.addAttribute("cellForNewRoute", cellForNewRoute);
		
		model.addAttribute("valuePrice", "");
		model.addAttribute("valueInfo", "");
		
		return "newroute";
	}
	
	@RequestMapping(value = "/newRoute/{cellForNewRoute}", method = RequestMethod.POST)
	public String doPost(@PathVariable("cellForNewRoute") String cellForNewRoute,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
        HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		String cell [] = cellForNewRoute.split("&");
		
		int truckid = Integer.parseInt(cell [0]);
		String dateStart = cell [1];
		String dateFinish = cell [2];
		
		DataBaseController base = new DataBaseController(); 
		Route lastRoute = base.getLastRouteByTruckId(truckid, dateStart);
		
		if (request.getParameter("wait") != null) {
			
             Route route = new Route();
			
			route.setAddressFrom(lastRoute.getAddressTo());
			route.setAddressTo(lastRoute.getAddressTo());
			route.setFromCity(lastRoute.getToCity());
			
			CalendarLogic calendar = new CalendarLogic();
			Date fromDate = calendar.addToStringOneMinute(dateStart);
				
			route.setFromDate(fromDate);
			route.setFromLat(lastRoute.getToLat());
			route.setFromLon(lastRoute.getToLon());
			route.setFromOblast(lastRoute.getToOblast());
			route.setInfo("очікування");
			route.setKilometrs(0);
			route.setPiceForKilometr(0);
			route.setPrice(0);
			route.setRouteStatus(Constants.TRUCK_NOT_READY);
			route.setToCity(lastRoute.getToCity());
			
			Date toDate = calendar.changeStringToDate(dateFinish);
			
			route.setToDate(toDate);
			route.setToLat(lastRoute.getToLat());
			route.setToLon(lastRoute.getToLon());
			route.setToOblast(lastRoute.getToOblast());
			route.setTruckid(truckid);
			
			base.addRoute(route);
			
			History history = new History();
			
			history.setAction(Constants.ACTION_FIXING);
			history.setActionDate(new Date());
			history.setInfo("очікування");
			history.setManager(name);
			history.setManagerid(id);
			
			base.addHistory(history);
			
			base.closeConnection();
			
			try {
				response.sendRedirect("/planner/timetable");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "timetable";
			
		}
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String lng = request.getParameter("lng");
		String lat = request.getParameter("lat");
		
		double longitude = Double.parseDouble(lat);
		double latitude = Double.parseDouble(lng);
		
		String googleAddress = request.getParameter("googleAddress");
		int totalPrice = Integer.parseInt(request.getParameter("priceFromClient"));
		
		String city = request.getParameter("locality");
		String oblast = request.getParameter("administrative_area_level_1");
		String valueInfo = request.getParameter("infoClient");
		
		if (googleAddress != null){
			try {
				googleAddress = new String(googleAddress.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (valueInfo != null){
			try {
				valueInfo = new String(valueInfo.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (city != null){
			try {
				city = new String(city.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (oblast != null){
			try {
				oblast = new String(oblast.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		if(city.equals("Київ")){
			oblast = "Київська область";
		}
		
		
		
		
		
		GoogleLogic google = new GoogleLogic();
		int kilometrs = google.calculateDistanceInKmBetweenCoordinates(lastRoute.getToLon(), lastRoute.getToLat(), longitude, latitude);
		
		int	priceForKilometr = 0;
		
		if(kilometrs!=0){
        priceForKilometr =totalPrice/kilometrs;
		}
		List<Client> clientsFromBase = base.getListOfClients();
		List<ClientForRouteHTML> clients = new ArrayList();
		
		if (request.getParameter("book") != null) {
			
			Route route = new Route();
			
			route.setAddressFrom(lastRoute.getAddressTo());
			route.setAddressTo(googleAddress);
			route.setFromCity(lastRoute.getToCity());
			
			CalendarLogic calendar = new CalendarLogic();
			Date fromDate = calendar.addToStringOneMinute(dateStart);
				
			route.setFromDate(fromDate);
			route.setFromLat(lastRoute.getToLat());
			route.setFromLon(lastRoute.getToLon());
			route.setFromOblast(lastRoute.getToOblast());
			route.setInfo(valueInfo);
			route.setKilometrs(kilometrs);
			route.setPiceForKilometr(priceForKilometr);
			route.setPrice(totalPrice);
			route.setRouteStatus(Constants.TRUCK_READY);
			route.setToCity(city);
			
			Date toDate = calendar.changeStringToDate(dateFinish);
			
			route.setToDate(toDate);
			route.setToLat(latitude);
			route.setToLon(longitude);
			route.setToOblast(oblast);
			route.setTruckid(truckid);
			
			base.addRoute(route);
			
            History history = new History();
            
            Truck truck = base.getTruckbyId(truckid);
            
            if(truck.getManagerid()==id){
			history.setAction(Constants.ACTION_BOOKING);
            }else{
            	history.setAction(Constants.ACTION_HELP);
            }
			history.setActionDate(new Date());
			history.setInfo(lastRoute.getToOblast()+" - "+oblast+" "+priceForKilometr+" грн/км");
			history.setManager(name);
			history.setManagerid(id);
			
			base.addHistory(history);
			
			base.closeConnection();
			
			try {
				response.sendRedirect("/planner/timetable");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "timetable";
		}
		
		History history = new History();
		
		history.setAction(Constants.ACTION_CALCULATE);
		history.setActionDate(new Date());
		history.setInfo(lastRoute.getToOblast()+" - "+oblast+" "+priceForKilometr+" грн/км");
		history.setManager(name);
		history.setManagerid(id);
		
		base.addHistory(history);
		
		for(Client c:clientsFromBase){
			
			if(base.isClientHasOblastFromByDirection(c.getId(), lastRoute.getToOblast())){
			ClientForRouteHTML client = new ClientForRouteHTML();
			
			
			client.setCargo(c.getCargo());
			client.setCompany(c.getCompany());
			client.setId(c.getId());			
			client.setTypetruck(c.getTypetruck());
			
			List<Direction> directions = base.getListOfDirectionsByOblastAndClientid(c.getId(), lastRoute.getToOblast());
			String whereWeCanGo ="";
				for(Direction d:directions){
					whereWeCanGo = whereWeCanGo+d.getOblastTo()+" ";
				}
			
			
			client.setPosibilityToGo(whereWeCanGo);
			
			String blacklist = "";
			if(c.getBlacklist()==Constants.CLIENT_IN_BLACK_LIST){
				blacklist = "w3-red";
			}
			client.setBlacklist(blacklist);
			
			clients.add(client);
			}
			
		}
		
		Truck truckForHtml = base.getTruckbyId(truckid);
		String truckHtml = truckForHtml.getTracktor()+"/"+truckForHtml.getTrailer();
		String circleinfo = base.getCircleParametrByRoutes(truckid, dateStart);
		
		List<Route> routescircle= base.getListOfRoutesForCircle(truckid, dateStart);
		
		base.closeConnection();
		
		model.addAttribute("routescircle", routescircle);
		
		model.addAttribute("circleinfo", circleinfo);
		
		model.addAttribute("clients", clients);
		model.addAttribute("name", name);
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("truckHtml", truckHtml);
		
		model.addAttribute("lastOblast", lastRoute.getToOblast());
		model.addAttribute("lastAddress", lastRoute.getAddressTo());
	
		model.addAttribute("priceForKm", priceForKilometr + " грн/км");
		model.addAttribute("calculateTo", lastRoute.getAddressTo() + " - "+googleAddress);
		
		model.addAttribute("cellForNewRoute", cellForNewRoute);

		model.addAttribute("valuePrice", totalPrice);
		model.addAttribute("valueInfo", valueInfo);
		
		return "newroute";
	}

}
