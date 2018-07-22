package beagle.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import beagle.dispatcher.Service;
import beagle.model.Manager;

@Controller
@RequestMapping("/editManagerConsole")
public class EditManagerConsole {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");

		Service service = new Service();

		if (!service.isAccess(request.getRemoteAddr())) {
			return "denied";
		}

		Manager manager = service.getManagerByName(name);

		String permissionToDelete = "";
		if (service.isManagerHasClient(name)) {
			permissionToDelete = "disabled";
		}
		model.addAttribute("manager", manager);
		model.addAttribute("permissionToDelete", permissionToDelete);

		return "editManagerConsole";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest request,
			HttpServletResponse res) {

		String name = request.getParameter("managerName");
		Service service = new Service();
		Manager manager = service.getManagerByName(name);

		String mail = request.getParameter("mail");
		String phone = request.getParameter("phone");
		String click = request.getParameter("submit");

		if (click.equals("delete")) {
			service.deleteManager(manager.getId());
		}
		if (click.equals("edit")) {
			service.editManager(manager.getId(), mail, phone);
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
