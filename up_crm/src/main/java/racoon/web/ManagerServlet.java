package racoon.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.model.Client;
import racoon.model.Manager;

@Controller
@RequestMapping("/managers")
public class ManagerServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		
		BaseController base = new BaseController();	
		List<Client> clients = base.getAllClients();

		model.addAttribute("clients", clients);
		
		base.closeConnection();
		
		return "managers";
		
	}
	
	

}
