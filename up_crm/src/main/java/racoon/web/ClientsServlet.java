package racoon.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.logic.Constants;
import racoon.logic.Encoder;
import racoon.model.Client;

@Controller
@RequestMapping("/clients")
public class ClientsServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String openPage(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		String manager = (String) session.getAttribute("manager");

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();
		try{
		String privateCode = encoder.encode(code);

		//BaseController base = new BaseController();
		//List<Client> clients = base.getClientsByManager(manager);
		List<Client> clients = encoder.getClientsByManager(manager);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		List<String> dates = encoder.getDatesForClientsInNormalFormat(clients);
		
		model.addAttribute("dates", dates);
		model.addAttribute("services", services);
		model.addAttribute("manager", manager);
		model.addAttribute("privateCode", privateCode);
		model.addAttribute("clients", clients);

		encoder.closeConnection();
		
		return "clients";
	}catch(NullPointerException e){
		encoder.closeConnection();
		return "exception";
	}
	}

}
