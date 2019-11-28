package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import box.model.Message;

@Controller
public class DealServlet {
	
	String TOP = "top";
	String COORDINATOR = "coordinator";
	String STATUS_CANCEL = "deal_canceled";
	String STATUS_CONFIRMED = "deal_ok";
	String BET_CANCEL = "bet_canceled";
	
	String CHANGE = "<button type=\"submit\" name = \"confirm\" class=\"w3-button w3-green\">Змінити</button>";
	
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
         
         DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); 
         String ready = dateFormat1.format(deal.getDateoftransportation()); 
        		        	        
         model.addAttribute("name", name);
         model.addAttribute("buttonChange", buttonChange);
         model.addAttribute("deal", deal);
         model.addAttribute("ready", ready);
		
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
         
         DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd"); 
         String ready = dateFormat1.format(deal.getDateoftransportation());
         
         model.addAttribute("name", name);
         model.addAttribute("buttonChange", buttonChange);
         model.addAttribute("deal", deal);
         model.addAttribute("ready", ready);
         
         //post starts here
		
         String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String status = request.getParameter("status");
			String driver = request.getParameter("driver");
			String otherinformation = request.getParameter("otherinformation");
			String readiness = request.getParameter("readiness");
			
			DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd"); //changed bug of mounth
			Date dateoftransportation = null;

			try {
				dateoftransportation = format2.parse(readiness);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (driver != null){
				try {
					driver = new String(driver.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (otherinformation != null){
				try {
					otherinformation = new String(otherinformation.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if(otherinformation.equals(null)){
				otherinformation="";
			}
			
			if(status.equals(STATUS_CANCEL)){
				
				//message
				Date nowDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("hh:mm");  
				String messagedate = dateFormat.format(nowDate);  
				
				String textmessage = messagedate+" напрямок "+deal.getInformation()+" скасовано.";
				Message message = new Message();
				message.setRecipientid(deal.getManagerid());
				message.setText(textmessage);
				base.addMessage(message);
				//message
				
				Archivebet arbet = base.getArchivebetByBetid(deal.getBetid());
				base.editArchivebetById(arbet.getId(), BET_CANCEL);
			}
			
			if(status.equals(STATUS_CONFIRMED)){
				
				//message
				Date nowDate = new Date();
				DateFormat dateFormat = new SimpleDateFormat("hh:mm");  
				String messagedate = dateFormat.format(nowDate); 
				
				String textmessage = messagedate+" напрямок "+deal.getInformation()+" підтверджено на "+readiness+" - "+driver+".";
				Message message = new Message();
				message.setRecipientid(deal.getManagerid());
				message.setText(textmessage);
				base.addMessage(message);
				//message
				
			}
			
			base.editStatusOfDealById(iddeal, status);
			base.editTruckdriverById(iddeal, driver);
			base.editOtherinformationOfDealById(iddeal, otherinformation);
			base.editDateoftransportationOfDealById(iddeal, dateoftransportation);
   
            base.closeConnection();
            
            try {
				response.sendRedirect("/tender/deals/all");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "deals";
         
		
	}

}
