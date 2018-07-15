package beagle.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Booking;


@Controller
@RequestMapping("/console")
public class ConsoleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model, HttpServletRequest req) {
		
		Service service = new Service();
		
		if(!service.isAccess(req.getRemoteAddr())){
			 return "denied";
		 }
		
		List <Booking> bookings = service.getAllBookings();
		List <String> managers = service.getAllManagersOfBookings();
		List <String> deliveries = service.getAllWebDeliveryDates();
		List <String> tableStatus = service.getAllUpdatesStatusOfBookings();
		
		model.addAttribute("bookings", bookings);
		model.addAttribute("managers", managers);
		model.addAttribute("deliveries", deliveries);
		model.addAttribute("tableStatus", tableStatus);
		
		return "console";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model,HttpServletRequest req, HttpServletResponse res) {
		
		Service service = new Service();
		List <Booking> bookings = service.getAllBookings();
		String button = req.getParameter("submit");
		int number = Integer.parseInt(button);
		int id = bookings.get(number-1).getId();
		
		    	String etd = req.getParameter("etd"+number);
		    	String longitude = req.getParameter("longitude"+number);
		    	String latitude = req.getParameter("latitude"+number);
		    	String status = req.getParameter("status"+number);
		    	
		    	String finish = (String)req.getParameter("close"+number);
		    	if ("on".equals(finish)) {
		    		service.deleteBooking(id);
		    		try {
						res.sendRedirect("/monitoring/console");
						return "console";
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	}
		    	Booking adjustment = new Booking();
		    	adjustment.setDelivery(service.translateStringToNormalStringDate(etd));
		    	adjustment.setLongitude(Double.parseDouble(longitude));
		    	adjustment.setLatitude(Double.parseDouble(latitude));
		    	adjustment.setStatus(status);
		    	adjustment.setUpdate(service.translateDateToString(new Date()));
		    	
		    	
		    	service.editBooking(id, adjustment);
		    	try {
					res.sendRedirect("/monitoring/console");
					return "console";
				} catch (IOException e) {
					e.printStackTrace();
				}
		return "console";
	}

}
