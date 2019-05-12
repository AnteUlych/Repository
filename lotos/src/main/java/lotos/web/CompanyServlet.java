package lotos.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.model.Company;
import lotos.model.Deal;
import lotos.model.Proposition;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CompanyServlet {
	
	@RequestMapping(value = "/company/{idCompany}", method = RequestMethod.GET)
	public String selectService(@PathVariable("idCompany") String idCompany,
			ModelMap model, HttpServletRequest request) {
		
		int companyId = Integer.parseInt(idCompany);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		DataController data = new DataController();
		
		Company company = data.getCompanyById(companyId);
		
		List<Tender> companyTenders = data.getOpenTendersByCompanyId(companyId);
		List<Proposition> companyProposition = data.getPropositionsByCompanyId(companyId);	
		List<Deal> companyDeal = data.getDealsByCompanyOrPropositionId(companyId, companyId);
		
	    boolean isOwnCompany = false;
	    if(companyId==id){
	    	isOwnCompany = true;
	    }
	    
	    int numberOfTenders = data.getNumberOfTendersByCompanyId(companyId);
	    int numberOfGoodRecomendations = data.getNumberOfGoodRecomendationByCompanyId(companyId);
	    int numberOfBadRecomendations = data.getNumberOfBadRecomendationByCompanyId(companyId);
		int numberOfClosingTenders = data.getNumberofClosingDealsByCompanyId(companyId);
		int numberOfWinningPropositions = data.getNumberWinningDealsByCompanyId(companyId);
	    
		List<Proposition> propositions = new ArrayList();
		
		for(Tender tender:companyTenders){
			List<Proposition> tendersPropositions = data.getPropositionsByTenderId(tender.getId());
			propositions.addAll(tendersPropositions);
		}
		
		data.closeConnection();		
		
		model.addAttribute("companyId", companyId);
		model.addAttribute("id", id);
		
		model.addAttribute("company", company);
		model.addAttribute("companyTenders", companyTenders);
		model.addAttribute("companyProposition", companyProposition);
		model.addAttribute("companyDeal", companyDeal);
		model.addAttribute("isOwnCompany", isOwnCompany);
		model.addAttribute("propositions", propositions);
		
		model.addAttribute("numberOfTenders", numberOfTenders);
		model.addAttribute("numberOfGoodRecomendations", numberOfGoodRecomendations);
		model.addAttribute("numberOfBadRecomendations", numberOfBadRecomendations);
		model.addAttribute("numberOfClosingTenders", numberOfClosingTenders);
		model.addAttribute("numberOfWinningPropositions", numberOfWinningPropositions);
		
		
		return "company";
	}
}
