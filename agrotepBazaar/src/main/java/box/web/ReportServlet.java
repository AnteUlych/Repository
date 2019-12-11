package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Report;

@Controller
@RequestMapping("/report")
public class ReportServlet {
	
	String top = "top";
	String coordinator = "coordinator";
	String manager = "manager";
	String BET_CONFIRMED = "bet_confirmed";
	
	String EUR = "EUR";
	String USD = "USD";
	String UAH = "UAH";
	
	String buttonCalculate = "<button type = \"submit\" class=\"w3-button\">&nbsp;<i class=\"fa fa fa-calculator\"></i></button>";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		List<Report> reports = new ArrayList();
		String auctions = "";
		String buttonn = "";
		String tableHead = "";
		
		if(rank.equals(top)||rank.equals(coordinator)){
			
			DataBaseController base = new DataBaseController();
			
			if(rank.equals(top)){
				
			tableHead = "	<tr><th>№</th><th>Менеджер</th><th>Зроблено пропозицій</th><th>Виграно тендерів</th><th>Додатково зароблено, EUR</th><th>Додатково зароблено, USD</th><th>Додатково зароблено, UAH</th></tr>";
				
			List<Manager> managers = base.getListOfManagersByRank(manager);
			
			for(Manager m:managers){
				
				Report report = new Report();
				
				report.setManager(m.getName());
				report.setPropositions(0);
				report.setDeals(0);
				report.setEur(0);
				report.setUah(0);
				report.setUsd(0);
				
				reports.add(report);
			}
			}
			auctions = "Всього проведено аукціонів 0";
			buttonn = buttonCalculate;
			
			base.closeConnection();
		}
		
		
		
		model.addAttribute("tableHead", tableHead);
		model.addAttribute("name", name);
		model.addAttribute("reports", reports);
		model.addAttribute("auctions", auctions);
		model.addAttribute("buttonn", buttonn);
		
		return "report";
	
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		List<Report> reports = new ArrayList();
		String auctions = "";
		String buttonn = "";
		String tableHead = "";
		
		String start = request.getParameter("start");
		String ending = request.getParameter("finish");
		
		if(rank.equals(top)||rank.equals(coordinator)){
			
			DataBaseController base = new DataBaseController();
			
			if(rank.equals(top)){
				
		    tableHead = "	<tr><th>№</th><th>Менеджер</th><th>Зроблено пропозицій</th><th>Виграно тендерів</th><th>Додатково зароблено, EUR</th><th>Додатково зароблено, USD</th><th>Додатково зароблено, UAH</th></tr>";
				
			List<Manager> managers = base.getListOfManagersByRank(manager);
			
			for(Manager m:managers){
				
				Report report = new Report();
				
				report.setManager(m.getName());
				report.setPropositions(base.getNumberOfArchivebetByManagerIdDates(start, ending, m.getId()));
				report.setDeals(base.getNumberOfArchivebetByManagerIdAndStatusDates(start, ending, m.getId(), BET_CONFIRMED));
				report.setEur(base.getSummOfArchivebetByManagerIdAndStatusDates(start, ending, m.getId(), BET_CONFIRMED, EUR));
				report.setUah(base.getSummOfArchivebetByManagerIdAndStatusDates(start, ending, m.getId(), BET_CONFIRMED, UAH));
				report.setUsd(base.getSummOfArchivebetByManagerIdAndStatusDates(start, ending, m.getId(), BET_CONFIRMED, USD));
				
				reports.add(report);
			}
			}
			auctions = "<a href=\"auctionreport/"+start+"_"+ending+"\">Всього проведено аукціонів " + base.getNumberOfArchiveauctionDates(start, ending)+"</a>";
			buttonn = buttonCalculate;
			
			base.closeConnection();
		}
		
		
		
		model.addAttribute("tableHead", tableHead);
		model.addAttribute("name", name);
		model.addAttribute("reports", reports);
		model.addAttribute("auctions", auctions);
		model.addAttribute("buttonn", buttonn);
		
	
		return "report";	
	}

}
