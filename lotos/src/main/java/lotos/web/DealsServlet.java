package lotos.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.model.Deal;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DealsServlet {
	
	@RequestMapping(value = "/deals/{filter}", method = RequestMethod.GET)
	public String selectService(@PathVariable("filter") String filter,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		List<Deal> companyDeals = new ArrayList();
		
		if(filter.equals("tender")){
			companyDeals = data.getDealsByCompanyId(id);
		}else if(filter.equals("transport")){
			companyDeals = data.getDealsByTransportId(id);
		}else{
			companyDeals = data.getDealsByCompanyOrPropositionId(id, id);
		}
		
		data.closeConnection();		
		
		model.addAttribute("deals", companyDeals);
		model.addAttribute("logo", logo);
	
		return "deals";
	}

}
