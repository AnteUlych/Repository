package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
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
import box.model.Auction;
import box.model.Bet;
import box.model.Deal;
import box.model.Message;
import box.model.Proposition;
import box.model.Sold;

@Controller
@RequestMapping("/clientspropositions")
public class ClientsPropositionsServlet {
	
	String STATUS_OPEN = "open";
	String STATUS_CONFIRMED = "confirmed";
	
	String FIRST_PART_DELETE_BUTTON = "<button type=\"submit\" formnovalidate class=\"w3-button w3-red\" name=\"delete";
	String SECOND_PART_DELETE_BUTTON = "\" value=\"delete";
	String THIRD_PART_DELETE_BUTTON = "\" ><i class=\"fa fa-close\"></button>";
	
	String FIRST_PART_CONFIRM_BUTTON = "<button type=\"submit\" formnovalidate class=\"w3-button w3-green\" name=\"confirm";
	String SECOND_PART_CONFIRM_BUTTON = "\" value=\"confirm";
	String THIRD_PART_CONFIRM_BUTTON = "\" ><i class=\"fa fa-check\"></button>";
	
	String FIRST_PART_CONFIRM2_BUTTON = "<button type=\"submit\" formnovalidate class=\"w3-button w3-yellow\" name=\"confirm2";
	String SECOND_PART_CONFIRM2_BUTTON = "\" value=\"confirm2";
	String THIRD_PART_CONFIRM2_BUTTON = "\" ><i class=\"fa fa-check\"></i></button>";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
        HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController();
		
		List <Proposition> exportPropositions = base.getListOfPropositionsByDirection("export");
		List <Proposition> importPropositions  = base.getListOfPropositionsByDirection("import");
		List <String> exportButtonDelete = new ArrayList();
		List <String> importButtonDelete  = new ArrayList();
		List <String> exportButtonConfirm = new ArrayList();
		List <String> importButtonConfirm  = new ArrayList();
		List <String> exportDate= new ArrayList();
		List <String> importDate = new ArrayList();
		List <String> exportColor= new ArrayList();
		List <String> importColor = new ArrayList();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
		
		for(Proposition proposition:exportPropositions){
			if(id==proposition.getManagerid()||rank.equals("coordinator")){
				exportButtonDelete.add(FIRST_PART_DELETE_BUTTON+proposition.getId()+SECOND_PART_DELETE_BUTTON+proposition.getId()+THIRD_PART_DELETE_BUTTON);
			}else{
				exportButtonDelete.add("");
			}
			
			String buttonConf = "";
			
			if(rank.equals("coordinator")&&(proposition.getStatus().equals(STATUS_OPEN))){
				buttonConf = FIRST_PART_CONFIRM_BUTTON+proposition.getId()+SECOND_PART_CONFIRM_BUTTON+proposition.getId()+THIRD_PART_CONFIRM_BUTTON;
			}
				
			if((id==proposition.getManagerid()&&(proposition.getStatus().equals(STATUS_CONFIRMED)))){
			    buttonConf = FIRST_PART_CONFIRM2_BUTTON+proposition.getId()+SECOND_PART_CONFIRM2_BUTTON+proposition.getId()+THIRD_PART_CONFIRM2_BUTTON;
			}
			
			if(proposition.getStatus().equals(STATUS_CONFIRMED)){
				exportColor.add("w3-green");
			}else{
				exportColor.add("");
			}
				
			exportButtonConfirm.add(buttonConf);
			exportDate.add(formatter.format(proposition.getReadiness()));
			
		}
		
