package beagle.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.model.Booking;
import beagle.model.Client;
import beagle.temp.TempService;

@Controller
public class ClientController {
	
	@RequestMapping(value = "/tracing/{key}", method = RequestMethod.GET)
	public String openClientController(@PathVariable("key") String key,
			ModelMap model) {
		
        TempService service = new TempService();
		
		Booking booking = service.getBookingByKey(key);
		Client client = service.getClientByKey("booking1");
		List <Booking> bookings = service.getAllBookingsByCompany(client.getCompany());
		
		model.addAttribute("booking", booking);
		model.addAttribute("bookings", bookings);

		return "Client";
	}

}
