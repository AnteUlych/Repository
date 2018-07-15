package beagle.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Sender;
import beagle.dispatcher.Service;
import beagle.model.Booking;
import beagle.model.Client;
import beagle.model.Manager;

@Controller
@RequestMapping("/bird")
public class BirdController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model, HttpServletRequest req) {

		Service service = new Service();
		
		if(!service.isAccess(req.getRemoteAddr())){
			 return "denied";
		 }
		
		List<Booking> bookings = service.getAllBookings();
		model.addAttribute("bookings", bookings);

		return "bird";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest req,
			HttpServletResponse res) {

		Service service = new Service();
		List<Booking> bookings = service.getAllBookings();

		for (int index = 1; index <= bookings.size(); index++) {
			String bird = (String) req.getParameter(index + "");
			if ("on".equals(bird)) {
				Booking booking = bookings.get(index - 1);
				// method sender
				Client client = service
						.getClientByCompany(booking.getCompany());
				Manager manager = service.getManagerByName(client.getManager());

				Sender mail = new Sender(client.getName(), client.getMail(),
						manager.getMail(), booking.getKey(),
						booking.getLongitude(), booking.getLatitude(),
						booking.getStatus(), booking.getDelivery(),
						booking.getUpdate());
				mail.sendMonitoring();
				// System.out.println(booking.getUpdate());//delete
			}
		}

		try {
			res.sendRedirect("/monitoring/console");
			return "console";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "console";
	}
}
