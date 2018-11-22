package racoon.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import racoon.logic.BaseController;
import racoon.logic.Constants;
import racoon.logic.Encoder;
import racoon.model.Proposition;
import racoon.model.Request;

@Controller
public class RequestServlet {

	@RequestMapping(value = "/request/{code}", method = RequestMethod.GET)
	public String selectService(@PathVariable("code") String code,
			ModelMap model) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

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
	}

	@RequestMapping(value = "/request/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletRequest resp) {

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
				encoder.closeConnection();
				return "redirect:";
			}

		}
		if (req.getParameter("cancel") != null) {
			//base.cancelProposition(requestId);
			encoder.cancelProposition(requestId);
			encoder.closeConnection();
			return "redirect:";
		}
		encoder.closeConnection();
		return "request";
	}
}
