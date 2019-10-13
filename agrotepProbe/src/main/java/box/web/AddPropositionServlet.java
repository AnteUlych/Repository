package box.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.LogicDataBase;
import box.model.Proposition;
import box.model.Transport;

@Controller
public class AddPropositionServlet {
	
	@RequestMapping(value = "/addproposition/{transportid}", method = RequestMethod.GET)
	public String selectService(@PathVariable("transportid") String transportid,
			ModelMap model) {
		
	
		int id = Integer.parseInt(transportid);	
		LogicDataBase logic = new LogicDataBase();
		Transport transport = logic.getTransportById(id);
		logic.closeConnection();
		
		model.addAttribute("way", transport.getRoute());
		
		return "addnewproposition";
	}
	

	@RequestMapping(value = "/addproposition/{transportid}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("transportid") String transportid,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
        int id = Integer.parseInt(transportid);	
        
		LogicDataBase logic = new LogicDataBase();
		Transport transport = logic.getTransportById(id);
		
		
		model.addAttribute("way", transport.getRoute());
		
		String readiness = req.getParameter("readiness");
		String route = req.getParameter("route");
		String information = req.getParameter("information");
		int price = Integer.parseInt(req.getParameter("priceEuro"));
	
		Proposition proposition = new Proposition();

		proposition.setDate(new Date());
		proposition.setDirection(transport.getDirection());
		proposition.setInformation(information);
		proposition.setManager("Anton");
		proposition.setPrice(price);
		proposition.setReadiness(readiness);
		proposition.setRoute(route);
		proposition.setStatus("");
		proposition.setTransportid(id);
		
		logic.addProposition(proposition);
		logic.setTransportStatus(id, "");
		
		logic.closeConnection();
		
		try {
			resp.sendRedirect("/probe/propositions/"+transportid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "propositions";
		
        
	}

}
