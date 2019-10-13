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
import box.model.Transport;

@Controller
public class AddTransportServlet {
	
	@RequestMapping(value = "/addtransport", method = RequestMethod.GET)
	public String selectService(
			ModelMap model) {
		
		List<String> directions = new ArrayList();
		
		directions.add("Export");
		directions.add("Import");
		directions.add("Europe");
		directions.add("Ukraine");
		
		model.addAttribute("directions", directions);
		
		return "addtransport";
	}
	
	@RequestMapping(value = "/addtransport", method = RequestMethod.POST)
	public String postProposition(
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
List<String> directions = new ArrayList();
		
		directions.add("Export");
		directions.add("Import");
		directions.add("Europe");
		directions.add("Ukraine");
		
		model.addAttribute("directions", directions);
	
		
		String readiness = req.getParameter("readiness");
		String route = req.getParameter("route");
		String information = req.getParameter("information");
		String truckdriver = req.getParameter("truckdriver");
		String direct = req.getParameter("direct");
		

		Transport transport = new Transport();
		
		transport.setDate(new Date());
		transport.setDirection(direct);
		transport.setInformation(information);
		transport.setReadiness(readiness);
		transport.setRoute(route);
		transport.setStatus("w3-yellow");
		transport.setTruckdriver(truckdriver);
		
		LogicDataBase logic = new LogicDataBase();
		logic.addTransport(transport);
		logic.closeConnection();
		
		try {
			resp.sendRedirect("/probe/transports/"+direct);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "transports";
	}

}
