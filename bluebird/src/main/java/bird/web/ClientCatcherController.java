package bird.web;

import java.io.IOException;
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
			session.setAttribute("cargoID",cargoID);
		}
		
		List<Cargo> cargoes = monitoring.getActiveCargoesByClient(clientID);
        List<Route> waybill = monitoring.getRoutebyCargoId(cargoID);
        
		model.addAttribute("cargoes", cargoes);
		model.addAttribute("waybill", waybill);
		
		model.addAttribute("needComment", monitoring.isCargoCommentExists(cargoID));
		
		model.addAttribute("lastUpdate", monitoring.getTimeOfLastUpdateByClient(clientID));
		model.addAttribute("totalCargoes", monitoring.getTotalCargoesByClient(clientID));
			
	return "Cabinet";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String post(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		String clientId = (String) session.getAttribute("clientID");
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
				response.sendRedirect("/bluebird/cabinet");
				forward = "Cabinet";
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
		if (request.getParameter("comment") != null) {
			try {
				response.sendRedirect("/bluebird/notion");
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return forward;
	}
		
	}