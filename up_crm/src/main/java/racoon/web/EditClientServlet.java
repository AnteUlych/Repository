package racoon.web;

import java.io.IOException;
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
import racoon.logic.Encoder;
import racoon.model.Client;
import racoon.model.Manager;

@Controller
public class EditClientServlet {

	@RequestMapping(value = "/editClient/{code}", method = RequestMethod.GET)
	public String selectClient(@PathVariable("code") String code, ModelMap model) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		Client client = encoder.getClientByIdCodeFromConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		
		// disabled button
		String mayIClick = "disabled";
		if(client.getManager().equals(manager.getName())){
			mayIClick = "";
		}

		model.addAttribute("mayIClick", mayIClick);

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		model.addAttribute("categories", constantBase.getAllCategories());
		model.addAttribute("company", client.getCompany());
		model.addAttribute("mail", client.getMail());
		model.addAttribute("person", client.getPerson());
		model.addAttribute("phone", client.getPhone());

		encoder.closeConnection();
		
		return "editClient";
	}

	@RequestMapping(value = "/editClient/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		Client client = encoder.getClientByIdCodeFromConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		model.addAttribute("categories", constantBase.getAllCategories());
		model.addAttribute("company", client.getCompany());
		model.addAttribute("mail", client.getMail());
		model.addAttribute("person", client.getPerson());
		model.addAttribute("phone", client.getPhone());

		String company = req.getParameter("company");
		String mail = req.getParameter("mail");
		String person = req.getParameter("person");
		String phone = req.getParameter("phone");
		String category = req.getParameter("cat");

		BaseController base = new BaseController();
		base.editClient(client.getId(), company, phone, person, category, mail);

		try {
			encoder.closeConnection();
			resp.sendRedirect("/crm/client/" + code);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "client";

	}

}
