package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Archivebet;
import box.model.Manager;

@Controller
public class FiltrBetArchiveServlet {
	
	String BET_CONFIRMED = "bet_confirmed";
	
	@RequestMapping(value = "/filtrbetsreport/{filtr}", method = RequestMethod.GET)
	public String doGet(@PathVariable("filtr") String filtr,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String[] param = filtr.split("_");
		 String dateFrom = param[0]; 
		 String dateTo = param[1]; 	 
		 int managerid = Integer.parseInt(param[2]);
		 String wichBets = param[3];
		 
		 DataBaseController base = new DataBaseController();
		 List<Archivebet> betsreport = new ArrayList();
		 
		 Manager manager = base.getManagerById(managerid);
		 
		 String information = "";
		
		 if(wichBets.equals("win")){
			 betsreport = base.getListOfArchivebetByManagerIdAndStatusDates(dateFrom, dateTo, managerid, BET_CONFIRMED);
			 information = "Виграшні пропозиції від "+dateFrom+" по "+dateTo+" менеджера "+manager.getName();
		 }else{
			 betsreport = base.getListOfArchivebetByManagerIdDates(dateFrom, dateTo, managerid);
			 information = "Всі пропозиції від "+dateFrom+" по "+dateTo+" менеджера "+manager.getName();
		 }
		 
		 base.closeConnection();
		 
		 DecoderDbToHtml color = new DecoderDbToHtml();
		 List<String> colors = color.paintWinArchiveBet(betsreport);
		 
		 model.addAttribute("name", name);
		 model.addAttribute("betsreport", betsreport);
		 model.addAttribute("colors", colors);
		 model.addAttribute("information", information);
		
		 
		return "filtrbetsreport";
	}

}
