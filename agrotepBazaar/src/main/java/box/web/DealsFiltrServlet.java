package box.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Deal;

@Controller
@RequestMapping("/dealsfiltr")
public class DealsFiltrServlet {
	
	String RANK_MANAGER = "manager";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		List<Deal> deals = new ArrayList();
		
		Date today = new Date();
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
		
		String dateStartText = formatter.format(today);
		String dateFinishText = formatter.format(today);
		
		model.addAttribute("name", name);
		model.addAttribute("dateStartText", dateStartText);
		model.addAttribute("dateFinishText", dateFinishText);
		model.addAttribute("deals", deals);
		
		return "dealsfiltr";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		List<Deal> deals = new ArrayList();
		
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		
		DataBaseController base = new DataBaseController();
		
		if(RANK_MANAGER.equals(rank)){
		deals = base.getListOfDealsBetweenDatesAndManagerId(start, finish, id);
		}else{
		deals = base.getListOfDealsBetweenDates(start, finish);
		}
		
		base.closeConnection();
		
		DecoderDbToHtml translateToHtml = new DecoderDbToHtml();

		List<String> colors = translateToHtml.paintDeals(deals);
		List<String> dates = translateToHtml.getDatesForHtmlDates(deals);
		

		model.addAttribute("name", name);
		model.addAttribute("dateStartText", start);
		model.addAttribute("dateFinishText", finish);
		model.addAttribute("deals", deals);
		
		model.addAttribute("colors", colors);
		model.addAttribute("dates", dates);
		
		return "dealsfiltr";
		
	}

}
