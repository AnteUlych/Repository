package racoon.web;

import java.io.IOException;
import java.util.Date;
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
import racoon.model.Request;

@Controller
public class ÑreateRequestServlet {

	@RequestMapping(value = "/createRequest/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code,
			ModelMap model) {

		Encoder encoder = new Encoder();
		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		String manager = encoder.getManagerNameById(managerId);
		int today = encoder.todayDay();

		BaseController base = new BaseController();
		List<String> companies = base.getAllClientsByManager(manager);

		Constants constants = new Constants();
		List<String> services = constants.getAllServices();

		model.addAttribute("companies", companies);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(managerId));
		model.addAttribute("today", today);
		model.addAttribute("services", services);

		return "createRequest";
	}

	@RequestMapping(value = "/createRequest/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		Encoder encoder = new Encoder();
		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		String manager = encoder.getManagerNameById(managerId);
		int today = encoder.todayDay();

		BaseController base = new BaseController();
		List<String> companies = base.getAllClientsByManager(manager);

		Constants constants = new Constants();
		List<String> services = constants.getAllServices();

		model.addAttribute("companies", companies);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(managerId));
		model.addAttribute("today", today);
		model.addAttribute("services", services);

		String route = req.getParameter("route");
		String size = req.getParameter("size");
		String weight = req.getParameter("weight");
		String other = req.getParameter("other");
		String readiness = req.getParameter("readiness");
		String client = req.getParameter("client");
		String service = req.getParameter("service");

		Request request = new Request();

		request.setCompany(client);
		request.setRoute(route);
		request.setCreating(new Date());
		request.setManager(manager);
		request.setSize(size);
		request.setWeight(weight);
		request.setOther(other);
		request.setReadiness(readiness);
		request.setType(service);
		request.setResult(constants.RESULT_EMPTY);

		base.addRequest(request);

		String password = encoder.getPasswordById(managerId);
		String isAccess = encoder.getAccess(password);

		HttpSession session = req.getSession();
		session.setAttribute("code", password);
		session.setAttribute("manager", isAccess);
		try {
			resp.sendRedirect("/crm/clients");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "createRequest";
	}
}
