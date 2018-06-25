package beagle.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Client;



@Controller
@RequestMapping("/addClient")
public class AddClientController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {
		
		initModelList(model);

		
		return "addClient";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest req) {
		
		String companyClient = req.getParameter("companyClient");
		String nameClient = req.getParameter("nameClient");
		String phoneClient = req.getParameter("phoneClient");
		String emailClient = req.getParameter("emailClient");
		
		String[] managerClient = req.getParameterValues("managerClient");
		String manager="";
		for (int i = 0; i < managerClient.length; i++) {
		    manager=managerClient[i]; 
		}
		
		
	    Client newClient = new Client();
	    newClient.setCompany(companyClient);
	    newClient.setMail(emailClient);
	    newClient.setName(nameClient);
	    newClient.setPhone(phoneClient);
	    newClient.setManager(manager);
	   
	    Service service = new Service();
	    service.addClient(newClient);
	    
		return "tempOk";
	}


	private void initModelList(Model model) {
		Service service = new Service();
		List<String> managers = service.getAllManagers();
		model.addAttribute("managers", managers);
		
	}

}
