package lotos.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.model.Company;
import lotos.model.Recomendation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecomendationServlet {
	
	@RequestMapping(value = "/recommendations/{status_idCompany}", method = RequestMethod.GET)
	public String selectService(@PathVariable("status_idCompany") String status_idCompany,
			ModelMap model, HttpServletRequest request) {
		
		String[] part = status_idCompany.split("_");
		
		String status = part[0];
		String idCompany = part[1];
		
        int companyId = Integer.parseInt(idCompany);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		List<Recomendation> recommendations = data.getRecomendationsByCompanyId(companyId, status);
		Company company = data.getCompanyById(companyId);
				
		data.closeConnection();
		
		model.addAttribute("logo", logo);
		model.addAttribute("id", id);
		model.addAttribute("recommendations", recommendations);
		model.addAttribute("company", company);
		
		return "recommendation";
		
	}

}
