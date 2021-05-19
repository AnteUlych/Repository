package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.History;

@Controller
public class StatisticByManagerServlet {
	
	@RequestMapping(value = "/statisticbymanager/{somecode}", method = RequestMethod.GET)
	public String doGet(@PathVariable("somecode") String somecode,
			ModelMap model, HttpServletRequest request) {
		
		String code [] = somecode.split("&_");
		
		int managerId = Integer.parseInt(code [0]);
		DataBaseController base = new DataBaseController();
		
		List<History> histories = base.getListOfHistoryByManageridBetweenDates(code [1], code [2], managerId);
		List<String> logos = new ArrayList();
		String managername = base.getManagerById(managerId).getName();
		
		for(History h:histories){
			if(h.getAction()==Constants.ACTION_CALCULATE){
				logos.add("<i class=\"fa fa-calculator w3-text-blue\"></i>");
			}
			if(h.getAction()==Constants.ACTION_BOOKING){
				logos.add("<i class=\"fa fa-check w3-text-green\"></i>");
			}
			if(h.getAction()==Constants.ACTION_HELP){
				logos.add("<i class=\"fa fa-handshake-o w3-text-lime\"></i>");
			}
			if(h.getAction()==Constants.ACTION_NEW_CLIENT){
				logos.add("<i class=\"fa fa-pied-piper-alt w3-text-orange\"></i>");
			}
			if(h.getAction()==Constants.ACTION_DELETE){
				logos.add("<i class=\"fa fa-remove w3-text-red\"></i>");
			}
			
		}
				
		base.closeConnection();
		
		model.addAttribute("histories", histories);
		model.addAttribute("logos", logos);
		
		model.addAttribute("managername", managername);
		model.addAttribute("start", code [1]);
		model.addAttribute("finish", code [2]);
				
		return "statisticbymanager";
	}

}
