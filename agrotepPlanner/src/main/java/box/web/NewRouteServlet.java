package box.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.GoogleLogic;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
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
		
		base.closeConnection();
		
		model.addAttribute("clients", clients);
		model.addAttribute("name", name);
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("truckHtml", truckHtml);
		
		model.addAttribute("lastOblast", lastRoute.getToOblast());
		model.addAttribute("lastAddress", lastRoute.getAddressTo());
	
		model.addAttribute("calculateTo", lastRoute.getAddressTo() + " - "+lastRoute.getAddressTo());
		model.addAttribute("priceForKm", 0 + " грн/км");
		
		
		model.addAttribute("valuePrice", "");
		
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
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String lng = request.getParameter("lng");
		String lat = request.getParameter("lat");
		
		double longitude = Double.parseDouble(lng);
		double latitude = Double.parseDouble(lat);
		
		String googleAddress = request.getParameter("googleAddress");
		int totalPrice = Integer.parseInt(request.getParameter("priceFromClient"));
		
		String city = request.getParameter("locality");
		String oblast = request.getParameter("administrative_area_level_1");
		
		if (googleAddress != null){
			try {
				googleAddress = new String(googleAddress.getBytes(requestEnc), clientEnc);
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
			oblast = "Київська обл.";
		}
		
		DataBaseController base = new DataBaseController(); 
		
		Route lastRoute = base.getLastRouteByTruckId(truckid, dateStart);
		
		GoogleLogic google = new GoogleLogic();
		int kilometrs = google.calculateDistanceInKmBetweenCoordinates(lastRoute.getToLon(), lastRoute.getToLat(), longitude, latitude);
		
		int	priceForKilometr = 0;
		
		if(kilometrs!=0){
        priceForKilometr =totalPrice/kilometrs;
		}
		List<Client> clientsFromBase = base.getListOfClients();
		List<ClientForRouteHTML> clients = new ArrayList();
		
		//add
		//calculate
		//ifremont
		
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
		
		base.closeConnection();
		
		model.addAttribute("clients", clients);
		model.addAttribute("name", name);
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("truckHtml", truckHtml);
		
		model.addAttribute("lastOblast", lastRoute.getToOblast());
		model.addAttribute("lastAddress", lastRoute.getAddressTo());
	
		model.addAttribute("priceForKm", priceForKilometr + " грн/км");
		model.addAttribute("calculateTo", lastRoute.getAddressTo() + " - "+googleAddress);
		

		model.addAttribute("valuePrice", totalPrice);
		
		return "newroute";
	}

}
