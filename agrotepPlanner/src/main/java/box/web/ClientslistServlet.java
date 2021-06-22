package box.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Client;

@Controller
@RequestMapping("/clientslist")
public class ClientslistServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController(); 
		
		List<Client> clients = base.getListOfOrderClients();	
        base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("clients", clients);
		
		return "clientslist";
		
	}

}
