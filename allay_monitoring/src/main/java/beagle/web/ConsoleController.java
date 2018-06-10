package beagle.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.model.Booking;
import beagle.temp.TempService;

@Controller
@RequestMapping("/console")
public class ConsoleController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		TempService service = new TempService();
		List <Booking> bookings = service.getAllBookings();
		
	
		model.addAttribute("bookings", bookings);
		
		Booking booking = new Booking();
		model.addAttribute("booking", booking);
		
		return "console";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, Booking booking) {
		
		model.addAttribute("booking", booking);

	//	model.addAttribute("form", form);
	//	String returnVal = "successForm";
	//	if(result.hasErrors()) {
	//		initModelList(model);
	//		returnVal = "form";
	//	} else {
	//		model.addAttribute("form", form);
	//	}		
		return "tempOk";
	}

}
