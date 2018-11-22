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
import racoon.model.Client;
import racoon.model.Manager;
import racoon.model.Request;
import racoon.model.Status;

@Controller
public class ClientServlet {

	@RequestMapping(value = "/client/{code}", method = RequestMethod.GET)
	public String selectClient(@PathVariable("code") String code, ModelMap model) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		Client client = encoder.getClientByIdCodeFromConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);
		
		// disabled button
		String mayIClick = "disabled";
		if(client.getManager().equals(manager.getName())){
			mayIClick = "";
		}

		model.addAttribute("mayIClick", mayIClick);
		
		//BaseController base = new BaseController();
		
		//List<Request> requests = base.getAllRequestsByCompany(client
		//		.getCompany());
		//List<Status> statuses = base.getAllStatusByCompanyId(client.getId());
		
		List<Request> requests = encoder.getAllRequestsByCompany(client
				.getCompany());
		List<Status> statuses = encoder.getAllStatusByCompanyId(client.getId());

		Constants constants = new Constants();
		List<String> funnels = constants.getAllFunnel();

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		
		
		model.addAttribute("managerId", manager.getId());
		model.addAttribute("today", encoder.todayDay());

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		model.addAttribute("funnels", funnels);

		model.addAttribute("requests", requests);
		model.addAttribute("statuses", statuses);

		model.addAttribute("answer", client.getAnswer());
		model.addAttribute("category", client.getCategory());
		model.addAttribute("company", client.getCompany());
		model.addAttribute("funnel", client.getFunnel());
		model.addAttribute("mail", client.getMail());
		model.addAttribute("nextcall", client.getNextcall());
		model.addAttribute("person", client.getPerson());
		model.addAttribute("phone", client.getPhone());
		model.addAttribute("code", client.getCode());

		model.addAttribute("nextPage", code);
		
		encoder.closeConnection();

		return "client";
	}

	@RequestMapping(value = "/client/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		Client client = encoder.getClientByIdCodeFromConsole(code);
		Manager manager = encoder.getFullInfoByManagerByCode(code);
		// make disabled button

		//BaseController base = new BaseController();
		//List<Request> requests = base.getAllRequestsByCompany(client
		//		.getCompany());
		//List<Status> statuses = base.getAllStatusByCompanyId(client.getId());
		
		List<Request> requests = encoder.getAllRequestsByCompany(client
				.getCompany());
		List<Status> statuses = encoder.getAllStatusByCompanyId(client.getId());

		Constants constants = new Constants();
		List<String> funnels = constants.getAllFunnel();

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		model.addAttribute("managerId", manager.getId());
		model.addAttribute("today", encoder.todayDay());

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(manager.getId()));

		model.addAttribute("funnels", funnels);

		model.addAttribute("requests", requests);
		model.addAttribute("statuses", statuses);

		model.addAttribute("answer", client.getAnswer());
		model.addAttribute("category", client.getCategory());
		model.addAttribute("company", client.getCompany());
		model.addAttribute("funnel", client.getFunnel());
		model.addAttribute("mail", client.getMail());
		model.addAttribute("nextcall", client.getNextcall());
		model.addAttribute("person", client.getPerson());
		model.addAttribute("phone", client.getPhone());
		model.addAttribute("code", client.getCode());

		model.addAttribute("nextPage", code);
/**
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
		*/

		String fun = req.getParameter("fun");
		String nextcall = req.getParameter("nextcall");
		String comment = req.getParameter("comment");

		if (fun != null && nextcall != null && comment != null) {
			Status status = new Status();

			status.setFunnel(fun);
			status.setAnswer(comment);
			status.setLasttime(new Date());
			status.setClientId(client.getId());

			encoder.addStatus(status);
			encoder.editClientStatus(client.getId(), comment,
					encoder.makeStringtoDate(nextcall), fun);
			//fix
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
		}
		encoder.closeConnection();
		return "client";
	}
}
