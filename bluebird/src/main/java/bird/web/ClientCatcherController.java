package bird.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.model.Route;

@Controller
@RequestMapping("/gsp")
public class ClientCatcherController {
Expediter monitoring = new Expediter();	
	
	@RequestMapping(method = RequestMethod.GET)
	public String showQuote(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		String clientId = (String) session.getAttribute("clientID");
		int clientID = Integer.parseInt(clientId);
		
		String CargoId = (String) session.getAttribute("cargoID");
		int cargoID = Integer.parseInt(CargoId);
		
		if(cargoID == 0){
			cargoID = monitoring.getNewestCargo(clientID);
			session.setAttribute("cargoID",cargoID+"");
		}
		Cargo actualCargo = monitoring.getCargoBy(cargoID);
		DateFormat eddformat = new SimpleDateFormat("dd/MM/yyyy");
		String generalInformation = actualCargo.getDescription();//+"; estimated delivery date: "+eddformat.format(actualCargo.getDelivery());
		List<Cargo> cargoes = monitoring.getActiveCargoesByClient(clientID);
        List<Route> waybill = monitoring.getRoutebyCargoId(cargoID);
        String way = monitoring.getStatisticForMap(cargoID);
        //String way ="[['<center>10:00 24/10/2017</center><center>XX 1111 XX</center>', 51.508742,-0.120850,],['<center>10:00 25/10/2017</center><center>XX 1111 XX</center>', 52.395715,4.888916,],['<center>10:00 26/10/2017</center><center>XX 1111 XX</center>', 52.340748, 20.478142,]]"; 
        model.addAttribute("client", actualCargo.getClient());
        model.addAttribute("generalInformation", generalInformation);
		model.addAttribute("cargoes", cargoes);
		model.addAttribute("waybill", waybill);
		model.addAttribute("ETD", new SimpleDateFormat("dd/MM/yyyy").format(actualCargo.getDelivery()));
		model.addAttribute("way", way);
		
		model.addAttribute("needComment", monitoring.isCargoCommentExists(cargoID));
			
		model.addAttribute("lastUpdate", monitoring.getTimeOfLastUpdateByClient(clientID));
	//	model.addAttribute("totalCargoes", monitoring.getTotalCargoesByClient(clientID));
		
	return "Cabinet";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String clientId = (String) session.getAttribute("clientID");
		String cargoId = (String) session.getAttribute("cargoID"); 
		int clientID = Integer.parseInt(clientId);
		
		List<Cargo> cargoes = monitoring.getActiveCargoesByClient(clientID);
          
		model.addAttribute("cargoes", cargoes);
		
		String forward = "notion";
		
		for(Cargo c:cargoes){		
		if (request.getParameter("find"+cargoes.indexOf(c)) != null) {
			int cargoID = Integer.parseInt(request.getParameter("cargoid"+cargoes.indexOf(c)));
			session.setAttribute("cargoID",cargoID+"");
			session.setAttribute("clientID",clientId);
			try {
				response.sendRedirect("/tracing/gsp");
				forward = "Cabinet";
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		//!
		if (request.getParameter("comment") != null) {
			try {
				response.sendRedirect("/tracing/notion");
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//!
		
		return forward;
	}

		
	}