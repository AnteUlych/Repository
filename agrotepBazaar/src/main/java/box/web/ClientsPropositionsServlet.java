package box.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/clientspropositions")
public class ClientsPropositionsServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
		
		return "clientspropositions";
	}

}
