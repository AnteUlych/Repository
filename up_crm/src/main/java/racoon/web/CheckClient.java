package racoon.web;

import java.io.IOException;
import java.util.List;

import javax.persistence.NoResultException;
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

@Controller
public class CheckClient {

	@RequestMapping(value = "/check/{code}", method = RequestMethod.GET)
	public String selectClient(@PathVariable("code") String code, ModelMap model) {

	//	Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();
try{
		Manager manager = encoder.getFullInfoByManagerByCode(code);
		// make disabled button

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		model.addAttribute("managerId", manager.getId());

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		model.addAttribute("nextPage", code);

		encoder.closeConnection();
		
		return "check";
	}catch(NullPointerException e){
		encoder.closeConnection();
		return "exception";
	}

	}

	@RequestMapping(value = "/check/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

//		Encoder encoder = new Encoder();
			BaseController encoder = new BaseController();

		Manager manager = encoder.getFullInfoByManagerByCode(code);

		if (req.getParameter("back") != null) {
			String password = manager.getCode() + "";
			String isAccess = encoder.getAccess(password);
			HttpSession session = req.getSession();
			session.setAttribute("code", password);
			session.setAttribute("manager", isAccess);
			try {
				encoder.closeConnection();
				resp.sendRedirect("/crm/clients");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "ok";
		}

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		String cod = req.getParameter("cod");
		try {
			//BaseController base = new BaseController();
		//	Client client = base.getClientByCode(cod);
			Client client = encoder.getClientByCode(cod);

			model.addAttribute("clientId", client.getId());
			model.addAttribute("company", client.getCompany());
			model.addAttribute("worker", client.getManager());

			model.addAttribute("managerId", manager.getId());

			model.addAttribute("services", services);
			model.addAttribute("privateCode",
					encoder.getCodePasswordById(manager.getId()));

			model.addAttribute("nextPage", code);

		} catch (NoResultException e) {
			try {
				encoder.closeConnection();
				resp.sendRedirect("/crm/check/" + code);
			} catch (IOException e1) {
				e.printStackTrace();
			}

			return "ok";
		}
		encoder.closeConnection();
		return "check";
	}
}
