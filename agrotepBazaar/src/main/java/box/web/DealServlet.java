package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Archivebet;
import box.model.Deal;

@Controller
public class DealServlet {
	
	String TOP = "top";
	String COORDINATOR = "coordinator";
	String STATUS_CANCEL = "deal_canceled";
	String BET_CANCEL = "bet_canceled";
	
	String CHANGE = "<button type=\"submit\" name = \"confirm\" class=\"w3-button w3-green\">«м≥нити</button>";
	
	@RequestMapping(value = "/deal/{dealid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("dealid") String dealid,
			ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
         String buttonChange = "";

         DataBaseController base = new DataBaseController();
         int iddeal = Integer.parseInt(dealid);	
         Deal deal = base.getDealById(iddeal);
         
         base.closeConnection();
         
         if(rank.equals(COORDINATOR)){
        	 buttonChange = CHANGE;
         }
         
         model.addAttribute("name", name);
         model.addAttribute("buttonChange", buttonChange);
         model.addAttribute("deal", deal);
		
		return "deal";
	}
	
	@RequestMapping(value = "/deal/{dealid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("dealid") String dealid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
         String buttonChange = "";

         DataBaseController base = new DataBaseController();
         int iddeal = Integer.parseInt(dealid);	
         Deal deal = base.getDealById(iddeal);
                  
         if(rank.equals(COORDINATOR)){
        	 buttonChange = CHANGE;
         }
         
         model.addAttribute("name", name);
         model.addAttribute("buttonChange", buttonChange);
         model.addAttribute("deal", deal);
         
         //post starts here
		
         String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String status = request.getParameter("status");
			String driver = request.getParameter("driver");
			
			if (driver != null){
				try {
					driver = new String(driver.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if(status.equals(STATUS_CANCEL)){
				
				Archivebet arbet = base.getArchivebetByBetid(deal.getBetid());
				base.editArchivebetById(arbet.getId(), BET_CANCEL);
			}
			
			base.editStatusOfDealById(iddeal, status);
			base.editTruckdriverById(iddeal, driver);
   
            base.closeConnection();
            
            try {
				response.sendRedirect("/bazaar/deals/all");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "deals";
         
		
	}

}
