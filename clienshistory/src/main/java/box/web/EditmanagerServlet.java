package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Client;
import box.model.Manager;
import box.model.Product;

@Controller
public class EditmanagerServlet {
	
	Constants constant = new Constants();
	

    @RequestMapping(value = "/editmanager/{managerid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("managerid") String managerid, ModelMap model, HttpServletRequest request) {
    	
    	 HttpSession session = request.getSession();
 		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 if(rank != constant.MANAGER_RANK_MANAGER){
		
		 DataBaseController base = new DataBaseController();
		 
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
	
			 menuForHead = constant.MENU_FOR_HEAD;
		 }

		 int idOfManager = Integer.parseInt(managerid);
		 Manager manager = base.getManagerById(idOfManager);
		 
		 String managerName = manager.getName();
		 String managerCode = manager.getCode();
		 int managerRank = manager.getRank();
		 String managerMail = manager.getMail();
		
		 List<Product> products = base.getListOfOpenProducts();
		
		 String radio0 = "";
		 String radio1 = "";
		
		 
		 if(managerRank==constant.MANAGER_RANK_MANAGER){
			 radio0 = "checked";
		 }
		 if(managerRank==constant.MANAGER_RANK_HEAD){
			 radio1 = "checked";
		 }
	
		 
		 String daleteButton = "";
		 String editbutton = "<button type=\"submit\" class=\"w3-button w3-round-xxlarge w3-green w3-third\" name=\"edit\" value=\"edit\">Змінити інформацію</button>";
		 
		 if(base.getNumberOfClientsByManagerid(idOfManager)==0){
			 daleteButton = "<button type=\"submit\" formnovalidate class=\"w3-button w3-red w3-round-xxlarge w3-third\" name=\"delete\" value=\"delete\">Видалити менеджера</button>";
		 }else{
			 daleteButton = "<button type=\"submit\" formnovalidate class=\"w3-button w3-red w3-round-xxlarge w3-third\" name=\"fired\" value=\"fired\">Звільнити менеджера</button>";
		 }
		 
		 String editCode = "<button type=\"submit\" class=\"w3-button w3-yellow w3-round-xxlarge w3-third\" name=\"editcode\" value=\"editcode\">Змінити пароль</button>";
	 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("managerName", managerName);
		 model.addAttribute("managerCode", managerCode);
		 model.addAttribute("managerMail", managerMail);
		 
		 model.addAttribute("radio0", radio0);
		 model.addAttribute("radio1", radio1);

		 
		 model.addAttribute("daleteButton", daleteButton);
		 model.addAttribute("editbutton", editbutton);
		 model.addAttribute("editCode", editCode);
		 
		 }
		 
    	return "editmanager";
    }
    
    @RequestMapping(value = "/editmanager/{managerid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("managerid") String managerid, ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
    	
    	 HttpSession session = request.getSession();
  		
 		 int id = (Integer) session.getAttribute("id");
 		 int rank = (Integer) session.getAttribute("rank");
 		 String name = (String) session.getAttribute("name");
 		 		
 		 DataBaseController base = new DataBaseController();
 		 
 		 String menuForHead = "";
 		 
 		 if(rank == constant.MANAGER_RANK_MANAGER){

 		 }else{
 	
 			 menuForHead = constant.MENU_FOR_HEAD;
 		 }

 		 int idOfManager = Integer.parseInt(managerid);
 		 Manager manager = base.getManagerById(idOfManager);
 		 
 		 String managerName = manager.getName();
 		 String managerCode = manager.getCode();
 		 int managerRank = manager.getRank();
 		 String managerMail = manager.getMail();
 		
 		 List<Product> products = base.getListOfOpenProducts();
 		
 		 String radio0 = "";
 		 String radio1 = "";
 		
 		 
 		 if(managerRank==constant.MANAGER_RANK_MANAGER){
 			 radio0 = "checked";
 		 }
 		 if(managerRank==constant.MANAGER_RANK_HEAD){
 			 radio1 = "checked";
 		 }
 	
 		 
 		 String daleteButton = "";
 		 String editbutton = "<button type=\"submit\" class=\"w3-button w3-round-xxlarge w3-green w3-third\" name=\"edit\" value=\"edit\">Змінити інформацію</button>";
 		 
 		 if(base.getNumberOfClientsByManagerid(idOfManager)==0){
 			 daleteButton = "<button type=\"submit\" class=\"w3-button w3-red w3-round-xxlarge w3-third\" name=\"delete\" value=\"delete\">Видалити менеджера</button>";
 		 }else{
 			 daleteButton = "<button type=\"submit\" class=\"w3-button w3-red w3-round-xxlarge w3-third\" name=\"fired\" value=\"fired\">Звільнити менеджера</button>";
 		 }
 		 
 		 String editCode = "<button type=\"submit\" class=\"w3-button w3-yellow w3-round-xxlarge w3-third\" name=\"editcode\" value=\"editcode\">Змінити пароль</button>";
 		 	 
 		 model.addAttribute("name", name);
 		 model.addAttribute("products", products);
 		 model.addAttribute("menuForHead", menuForHead);
 		 
 		 model.addAttribute("managerName", managerName);
 		 model.addAttribute("managerCode", managerCode);
 		 model.addAttribute("managerMail", managerMail);
 		 
 		 model.addAttribute("radio0", radio0);
 		 model.addAttribute("radio1", radio1);

 		 
 		 model.addAttribute("daleteButton", daleteButton);
 		 model.addAttribute("editbutton", editbutton);
 		 model.addAttribute("editCode", editCode);

 		 
 		if (request.getParameter("edit") != null) {
 			
 			 String requestEnc = "ISO-8859-1";
 			String clientEnc = request.getParameter("charset");
 			if (clientEnc == null)
 				clientEnc = "Cp1251";
 			
 			String nameNew = request.getParameter("nameOfManager");
 			String mailNew = request.getParameter("mail");
 			int newRank = Integer.parseInt(request.getParameter("rankManager"));
 			
 			if (nameNew != null){
				try {
					nameNew = new String(nameNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
 			
 			base.editManagerById(idOfManager, nameNew, mailNew, manager.getCode(), newRank);
 					
 		}
 		
        if (request.getParameter("delete") != null) {
 			base.deleteManager(idOfManager);
 		}
        
        if (request.getParameter("fired") != null) {
 			base.firedManagerById(idOfManager);
 		}
        
        if (request.getParameter("editcode") != null) {
        	String newCode = base.generateCodeForManager();
 			base.editManagerById(idOfManager, manager.getName(), manager.getMail(), newCode, manager.getRank());
 		}
 		 
 		 base.closeConnection();
 		 
 		 try {
				response.sendRedirect("/clientshisory/managers");
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
    	
    	 return "editmanager";
    }
    	
}
