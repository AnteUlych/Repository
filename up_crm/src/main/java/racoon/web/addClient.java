package racoon.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import racoon.model.Status;

@Controller
public class addClient {
	@RequestMapping(value = "/addClient/{code}", method = RequestMethod.GET)
	public String selectClient(@PathVariable("code") String code, ModelMap model) {

		Encoder encoder = new Encoder();

		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		List<String> categories = constantBase.getAllCategories();
		List<String> funnels = constantBase.getAllFunnel();

		model.addAttribute("managerId", manager.getId());

		model.addAttribute("funnels", funnels);
		model.addAttribute("categories", categories);
		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		return "addClient";

	}

	@RequestMapping(value = "/addClient/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		Encoder encoder = new Encoder();

		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		List<String> categories = constantBase.getAllCategories();
		List<String> funnels = constantBase.getAllFunnel();

		model.addAttribute("managerId", manager.getId());

		model.addAttribute("funnels", funnels);
		model.addAttribute("categories", categories);
		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		String cod = req.getParameter("cod");
		String company = req.getParameter("company");
		String mail = req.getParameter("mail");
		String person = req.getParameter("person");
		String phone = req.getParameter("phone");
		String cat = req.getParameter("cat");
		String fun = req.getParameter("fun");
		String nextcall = req.getParameter("nextcall");
		String comment = req.getParameter("comment");

		if (encoder.isCodeCompanyExist(cod)) {
			try {
				resp.sendRedirect("/crm/check/" + code);
			} catch (IOException e1) {
				e1.printStackTrace();
			}

			return "ok";
		}

		BaseController base = new BaseController();

			Client client = new Client();

			client.setAnswer(comment);
			client.setCategory(cat);
			client.setCode(cod);
			client.setCompany(company);
			client.setFunnel(fun);
			client.setMail(mail);
			client.setManager(manager.getName());
			client.setNextcall(encoder.makeStringtoDate(nextcall));
			client.setPerson(person);
			client.setPhone(phone);

			base.addClient(client);

			Status status = new Status();
	
			
			status.setAnswer(comment);
			status.setClientId(base.getClientByCode(cod).getId());
			status.setFunnel(fun);
			status.setLasttime(encoder.makeStringtoDate(nextcall));

			base.addStatus(status);

			String password = manager.getCode() + "";
			String isAccess = encoder.getAccess(password);
			HttpSession session = req.getSession();
			session.setAttribute("code", password);
			session.setAttribute("manager", isAccess);
			try {
				resp.sendRedirect("/crm/clients");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "ok";

	}
}
