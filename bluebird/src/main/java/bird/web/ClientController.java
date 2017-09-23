package bird.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.model.Route;


@Controller
@RequestMapping("/cabinet")
public class ClientController {
	
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
		}
		
		List<Cargo> cargoes = monitoring.getActiveCargoesByClient(clientID);
        List<Route> waybill = monitoring.getRoutebyCargoId(cargoID);
        
		model.addAttribute("cargoes", cargoes);
		model.addAttribute("waybill", waybill);
	
		
	return "Cabinet";
	}


		
	}
	


