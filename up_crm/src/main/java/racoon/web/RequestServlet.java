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
import racoon.logic.Sender;
import racoon.model.Proposition;
import racoon.model.Request;

@Controller
public class RequestServlet {

	@RequestMapping(value = "/request/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code,
			ModelMap model) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();
try{
		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		int requestId = encoder.getIdOfRequestFromRequestsPage(code);
		
		
				
		int today = encoder.todayDay();

		//BaseController base = new BaseController();
	//	Request request = base.getRequestById(requestId);
	//	List<Proposition> propositions = base
	//			.getAllPropositionsByRequest(requestId);
		
		Request request = encoder.getRequestById(requestId);
		List<Proposition> propositions = encoder
				.getAllPropositionsByRequest(requestId);
		
		// disabled button
		String manager = encoder.getManagerNameById(managerId);
		List<String> taboo = encoder.getTableTaboo(propositions, manager);
		model.addAttribute("taboo", taboo);
		
		String mayIClick = "disabled";
		if(request.getManager().equals(encoder.getManagerNameById(managerId))){
			mayIClick = "";
		}
		
		model.addAttribute("mayIClick", mayIClick);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(managerId));
		model.addAttribute("managerId", managerId);
		model.addAttribute("today", today);
		model.addAttribute("propositions", propositions);

		model.addAttribute("company", request.getCompany());
		model.addAttribute("creating", request.getCreating());
		model.addAttribute("manager", request.getManager());
		model.addAttribute("other", request.getOther());
		model.addAttribute("readiness", request.getReadiness());
		model.addAttribute("result", request.getResult());
		model.addAttribute("route", request.getRoute());
		model.addAttribute("size", request.getSize());
		model.addAttribute("weight", request.getWeight());
		model.addAttribute("requestId", request.getId());

		encoder.closeConnection();
		
		return "request";
	}catch(NullPointerException e){
		encoder.closeConnection();
		return "exception";
	}
	}

	@RequestMapping(value = "/request/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		//Encoder encoder = new Encoder();
				BaseController encoder = new BaseController();

		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		int requestId = encoder.getIdOfRequestFromRequestsPage(code);
		int today = encoder.todayDay();

		//BaseController base = new BaseController();
		//Request request = base.getRequestById(requestId);
		//List<Proposition> propositions = base
		//		.getAllPropositionsByRequest(requestId);
		
		Request request = encoder.getRequestById(requestId);
		List<Proposition> propositions = encoder
				.getAllPropositionsByRequest(requestId);

		model.addAttribute("privateCode",
				encoder.getCodePasswordById(managerId));
		model.addAttribute("managerId", managerId);
		model.addAttribute("today", today);
		model.addAttribute("propositions", propositions);

		model.addAttribute("company", request.getCompany());
		model.addAttribute("creating", request.getCreating());
		model.addAttribute("manager", request.getManager());
		model.addAttribute("other", request.getOther());
		model.addAttribute("readiness", request.getReadiness());
		model.addAttribute("result", request.getResult());
		model.addAttribute("route", request.getRoute());
		model.addAttribute("size", request.getSize());
		model.addAttribute("weight", request.getWeight());
		model.addAttribute("requestId", request.getId());
		
		Sender bird = new Sender();
		Constants constant = new Constants();

		for (Proposition deal : propositions) {

			if (req.getParameter("delete" + deal.getId()) != null) {
				//base.deleteProposition(deal.getId());
				encoder.deleteProposition(deal.getId());
				encoder.closeConnection();
				return "redirect:";
			}

			if (req.getParameter("confirm" + deal.getId()) != null) {
				//base.confirmProposition(deal.getId(), requestId);
				encoder.confirmProposition(deal.getId(), requestId);
				bird.sendToDepartment(request.getManager()+" has booked request "+request.getId(), "http://uplg.info/crm/login", constant.getDepartmentMail(request.getType()));
				encoder.closeConnection();
				return "redirect:";
			}

		}
		if (req.getParameter("cancel") != null) {
			//base.cancelProposition(requestId);
			String whynot = req.getParameter("whynot");
			encoder.cancelProposition(requestId, whynot);
			bird.sendToDepartment(request.getManager()+" has canceled request "+request.getId(), "http://uplg.info/crm/login", constant.getDepartmentMail(request.getType()));
			
			String password = encoder.getPasswordById(managerId);
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
			encoder.closeConnection();
			return "ok";
			
			//encoder.closeConnection();
			//return "redirect:";
		}
		encoder.closeConnection();
		return "request";
	}
}
