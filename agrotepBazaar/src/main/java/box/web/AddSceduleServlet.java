package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.logic.DecoderDbToHtml;
import box.model.Contract;
import box.model.Deal;
import box.model.Manager;
import box.model.Message;

@Controller
public class AddSceduleServlet {
	
	@RequestMapping(value = "/contract/{contractid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("contractid") String contractid,
			ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String addButton = "";
		 
		 DataBaseController base = new DataBaseController();
         int idcontract = Integer.parseInt(contractid);	
         
         Contract contract = base.getContractById(idcontract); 
         
         if(contract.getManagerid()==id&&contract.getStatus().equals("on")){
        	 addButton = "<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Додати відвантажння</button>";
         }
         
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
         String strToday = dateFormat.format(new Date()); 
         
         List<Deal> deals = base.getListOfTodayDealsByManagerId(strToday, id);
         
         DecoderDbToHtml html = new DecoderDbToHtml();
         List<String> dates = html.getDatesForHtmlDatesofDealsFromContract(deals);
		 
         base.closeConnection();
         
         model.addAttribute("name", name);
         model.addAttribute("addButton", addButton);
         
         model.addAttribute("deals", deals);
         
         model.addAttribute("dates", dates);
         model.addAttribute("contract", contract);
		
		 return "addschedule";
		
	}
	@RequestMapping(value = "/contract/{contractid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("contractid") String contractid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String addButton = "";
		 
		 DataBaseController base = new DataBaseController();
         int idcontract = Integer.parseInt(contractid);	
         
         Contract contract = base.getContractById(idcontract); 
         
         if(contract.getManagerid()==id&&contract.getStatus().equals("on")){
        	 addButton = "<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Додати відвантажння</button>";
         }
         
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
         String strToday = dateFormat.format(new Date()); 
         
         List<Deal> deals = base.getListOfTodayDealsByManagerId(strToday, id);
         
         DecoderDbToHtml html = new DecoderDbToHtml();
         List<String> dates = html.getDatesForHtmlDatesofDealsFromContract(deals);
		 
         model.addAttribute("name", name);
         model.addAttribute("addButton", addButton);
         
         model.addAttribute("deals", deals);
         model.addAttribute("dates", dates);
         model.addAttribute("contract", contract);
         
         //post
         
            String stringDate = request.getParameter("readiness");
			String truck = request.getParameter("truck");
			
			String information = request.getParameter("information");
			String direction = request.getParameter("direction");
			
			String num = request.getParameter("num");
			int number = Integer.parseInt(num);
			
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			if (truck != null){
				try {
					truck = new String(truck.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (information != null){
				try {
					information = new String(information.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			

			DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
			Date dateoftransportation = null;

			try {
				dateoftransportation = format.parse(stringDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Deal deal = new Deal();
			
			deal.setBetid(0);
			deal.setChiefid(0);
			deal.setChiefname("");
			deal.setDate(new Date());
			deal.setDateoftransportation(dateoftransportation);
			deal.setDirection(direction);
			deal.setInformation(information+" "+contract.getCompany());
			deal.setManager(name);
			deal.setManagerid(id);
			deal.setOtherinformation("");
			deal.setRoute(information);
			deal.setSoldid(0);
			deal.setStatus("deal_waiting");
			deal.setTruck(truck);
			deal.setTruckdriver("");
			

			for(int i=0; i<number; i++){
				base.addDeal(deal);
			}
			
			List<Manager> managers = base.getListOfManagers();
			
			for(Manager manager:managers){
				if(manager.getRank().equals("coordinator")){
					 
					//message
					Date nowDate = new Date();
					DateFormat dateFormat1 = new SimpleDateFormat("hh:mm");  
					String messagedate = dateFormat1.format(nowDate); 
					
					String textmessage = messagedate+" "+name+" розмістив "+number+" відвантажень "+information+".";
					Message message = new Message();
					message.setRecipientid(manager.getId());
					message.setText(textmessage);
					base.addMessage(message);
					//message
					
				}
			}
         
            base.closeConnection();
			
			try {
				response.sendRedirect("/tender/contract/"+idcontract);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return "addschedule";
	}

}
