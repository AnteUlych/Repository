package box.web;

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
import box.model.Archiveauction;
import box.model.Archivebet;

@Controller
public class BetsReportServlet {
	
	@RequestMapping(value = "/betsreport/{fromtodateauctionid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("fromtodateauctionid") String fromtodateauctionid,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String[] dates = fromtodateauctionid.split("_");
		 String dateFrom = dates[0]; 
		 String dateTo = dates[1]; 
		 int auctionid = Integer.parseInt(dates[2]);
		 
		 DataBaseController base = new DataBaseController();
		 
		 Archiveauction auction = base.getArchiveauctionByAuctionId(auctionid);
		 List<Archivebet> bets = base.getListOfArchivebetsByAuctionId(auctionid);
		 
		 DecoderDbToHtml color = new DecoderDbToHtml();
		 List<String> colors = color.paintWinArchiveBet(bets);
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("auction", auction);
		 model.addAttribute("bets", bets);
		 model.addAttribute("colors", colors);
		 model.addAttribute("datesLink", dates[0]+"_"+dateTo);
		
     	return "betsreport";
	}

}
