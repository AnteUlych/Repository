package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.logic.MailController;
import lotos.logic.SimpleLogic;
import lotos.model.Company;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Recomendation;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DealServlet {
	
	@RequestMapping(value = "/deal/{idDeal}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idDeal") String idDeal,
			ModelMap model, HttpServletRequest request) {
		
        int dealId = Integer.parseInt(idDeal);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		Deal deal = data.getDealById(dealId);
		boolean isRecommendationExist = data.isRecomendationExist(dealId);
		
		Recomendation recommendation;
		
		if(isRecommendationExist){
			recommendation = data.getRecomendationByDealId(dealId);
		}else{
			recommendation = new Recomendation();
		}
		
		data.closeConnection();
		
		ConstantBase constant = new ConstantBase();
		List<String> rates = constant.getRateBase();
		
		model.addAttribute("isRecommendationExist", isRecommendationExist);
		model.addAttribute("logo", logo);
		model.addAttribute("deal", deal);
		model.addAttribute("id", id);
		model.addAttribute("recommendation", recommendation);
		model.addAttribute("rates", rates);

		return "deal";
		
	}
	
		@RequestMapping(value = "/deal/{idDeal}", method = RequestMethod.POST)
		public String postProposition(@PathVariable("idDeal") String idDeal,
				ModelMap model, HttpServletRequest request, HttpServletResponse response) {
			
			
			
			 int dealId = Integer.parseInt(idDeal);
				
				HttpSession session = request.getSession();
				int id = (Integer) session.getAttribute("id");
				String logo = (String) session.getAttribute("logo");
				
				DataController data = new DataController();
				
				Deal deal = data.getDealById(dealId);
				boolean isRecommendationExist = data.isRecomendationExist(dealId);
				
				Recomendation recommendation;
				
				if(isRecommendationExist){
					recommendation = data.getRecomendationByDealId(dealId);
				}else{
					recommendation = new Recomendation();
				}
			
				ConstantBase constant = new ConstantBase();
				List<String> rates = constant.getRateBase();
				
				model.addAttribute("isRecommendationExist", isRecommendationExist);
				model.addAttribute("logo", logo);
				model.addAttribute("deal", deal);
				model.addAttribute("id", id);
				model.addAttribute("recommendation", recommendation);
				model.addAttribute("rates", rates);
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					
					clientEnc = "Cp1251";
				String whyinfo = request.getParameter("comment");
				String rate = request.getParameter("assessment");
				
				if(whyinfo.equals(null)){
					whyinfo = " ";
				}
				
				if (whyinfo != null){
					try {
						whyinfo = new String(whyinfo.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				SimpleLogic logic = new SimpleLogic();
				
				data.addRecommendation(dealId, id, deal.getCompanytenderid(), deal.getCompanypropositionid(), deal.getCompanytender(), deal.getCompanyproposition(), deal.getTenderdeal(), logic.fixDateInString(), "-", deal.getCountryfrom(), deal.getCountryto(), deal.getWeight(), deal.getTransport(), rate, whyinfo);
				
				data.closeConnection();
				
				try {
					response.sendRedirect("/lotos/deals/all");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
				return "deals";
	}

}
