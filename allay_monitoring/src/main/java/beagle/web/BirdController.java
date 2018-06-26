package beagle.web;

import java.io.IOException;
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
@RequestMapping("/bird")
public class BirdController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		Service service = new Service();
		List<Booking> bookings = service.getAllBookings();
		model.addAttribute("bookings", bookings);
		
		return "bird";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model,HttpServletRequest req, HttpServletResponse res) {
		
		Service service = new Service();
		List <Booking> bookings = service.getAllBookings();
		
		for(int index=1; index<=bookings.size(); index++ ){
			String bird = (String)req.getParameter(index+"");
			if ("on".equals(bird)) {
				Booking booking = bookings.get(index-1);
				//method sender
				System.out.println(booking.getUpdate());//delete
	    	}
		}
		
		return "tempOk";
	}
}
