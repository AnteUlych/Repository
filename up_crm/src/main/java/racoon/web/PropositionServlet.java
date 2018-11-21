package racoon.web;

import java.io.IOException;
import java.util.Date;
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
import racoon.model.Proposition;
import racoon.model.Request;

@Controller
public class PropositionServlet {

	@RequestMapping(value = "/proposition/{code}", method = RequestMethod.GET)
	public String selectProposition(@PathVariable("code") String code,
			ModelMap model) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		int requestId = encoder.getIdOfRequestFromRequestsPage(code);

		//BaseController base = new BaseController();
		//Request request = base.getRequestById(requestId);
		Request request = encoder.getRequestById(requestId);

		Constants constantBase = new Constants();
		List<String> services = constantBase.getAllServices();

		model.addAttribute("services", services);
		model.addAttribute("privateCode",
				encoder.getCodePasswordById(managerId));
		model.addAttribute("managerId", managerId);

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

		return "proposition";
	}

	@RequestMapping(value = "/proposition/{code}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("code") String code,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {

		//Encoder encoder = new Encoder();
		BaseController encoder = new BaseController();

		int managerId = encoder.getIdOfManagerFromRequestsPage(code);
		int requestId = encoder.getIdOfRequestFromRequestsPage(code);

		//BaseController base = new BaseController();

		String rate = req.getParameter("rate");
		String delivery = req.getParameter("delivery");
		String description = req.getParameter("description");

		Constants constants = new Constants();

		Proposition proposition = new Proposition();

		proposition.setRequestId(requestId);
		proposition.setAnswer(new Date());
		proposition.setRate(rate);
		proposition.setDelivery(delivery);
		proposition.setDescription(description);
		proposition.setManager(encoder.getManagerNameById(managerId));
		proposition.setResult(constants.RESULT_WAITING);

		//base.addProposition(proposition);
		encoder.addProposition(proposition);
		/**
		Request request = base.getRequestById(requestId);
		if(request.getResult().equals(constants.RESULT_EMPTY)){
			base.startTradeForRequest(requestId, constants.RESULT_WAITING);
		}

		int today = encoder.todayDay();
*/
		Request request = encoder.getRequestById(requestId);
		if(request.getResult().equals(constants.RESULT_EMPTY)){
			encoder.startTradeForRequest(requestId, constants.RESULT_WAITING);
		}

		int today = encoder.todayDay();
		
		try {
			resp.sendRedirect("/crm/request/" + today + "_" + managerId + "_"
					+ requestId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "proposition";
	}

}
