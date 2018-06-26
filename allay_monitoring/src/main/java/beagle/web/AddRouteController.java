package beagle.web;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Booking;


@Controller
@RequestMapping("/addRoute")
public class AddRouteController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		initModelList(model);
		
		return "addRoute";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest req) {
		
		Service service = new Service();
		
		String route = req.getParameter("route");
		String delivery = service.translateStringToNormalStringDate(req.getParameter("delivery"));
		
		String[] clients = req.getParameterValues("client");
		String client="";
		for (int i = 0; i < clients.length; i++) {
			client=clients[i]; 
		}
	
	    Booking booking = new Booking();
	    booking.setCompany(client);
	    booking.setDelivery(delivery);
	    booking.setRoute(route);
	    booking.setKey(service.createKey());
	    booking.setUpdate("");
	    
	    service.addBooking(booking);
	    
		return "tempOk";
	}
	

	private void initModelList(Model model) {
		Service service = new Service();
		List <String> clients = service.getAllClients();
		Collections.sort(clients);
		model.addAttribute("clients", clients);
	}
}
