package racoon.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.logic.Constants;
import racoon.model.Client;
import racoon.model.Manager;

@Controller
public class EditClientManagerServlet {
	
	@RequestMapping(value = "/change/{idCode}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idCode") String code,
			ModelMap model) {
		
		BaseController base = new BaseController();	
		int id = Integer.parseInt(code);
		
		Client client = base.getClientById(id);
		List<Manager> managers = base.getAllManagers();	
		
		List<String> persons = new ArrayList();
		persons.add("---");
		for(Manager m:managers){
			if(!m.getName().contains("fired")){
				persons.add(m.getName());
			}
		}
		
		model.addAttribute("company", client.getCompany());
		model.addAttribute("companyCode", client.getCode());
		model.addAttribute("manager", client.getManager());
		model.addAttribute("persons", persons);
		
		base.closeConnection();
		
		return "change";
	}
	
	@RequestMapping(value = "/change/{idCode}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("idCode") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

	
		BaseController base = new BaseController();	
		int id = Integer.parseInt(code);
		
		Client client = base.getClientById(id);
		List<Manager> managers = base.getAllManagers();	
		
		List<String> persons = new ArrayList();
		persons.add("---");
		for(Manager m:managers){
			if(!m.getName().contains("fired")){
				persons.add(m.getName());
			}
		}
		
		model.addAttribute("company", client.getCompany());
		model.addAttribute("companyCode", client.getCode());
		model.addAttribute("manager", client.getManager());
		model.addAttribute("persons", persons);


		if (req.getParameter("change") != null) {
			String newManager = req.getParameter("newManager");
			if(!newManager.equals("---")){
				base.editManagerOfClient(id, newManager);
			}
		}
		
		if (req.getParameter("fired") != null) {
			int managerId = base.getManagerIdByName(client.getManager());
			String firedManager = client.getManager()+"(fired)";
			base.firedManager(managerId, firedManager);
			
			List<Client> clients = base.getAllClients();
			for(Client c:clients){
				if(client.getManager().equals(c.getManager())){
				base.editManagerOfClient(c.getId(), firedManager);
				}
			}
		}
		
		try {
			base.closeConnection();
			resp.sendRedirect("/crm/managers");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		base.closeConnection();
		
		return "change";

	}

}
