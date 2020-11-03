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
import box.model.Client;
import box.model.Manager;
import box.model.Product;

@Controller
public class EditclientServlet {
	
	Constants constant = new Constants();
	String RECORD_FOR_NEW_CLIENT = "Клієнт внесений в систему.";
	
	@RequestMapping(value = "/editclient/{clientid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("clientid") String clientid, ModelMap model, HttpServletRequest request) {
		
         HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 int idOfClient = Integer.parseInt(clientid);
		
		 DataBaseController base = new DataBaseController();
		 
		 String messagealert = "";
		 String menuForHead = "";
		 
		 List<String> managerChecks = new ArrayList();
		 List<Manager> managers = new ArrayList();
		
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		 Client client = base.getClientById(idOfClient);
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
             
			 managers = base.getListOfNotAdminManagers();
			 
			 for(Manager ma:managers){
				 if(ma.getName().equals(client.getManager())){
					 managerChecks.add("checked");
				 }else{
					 managerChecks.add("");
				 }
			 }
			 
			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		 
		 String hidden = "hidden";
		 
		 String company = client.getCompany();

		 String freight = client.getFreight();
		 String mail = client.getMail();
		 String mobile = client.getMobile();
		 String othercontact = client.getOthercontact();
		 String phone = client.getPhone();
		 String lpr = client.getLpr();
		 String prods = client.getProducts();
		 String manager = client.getManager();
		 
		 		 		 
		 if((rank != constant.MANAGER_RANK_MANAGER)||(client.getManagerid()==id)){
			 
			 hidden = "";
			 //button
		 
		 }
		 
		 List<String> productChecks = new ArrayList();
		 for(Product pro:products){
			 if(prods.contains(pro.getProduct())){
				 productChecks.add("checked");
			 }else{
				 productChecks.add("");
			 }
		 }
		 
		 
		 base.closeConnection();
		 
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("messagealert", messagealert);
		 
		 model.addAttribute("company", company);

		 model.addAttribute("freight", freight);
		 model.addAttribute("mail", mail);
		 model.addAttribute("mobile", mobile);
		 model.addAttribute("othercontact", othercontact);
		 model.addAttribute("phone", phone);
		 model.addAttribute("lpr", lpr);
		 
		 model.addAttribute("manager", manager);
		 
		 model.addAttribute("productChecks", productChecks);
		 model.addAttribute("managerChecks", managerChecks);
		 
		 model.addAttribute("managers", managers);
		
		 model.addAttribute("hidden", hidden);
		 
		 return "editclient";
	}

}
