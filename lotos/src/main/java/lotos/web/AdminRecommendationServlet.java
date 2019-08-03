package lotos.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Recomendation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminRecommendationServlet {
	
	@RequestMapping(value = "/adminRecommendation/{idRec}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idRec") String idRec,
			ModelMap model, HttpServletRequest request) {
	
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		int recId = (Integer) Integer.parseInt(idRec);
		
		DataController data = new DataController();
		Recomendation recomendation = data.getRecomendationById(recId);	
		data.closeConnection();
		     
		model.addAttribute("recomendationdate", recomendation.getRecomendationdate());
		model.addAttribute("rate", recomendation.getRate());
		model.addAttribute("companytender", recomendation.getCompanytender());
		model.addAttribute("companyproposition", recomendation.getCompanyproposition());
		model.addAttribute("transport", recomendation.getTransport());
		model.addAttribute("incoterms", recomendation.getIncoterms());
		model.addAttribute("countryfrom", recomendation.getCountryfrom());
		model.addAttribute("countryto", recomendation.getCountryto());
		model.addAttribute("weight", recomendation.getWeight());
		model.addAttribute("whyinfo", recomendation.getWhyinfo());

		return "adminRecommendation";
		
	}
	
	@RequestMapping(value = "/adminRecommendation/{idRec}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("idRec") String idRec,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		int recId = (Integer) Integer.parseInt(idRec);
		
		DataController data = new DataController();
		Recomendation recomendation = data.getRecomendationById(recId);	
	     
		model.addAttribute("recomendationdate", recomendation.getRecomendationdate());
		model.addAttribute("rate", recomendation.getRate());
		model.addAttribute("companytender", recomendation.getCompanytender());
		model.addAttribute("companyproposition", recomendation.getCompanyproposition());
		model.addAttribute("transport", recomendation.getTransport());
		model.addAttribute("incoterms", recomendation.getIncoterms());
		model.addAttribute("countryfrom", recomendation.getCountryfrom());
		model.addAttribute("countryto", recomendation.getCountryto());
		model.addAttribute("weight", recomendation.getWeight());
		model.addAttribute("whyinfo", recomendation.getWhyinfo());
		
		if (request.getParameter("hide") != null) {			
			data.hideRecomendation(recId);
		}
		
		if (request.getParameter("delete") != null) {			
			data.deleteRecomendation(recId);;
		}
		
		data.closeConnection();
		
		try {
			response.sendRedirect("/lotos/adminRequests");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "adminRequests";
	
	}

}
