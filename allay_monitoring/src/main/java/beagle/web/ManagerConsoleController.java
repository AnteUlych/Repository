package beagle.web;

import java.io.IOException;
import java.util.List;

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
@RequestMapping("/managerConsole")
public class ManagerConsoleController {

	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model, HttpServletRequest req) {

		Service service = new Service();

		if (!service.isAccess(req.getRemoteAddr())) {
			return "denied";
		}

		List<Manager> managers = service.getAllManagersInfo();

		model.addAttribute("managers", managers);

		return "managerConsole";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest req,
			HttpServletResponse res) {

		Service service = new Service();

		String edit = req.getParameter("edit");
		List<String> managers = service.getAllManagers();

		for (String manager : managers) {
			if (edit.equals(manager)) {
				HttpSession session = req.getSession();
				session.setAttribute("name", manager);

				try {
					res.sendRedirect("/monitoring/editManagerConsole");
					return "editManagerConsole";
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		String name = req.getParameter("name");
		String mail = req.getParameter("mail");
		String phone = req.getParameter("phone");

		service.addManager(name, mail, phone);

		try {
			res.sendRedirect("/monitoring/managerConsole");
			return "console";
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "managerConsole";
	}
}
