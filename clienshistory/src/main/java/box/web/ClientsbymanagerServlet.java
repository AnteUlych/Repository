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

@Controller
public class ClientsbymanagerServlet {
	
	Constants constant = new Constants();
	
    @RequestMapping(value = "/clientsbymanager/{idofmanager}", method = RequestMethod.GET)
	public String doGet(@PathVariable("idofmanager") String idofmanager, ModelMap model, HttpServletRequest request) {
    	
    	 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 List<Client> clients = new ArrayList();
		 String menuForHead = "";
		 
		 String nameOfManager = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			
		 }else{
			 int managerid = Integer.parseInt(idofmanager);
			 clients = base.getClientsByManagerIdSortedByNexcall(managerid);
			 menuForHead = constant.MENU_FOR_HEAD;
			 
			 nameOfManager = base.getManagerById(managerid).getName();
		 }
		 
		 DecoderDBtoHTML decoder = new DecoderDBtoHTML();
			
		 List<Product> products = base.getListOfOpenProducts();
		 List<String> dates = decoder.translateFotClientsDatesFromDBtoHTML(clients);
		 List<String> icons = decoder.translateForClientsFunelfromDBtoIcons(clients);
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("clients", clients);
		 model.addAttribute("products", products);
		 model.addAttribute("dates", dates);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("icons", icons);
		 
		 model.addAttribute("nameOfManager", nameOfManager);
	
    	 return "clientsbymanager";
    }

}
