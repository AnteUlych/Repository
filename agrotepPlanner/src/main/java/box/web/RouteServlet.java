package box.web;

import java.io.IOException;
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

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.SecurityAccess;
import box.model.Client;
import box.model.ClientForRouteHTML;
import box.model.Direction;
import box.model.History;
import box.model.Route;
import box.model.Truck;

@Controller
public class RouteServlet {
	
	@RequestMapping(value = "/route/{cellForNewRoute}", method = RequestMethod.GET)
	public String doGet(@PathVariable("cellForNewRoute") String cellForNewRoute,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		SecurityAccess security = new SecurityAccess();
		if(security.isAccessNotAllowForManagerId((Integer) session.getAttribute("id"))){
			return "notallow";
		}
		
	    String cell [] = cellForNewRoute.split("&");
		
		int truckid = Integer.parseInt(cell [0]);
		String dateStart = cell [1];
		String dateFinish = cell [2];
		
		DataBaseController base = new DataBaseController();
		Route lastRoute = base.getLastRouteBetweenDatesByTruckId(truckid, dateStart, dateFinish);
		
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
		
		model.addAttribute("getAddressFrom", lastRoute.getAddressFrom());
		model.addAttribute("getAddressTo", lastRoute.getAddressTo());
		model.addAttribute("getPrice", lastRoute.getPrice());
		model.addAttribute("getPiceForKilometr", lastRoute.getPiceForKilometr());
		
		model.addAttribute("dateStart", dateStart);
		model.addAttribute("truckHtml", truckHtml);
		model.addAttribute("info", lastRoute.getInfo());
		
		model.addAttribute("lastOblast", lastRoute.getToOblast());
		
	
		return "route";
	}
	
	@RequestMapping(value = "/route/{cellForNewRoute}", method = RequestMethod.POST)
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
			Route lastRoute = base.getLastRouteBetweenDatesByTruckId(truckid, dateStart, dateFinish);
			
			
			
			History h = new History();
			h.setAction(Constants.ACTION_DELETE);
			h.setActionDate(new Date());
			h.setInfo("відміна "+ lastRoute.getAddressFrom()+" - "+lastRoute.getAddressTo()+" "+lastRoute.getPiceForKilometr()+" грн/км");
			h.setManager(name);
			h.setManagerid(id);
			
			base.addHistory(h);
			
			base.deleteRoute(lastRoute.getId());
			
			base.closeConnection();
		
		try {
			response.sendRedirect("/planner/timetable");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "timetable";

	}

}
