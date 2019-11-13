package box.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Auction;

@Controller
@RequestMapping("/auction")
public class AuctionServlet {
	
	public String EXPORT = "export";
	public String IMPORT = "import";
	public String CHIEF = "chief";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		
		List <Auction> exportAuctions = new ArrayList();
		List <Auction> importAuctions = new ArrayList();
		List <String> exportIcons = new ArrayList();
		List <String> importIcons  = new ArrayList();
		List <String> exportColors = new ArrayList();
		List <String> importColors  = new ArrayList();
		
		int numberSold = 0;
		String alertSold = "";
		String messagealert = "";
		
		if(!rank.equals(CHIEF)){
			
		DataBaseController base = new DataBaseController();
		DecoderDbToHtml dbToHtml = new DecoderDbToHtml();
		
		exportAuctions = base.getListOfAuctionsByDirection(EXPORT);
		importAuctions = base.getListOfAuctionsByDirection(IMPORT);
		
		numberSold = base.getNumberOfSoldByManagerId(id);
		
		exportIcons = dbToHtml.translateAuctionStatusAndImportanceToJsp(exportAuctions);
		importIcons  = dbToHtml.translateAuctionStatusAndImportanceToJsp(importAuctions);
		
		exportColors = dbToHtml.colourTranslateAuctionStatusAndImportanceToJsp(exportAuctions);
		importColors  = dbToHtml.colourTranslateAuctionStatusAndImportanceToJsp(importAuctions);
		
		//message block		
		if(base.isAnyMessagesForRecipient(id)){
			String textmessagealert = base.getMessageByRecipientid(id).getText();
			messagealert = "alert(\""+textmessagealert+"\");";
			base.deleteMessage(base.getMessageByRecipientid(id).getId());
		}
		//message block
		
		base.closeConnection();
		
		}
		
		if(numberSold!=0){ // alert for not confirmed deals
			alertSold = "<span class=\"w3-badge w3-right w3-red\">"+numberSold+"</span>";
		}
		
		model.addAttribute("messagealert", messagealert);
		
		model.addAttribute("exportAuctions", exportAuctions);
		model.addAttribute("importAuctions", importAuctions);
		model.addAttribute("numberSold", numberSold);
		model.addAttribute("name", name);
		model.addAttribute("alertSold", alertSold);
		
		model.addAttribute("exportIcons", exportIcons);
		model.addAttribute("importIcons", importIcons);
		
		model.addAttribute("exportColors", exportColors);
		model.addAttribute("importColors", importColors);
		
		return "auction";
	}

}
