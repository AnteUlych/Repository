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
import box.model.Deal;

@Controller

public class DealsServlet {
	
	String DIRECTION_ALL = "all";
	String DIRECTION_IMPORT = "import";
	String DIRECTION_EXPORT = "export";
	
	String RANK_MANAGER = "manager";
	
	@RequestMapping(value = "/deals/{direction}", method = RequestMethod.GET)
	public String doGet(@PathVariable("direction") String direction,
			ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 	
		 List<Deal> deals = new ArrayList();
		 
		 String messagealert = "";
		 
		 if((direction.equals(DIRECTION_IMPORT))||(direction.equals(DIRECTION_EXPORT))){
			 
			DataBaseController base = new DataBaseController();
			 
			 if(rank.equals(RANK_MANAGER)){
				 deals = base.getListOfallDealsByManagerIdAndDirection(id, direction);
			 }else{
				 deals = base.getListOfallDealsByDirection(direction);
			 }
			 
				//message block		
				if(base.isAnyMessagesForRecipient(id)){
					String textmessagealert = base.getMessageByRecipientid(id).getText();
					messagealert = "alert(\""+textmessagealert+"\");";
				}
				//message block
			 
			 base.closeConnection();
		 }
		 
		 if((direction.equals(DIRECTION_ALL))){
			 
				DataBaseController base = new DataBaseController();
				 
				 if(rank.equals(RANK_MANAGER)){
					 deals = base.getListOfallDealsByManagerId(id);
				 }else{
					 deals = base.getListOfallDeals();
				 }
				 
					//message block		
					if(base.isAnyMessagesForRecipient(id)){
						String textmessagealert = base.getMessageByRecipientid(id).getText();
						messagealert = "alert(\""+textmessagealert+"\");";
						base.deleteMessage(base.getMessageByRecipientid(id).getId());
					}
					//message block
				 
				 base.closeConnection();
			 }
		 
		 DecoderDbToHtml translateToHtml = new DecoderDbToHtml();
		 
		 List<String> colors = translateToHtml.paintDeals(deals);
		 List<String> dates = translateToHtml.getDatesForHtmlDates(deals);
		 	
		 model.addAttribute("messagealert", messagealert);
		 
		 model.addAttribute("name", name);
		 model.addAttribute("deals", deals);
		 model.addAttribute("colors", colors);
		 model.addAttribute("dates", dates);
		
		 return "deals";
	}

}
