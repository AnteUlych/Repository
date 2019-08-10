package lotos.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lotos.logic.DataController;
import lotos.model.Company;
import lotos.model.Proposition;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class InformationServlet {
	
	@RequestMapping(value = "/information/{info}", method = RequestMethod.GET)
	public String selectService(@PathVariable("info") String info,
			ModelMap model, HttpServletRequest request) {
		

		if(info.equals("about")){
			return "about";
		}else if(info.equals("donate")){
			return "donate";
		}else if(info.equals("contacts")){
			return "contacts";
		}
	
		return "404";
		
	}

}
