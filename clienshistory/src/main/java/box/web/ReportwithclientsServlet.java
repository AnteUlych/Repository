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

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Client;
import box.model.Product;
import box.model.Records;

@Controller
public class ReportwithclientsServlet {
	
	Constants constant = new Constants();
	String encoderforSplit = "&_";
	

    @RequestMapping(value = "/reportwithclients/{code}", method = RequestMethod.GET)
	public String doGet(@PathVariable("code") String code, ModelMap model, HttpServletRequest request) {
    	
    	 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		
		 DataBaseController base = new DataBaseController();
		 List<Product> products = base.getListOfOpenProducts();

		 String menuForHead = "";
		 		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			 base.closeConnection();
			 return "reportwithclients";
		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		 
		 
			String [] comand = code.split(encoderforSplit);
			String whatIshead = "";				
			DecoderDBtoHTML decoder = new DecoderDBtoHTML();
			
			if(comand[0].equals("p")){
				int productid = Integer.parseInt(comand[1]);
				String needProduct = base.getProductById(productid).getProduct();
				int funel = Integer.parseInt(comand[2]);
				List<Client> clients = base.getClientsByFunelAndOpenProduct(funel, needProduct);
				model.addAttribute("clients", clients);
				whatIshead = "Клієнти:";

				
				 List<String> dates = decoder.translateFotClientsDatesFromDBtoHTML(clients);
				 List<String> icons = decoder.translateForClientsFunelfromDBtoIcons(clients);
				 
				 model.addAttribute("dates", dates);
				 model.addAttribute("icons", icons);
			}
			
			if(comand[0].equals("m")){
				
				int managerid = Integer.parseInt(comand[1]);
				int recordsStatus = Integer.parseInt(comand[2]);
				String fromDate = comand[3];
				String toDate = comand[4];		
				List<Records> records = base.getListOfRecordsByManagerIdIdAndStatusBetweenDates(managerid, recordsStatus, fromDate, toDate);
				
				List<String> clientsForRecord = new ArrayList();
			
				for(Records r:records){
					Client c = base.getClientById(r.getClientid());
					clientsForRecord.add(c.getCompany());
					
				}
				
				model.addAttribute("records", records);
				whatIshead = "Записи:";
				 List<String> icons = decoder.translateForRecordsFunelfromDBtoIcons(records);
				 model.addAttribute("icons", icons);
				 model.addAttribute("clientsForRecord", clientsForRecord);

			}
		 
			base.closeConnection();
 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("whatIshead", whatIshead);
    	
    	return "reportwithclients";
    }

}
