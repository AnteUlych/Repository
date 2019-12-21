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
import box.model.Contract;
import box.model.Manager;


@Controller
@RequestMapping("/clientspropositions")
public class ClientsPropositionsServlet {
	
	String RANK_TOP = "top";
	String RANK_MANAGER = "manager";
	
	String BUTTON_BEFORE_ID = "<button class=\"w3-button\" onclick=\"document.getElementById('subscribe";
	String BUTTON_AFTER_ID = "').style.display='block'\"><i class=\"fa fa-cog\"></i></button>";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
        HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
		
		DataBaseController base = new DataBaseController();
		
		List<Contract> contracts = new ArrayList();
		List<String> lastdates = new ArrayList();
		List<String> colors = new ArrayList();
		List<Manager> managers = base.getListOfManagersByRank(RANK_MANAGER);
		List<String> editButtons = new ArrayList();
		
		if(rank.equals(RANK_TOP)){
			contracts = base.getListOfContracts();
		}else{
			contracts = base.getListOfContractsByManagerId(id);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date today = new Date();
		
		for(Contract contract:contracts){
			
			if(today.after(contract.getLastday())&&contract.getStatus().equals("on")){
				base.editContract(contract.getId(), contract.getCompany(), contract.getManagerid(), contract.getManager(), contract.getLastday(), "off");
			}
				
			String lastDayText = dateFormat.format(contract.getLastday());
			lastdates.add(lastDayText);
			
			if(contract.getStatus().equals("off")){
				colors.add("w3-pink");
			}else{
				colors.add("");
			}
			
			if(rank.equals(RANK_TOP)){
				editButtons.add(BUTTON_BEFORE_ID+contract.getId()+BUTTON_AFTER_ID);
			}else{
				editButtons.add("");
			}
			
		}
	
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("contracts", contracts);
		model.addAttribute("lastdates", lastdates);
		model.addAttribute("colors", colors);
		model.addAttribute("managers", managers);
		model.addAttribute("editButtons", editButtons);
		
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
		
		List<Contract> contracts = new ArrayList();
		List<String> lastdates = new ArrayList();
		List<String> colors = new ArrayList();
		List<Manager> managers = base.getListOfManagersByRank(RANK_MANAGER);
		List<String> editButtons = new ArrayList();
		
		if(rank.equals(RANK_TOP)){
			contracts = base.getListOfContracts();
		}else{
			contracts = base.getListOfContractsByManagerId(id);
		}
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		for(Contract contract:contracts){
				
			String lastDayText = dateFormat.format(contract.getLastday());
			lastdates.add(lastDayText);
			
			if(contract.getStatus().equals("off")){
				colors.add("w3-pink");
			}else{
				colors.add("");
			}
			
			if(rank.equals(RANK_TOP)){
				editButtons.add(BUTTON_BEFORE_ID+contract.getId()+BUTTON_AFTER_ID);
			}else{
				editButtons.add("");
			}
			
		}
	
		
		model.addAttribute("name", name);
		model.addAttribute("contracts", contracts);
		model.addAttribute("lastdates", lastdates);
		model.addAttribute("colors", colors);
		model.addAttribute("managers", managers);
		model.addAttribute("editButtons", editButtons);
		
		//post start here
		
             if(request.getParameter("add") != null){
			 
			 String newclient = request.getParameter("newclient");
						
			 String requestEnc = "ISO-8859-1";
			 String clientEnc = request.getParameter("charset");
			 
				if (clientEnc == null)
					clientEnc = "Cp1251";
				
				if (newclient != null){
					try {
						newclient = new String(newclient.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			Contract contract = new Contract();
			
			contract.setCompany(newclient);
			contract.setCreating(new Date());
			contract.setLastday(new Date());
			contract.setManager(name);
			contract.setManagerid(id);
		    contract.setStatus("off");
		    
		    base.addContract(contract);
		    
		    base.closeConnection();
			
			try {
				response.sendRedirect("/tender/clientspropositions");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "clientspropositions";
			
		 }
             
             for(Contract c:contracts){
    			 
    			 if(request.getParameter("edit"+c.getId()) != null){
    				 
    				 String company = request.getParameter("comp"+c.getId());
    				 String lastday = request.getParameter("lastdate"+c.getId());
    				 String managerid = request.getParameter("manager"+c.getId());
    				 String status = request.getParameter("status"+c.getId());
    					
    					String requestEnc = "ISO-8859-1";
    					String clientEnc = request.getParameter("charset");
    					if (clientEnc == null)
    						clientEnc = "Cp1251";
    					
    					if (company != null){
    						try {
    							company = new String(company.getBytes(requestEnc), clientEnc);
    						} catch (UnsupportedEncodingException e) {
    							e.printStackTrace();
    						}
    					}
    					
    					DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //changed bug of mounth
    					Date lastd = null;

    					try {
    						lastd = format.parse(lastday);
    					} catch (ParseException e) {
    						e.printStackTrace();
    					}
    					
    					int managid = Integer.parseInt(managerid);
    				    Manager managerfrombase = base.getManagerById(managid);   					
    					base.editContract(c.getId(), company, managid, managerfrombase.getName(), lastd, status);
    					
    					base.closeConnection();
    					
    					try {
    						response.sendRedirect("/tender/clientspropositions");
    					} catch (IOException e) {
    						e.printStackTrace();
    					}
    					
    					return "clientspropositions";
    				 
    			 }
    			 
    		
    			 
    		 }
		
		return "clientspropositions";
	}

}
