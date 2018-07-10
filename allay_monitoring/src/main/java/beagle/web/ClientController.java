package beagle.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Booking;


@Controller
@RequestMapping("/{key}")
public class ClientController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String openClientController(@PathVariable("key") String key, ModelMap model) {
		
		try{
        Service service = new Service();
		if(!service.isKeyExist(key)){
			return "noBooking";
		}
		Booking booking = service.getBookingByKey(key);
		List <Booking> bookings = service.getAllBookingsByClient(booking.getCompany());
		
		model.addAttribute("booking", booking);
		model.addAttribute("bookings", bookings);

		return "Client";
		}catch(Exception e){
			return "exception";
		}
	}

}
