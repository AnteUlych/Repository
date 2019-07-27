package lotos.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.logic.SimpleLogic;
import lotos.model.Company;
import lotos.model.CompanyForStatistic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/adminCompanies")
public class AdminCompaniesServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String cyrex = (String) session.getAttribute("cyrex");
		SimpleLogic logic = new SimpleLogic();
		if(!logic.isPasswordForAdninRight(cyrex)){
			return "adminAccessDenied";
		}
		
		List<CompanyForStatistic> statistic = new ArrayList();
    	DataController data = new DataController();
    	List<Company> companies = data.getAllCompanies();
    	
    	for(Company companie:companies){
    		
    		int numberOfGoodComments = data.getNumberOfGoodRecomendationByCompanyId(companie.getId());
    	    int numberOfBadComments = data.getNumberOfBadRecomendationByCompanyId(companie.getId());
    		int numberOfPropositionDeals = data.getNumberWinningDealsByCompanyId(companie.getId());
    		int numberOfTenderDeals = data.getNumberofClosingDealsByCompanyId(companie.getId());
    		
    		CompanyForStatistic stat = new CompanyForStatistic();
    		
    		stat.setCode(companie.getCode());
    		stat.setCompany(companie.getCompany());
    		stat.setMail(companie.getMail());
    		stat.setManager(companie.getManager());
    		stat.setMobile(companie.getMobile());
    		stat.setPhone(companie.getPhone());
    		stat.setRegistration(companie.getRegistration());
    		stat.setNumberOfBadComments(numberOfBadComments);
    		stat.setNumberOfGoodComments(numberOfGoodComments);
    		stat.setNumberOfPropositionDeals(numberOfPropositionDeals);
    		stat.setNumberOfTenderDeals(numberOfTenderDeals);
    		
    		statistic.add(stat);
    		
    	}
    	
    	data.closeConnection();
    	
    	model.addAttribute("statistic", statistic);
		
		return "adminCompanies";
	}

}