		for(Proposition proposition:importPropositions){
			if(id==proposition.getManagerid()||rank.equals("coordinator")){
				importButtonDelete.add(FIRST_PART_DELETE_BUTTON+proposition.getId()+SECOND_PART_DELETE_BUTTON+proposition.getId()+THIRD_PART_DELETE_BUTTON);
			}else{
				importButtonDelete.add("");
			}
			
			String buttonConf = "";
			
			if(rank.equals("coordinator")&&(proposition.getStatus().equals(STATUS_OPEN))){
				buttonConf = FIRST_PART_CONFIRM_BUTTON+proposition.getId()+SECOND_PART_CONFIRM_BUTTON+proposition.getId()+THIRD_PART_CONFIRM_BUTTON;
			}
				
			if((id==proposition.getManagerid()&&(proposition.getStatus().equals(STATUS_CONFIRMED)))){
			    buttonConf = FIRST_PART_CONFIRM2_BUTTON+proposition.getId()+SECOND_PART_CONFIRM2_BUTTON+proposition.getId()+THIRD_PART_CONFIRM2_BUTTON;
			}
			
			if(proposition.getStatus().equals(STATUS_CONFIRMED)){
				importColor.add("w3-green");
			}else{
				importColor.add("");
			}
				
			importButtonConfirm.add(buttonConf);
			importDate.add(formatter.format(proposition.getReadiness()));
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("exportPropositions", exportPropositions);
		model.addAttribute("importPropositions", importPropositions);
		model.addAttribute("exportButtonDelete", exportButtonDelete);
		model.addAttribute("importButtonDelete", importButtonDelete);
		model.addAttribute("exportButtonConfirm", exportButtonConfirm);
		model.addAttribute("importButtonConfirm", importButtonConfirm);
		model.addAttribute("exportDate", exportDate);
		model.addAttribute("importDate", importDate);
		model.addAttribute("exportColor", exportColor);
		model.addAttribute("importColor", importColor);
		
		return "clientspropositions";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController();
		
		List <Proposition> exportPropositions = base.getListOfPropositionsByDirection("export");
		List <Proposition> importPropositions  = base.getListOfPropositionsByDirection("import");
		List <String> exportButtonDelete = new ArrayList();
		List <String> importButtonDelete  = new ArrayList();
		List <String> exportButtonConfirm = new ArrayList();
		List <String> importButtonConfirm  = new ArrayList();
		List <String> exportDate= new ArrayList();
		List <String> importDate = new ArrayList();
		List <String> exportColor= new ArrayList();
		List <String> importColor = new ArrayList();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM");
		
		for(Proposition proposition:exportPropositions){
			if(id==proposition.getManagerid()||rank.equals("coordinator")){
				exportButtonDelete.add(FIRST_PART_DELETE_BUTTON+proposition.getId()+SECOND_PART_DELETE_BUTTON+proposition.getId()+THIRD_PART_DELETE_BUTTON);
			}else{
				exportButtonDelete.add("");
			}
			
			String buttonConf = "";
			
			if(rank.equals("coordinator")&&(proposition.getStatus().equals(STATUS_OPEN))){
				buttonConf = FIRST_PART_CONFIRM_BUTTON+proposition.getId()+SECOND_PART_CONFIRM_BUTTON+proposition.getId()+THIRD_PART_CONFIRM_BUTTON;
			}
				
			if((id==proposition.getManagerid()&&(proposition.getStatus().equals(STATUS_CONFIRMED)))){
			    buttonConf = FIRST_PART_CONFIRM2_BUTTON+proposition.getId()+SECOND_PART_CONFIRM2_BUTTON+proposition.getId()+THIRD_PART_CONFIRM2_BUTTON;
			}
			
			if(proposition.getStatus().equals(STATUS_CONFIRMED)){
				exportColor.add("w3-green");
			}else{
				exportColor.add("");
			}
				
			exportButtonConfirm.add(buttonConf);
			exportDate.add(formatter.format(proposition.getReadiness()));
			
		}
		
		for(Proposition proposition:importPropositions){
			if(id==proposition.getManagerid()||rank.equals("coordinator")){
				importButtonDelete.add(FIRST_PART_DELETE_BUTTON+proposition.getId()+SECOND_PART_DELETE_BUTTON+proposition.getId()+THIRD_PART_DELETE_BUTTON);
			}else{
				importButtonDelete.add("");
			}
			
			String buttonConf = "";
			
			if(rank.equals("coordinator")&&(proposition.getStatus().equals(STATUS_OPEN))){
				buttonConf = FIRST_PART_CONFIRM_BUTTON+proposition.getId()+SECOND_PART_CONFIRM_BUTTON+proposition.getId()+THIRD_PART_CONFIRM_BUTTON;
			}
				
			if((id==proposition.getManagerid()&&(proposition.getStatus().equals(STATUS_CONFIRMED)))){
			    buttonConf = FIRST_PART_CONFIRM2_BUTTON+proposition.getId()+SECOND_PART_CONFIRM2_BUTTON+proposition.getId()+THIRD_PART_CONFIRM2_BUTTON;
			}
			
			if(proposition.getStatus().equals(STATUS_CONFIRMED)){
				importColor.add("w3-green");
			}else{
				importColor.add("");
			}
				
			importButtonConfirm.add(buttonConf);
			importDate.add(formatter.format(proposition.getReadiness()));
		}
		
		
		
		model.addAttribute("name", name);
		
		model.addAttribute("exportPropositions", exportPropositions);
		model.addAttribute("importPropositions", importPropositions);
		model.addAttribute("exportButtonDelete", exportButtonDelete);
		model.addAttribute("importButtonDelete", importButtonDelete);
		model.addAttribute("exportButtonConfirm", exportButtonConfirm);
		model.addAttribute("importButtonConfirm", importButtonConfirm);
		model.addAttribute("exportDate", exportDate);
		model.addAttribute("importDate", importDate);
		model.addAttribute("exportColor", exportColor);
		model.addAttribute("importColor", importColor);
		
		//Post starts here
		
		List <Proposition> propositions = new ArrayList();
		propositions.addAll(exportPropositions);
		propositions.addAll(importPropositions);
		
		 for (Proposition proposition : propositions) {

				if (request.getParameter("delete" + proposition.getId()) != null) {
		
					base.deleteProposition(proposition.getId());
					base.closeConnection();
									
					
					try {
						response.sendRedirect("/tender/clientspropositions");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
					return "clientspropositions";
					
				}

				if (request.getParameter("confirm" + proposition.getId()) != null) {
										
					base.editStatusOfProposition(proposition.getId(), "confirmed");

					//message
					
					Date nowDate = new Date();
					DateFormat dateFormat = new SimpleDateFormat("hh:mm");  
					String messagedate = dateFormat.format(nowDate);  
					
					String textmessage = messagedate+" Вашу пропозицію "+proposition.getRoute()+" для "+proposition.getInformation()+" підтвердив координатор, підтвердіть фінально.";
					Message message = new Message();
					message.setRecipientid(proposition.getManagerid());
					message.setText(textmessage);
					base.addMessage(message);
					
					//message
				 		
					base.closeConnection();

					try {
						response.sendRedirect("/tender/clientspropositions");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return "clientspropositions";
				}
				
				if (request.getParameter("confirm2" + proposition.getId()) != null) {
					
					Deal deal = new Deal();

					deal.setDate(new Date());
					deal.setDateoftransportation(proposition.getReadiness());
					deal.setDirection(proposition.getDirection());
					deal.setInformation(proposition.getRoute());
					deal.setManager(proposition.getManager());
					deal.setManagerid(proposition.getManagerid());
					deal.setRoute(proposition.getRoute());
					deal.setSoldid(0);
					deal.setStatus("deal_waiting");
					deal.setTruck(proposition.getTruck());
					deal.setTruckdriver("");
					deal.setBetid(0);
					deal.setOtherinformation("");
					
					//change with adding chiefs table
					deal.setChiefid(0);
					deal.setChiefname("");
					//change

					base.addDeal(deal);
					
					base.deleteProposition(proposition.getId());
		 		
					base.closeConnection();
					
					try {
						response.sendRedirect("/tender/clientspropositions");
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					return "clientspropositions";
				}

			}
		
		 if (request.getParameter("addproposition") != null) {
			 
			 String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
				
			 
			 String direction = request.getParameter("direction");
			 String readydate = request.getParameter("readydate");
			 String route = request.getParameter("route");
			 String client = request.getParameter("client");
			 String rate = request.getParameter("rate");
			 String currency = request.getParameter("currency");
			 String truck = request.getParameter("truck");

			 DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //changed bug of mounth
			 Date dateoftransportation = null;

				try {
					dateoftransportation = format.parse(readydate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			 
			 int price = Integer.parseInt(rate);
			 
			 if (route != null){
					try {
						route = new String(route.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				if (client != null){
					try {
						client = new String(client.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				if (truck != null){
					try {
						truck = new String(truck.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				
				Proposition proposition = new Proposition();
				
				proposition.setCurrency(currency);
				proposition.setDate(new Date());
				proposition.setDirection(direction);
				proposition.setInformation(client);
				proposition.setManager(name);
				proposition.setManagerid(id);
				proposition.setRate(price);
				proposition.setReadiness(dateoftransportation);
				proposition.setRoute(route);
				proposition.setStatus(STATUS_OPEN);
				proposition.setTruck(truck);
				
			    base.addProposition(proposition);	
			 
		 }
		 
		base.closeConnection();
		
		try {
			response.sendRedirect("/tender/clientspropositions");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "clientspropositions";
	}

}
