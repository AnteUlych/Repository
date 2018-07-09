package beagle.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Client;

@Controller
@RequestMapping("/editManagerClientConsole")
public class EditManagerClientConsole {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model) {

		Service service = new Service();

		List<String> managers = service.getAllManagers();
		List<Client> clients = service.getAllClientsInfo();

		model.addAttribute("managers", managers);
		model.addAttribute("clients", clients);

		return "editManagerClientConsole";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest request,
			HttpServletResponse res) {

		Service service = new Service();

		List<Client> clients = service.getAllClientsInfo();

		for (Client client : clients) {
			String manager = request.getParameter(client.getCompany() + "");
			Client clientForChangingManager = service.getClientByCompany(client
					.getCompany());
			service.editClientManager(clientForChangingManager.getId(), manager);
		}

		try {
			res.sendRedirect("/monitoring/managerConsole");
			return "managerConsole";
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "managerConsole";
	}
}
