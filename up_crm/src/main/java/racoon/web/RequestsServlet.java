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
import racoon.model.Manager;
import racoon.model.Request;

@Controller
public class RequestsServlet {

	@RequestMapping(value = "/service/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code,
			ModelMap model) {

	//	Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		List<Request> requests = encoder
				.getRequestsByServiceFromCodeConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		String privateCode = encoder.encodeServiceCode(code);

		List<String> colours = encoder.getTableColour(requests);
		
		model.addAttribute("colours", colours);
		
		model.addAttribute("privateCode", privateCode);
		model.addAttribute("services", services);
		model.addAttribute("requests", requests);
		model.addAttribute("id", manager.getId());
		model.addAttribute("today", encoder.todayDay());

		return "requests";
	}
	@RequestMapping(value = "/service/{code}", method = RequestMethod.POST)
	public String goToClients(@PathVariable("code") String code,
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
				resp.sendRedirect("/crm/clients");
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "ok";
		}

     /**
		Encoder encoder = new Encoder();

		List<Request> requests = encoder
				.getRequestsByServiceFromCodeConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();
		String privateCode = encoder.encodeServiceCode(code);

		model.addAttribute("privateCode", privateCode);
		model.addAttribute("services", services);
		model.addAttribute("requests", requests);
		model.addAttribute("id", manager.getId());
		model.addAttribute("today", encoder.todayDay());

		return "requests";
		*/
		return "ok";
	}
}
