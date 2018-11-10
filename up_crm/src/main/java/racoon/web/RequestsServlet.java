package racoon.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.Constants;
import racoon.logic.Encoder;
import racoon.model.Manager;
import racoon.model.Request;

@Controller
public class RequestsServlet {

	@RequestMapping(value = "/service/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code, ModelMap model) {
		
		Encoder encoder = new Encoder();
		
		List<Request> requests = encoder.getRequestsByServiceFromCodeConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);
		
		Constants constantBase = new Constants();
		List <String> services = constantBase.getAllServices();
		String privateCode = encoder.encodeServiceCode(code);
		
		model.addAttribute("privateCode", privateCode);
		model.addAttribute("services", services);	
		model.addAttribute("requests", requests);
		model.addAttribute("id", manager.getId());
		model.addAttribute("today", encoder.todayDay());
		
		return "requests";
	}
}
