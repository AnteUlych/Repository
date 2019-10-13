package box.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.LogicDataBase;
import box.model.Transport;



@Controller
public class TransportsServlet {
	
	@RequestMapping(value = "/transports/{direction}", method = RequestMethod.GET)
	public String selectService(@PathVariable("direction") String direction,
			ModelMap model) {

		LogicDataBase logic = new LogicDataBase();
		
		List<Transport> trucks = logic.getAllTransportByDirection(direction);
		model.addAttribute("trucks", trucks);
		model.addAttribute("direction", direction);
		
		logic.closeConnection();
			
		return "transports";

	}

}
