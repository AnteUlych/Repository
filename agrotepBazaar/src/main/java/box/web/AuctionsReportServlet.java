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

@Controller
public class AuctionsReportServlet {
	
	@RequestMapping(value = "/auctionreport/{fromtodate}", method = RequestMethod.GET)
	public String doGet(@PathVariable("fromtodate") String fromtodate,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String[] dates = fromtodate.split("_");
		 String dateFrom = dates[0]; 
		 String dateTo = dates[1]; 
		 
		 DataBaseController base = new DataBaseController();
		 List<Archiveauction> auctions = base.getListOfArchiveauctionDates(dateFrom, dateTo);
		 
		 DecoderDbToHtml translater = new DecoderDbToHtml();
		 List<String> auctionIcons = translater.translateArchiveauctionStatusAndImportanceToJsp(auctions);
		 List<String> colors = 	translater.translateColorOfArchiveauction(auctions);
		 
		 base.closeConnection();
		 
		 model.addAttribute("auctions", auctions);
		 model.addAttribute("name", name);
		 model.addAttribute("dateFrom", dateFrom);
		 model.addAttribute("dateTo", dateTo);
		 model.addAttribute("auctionIcons", auctionIcons);
		 model.addAttribute("colors", colors);

		
		return "auctionreport";
	}

}
