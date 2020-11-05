package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Client;
import box.model.Manager;
import box.model.Product;
import box.model.Records;

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
		 String button = "";
		 
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
			 button = "<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Редагувати клієнта</button>";
		 
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
		 model.addAttribute("button", button);
		 
		 return "editclient";
	}
	
	@RequestMapping(value = "/editclient/{clientid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
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
		 String button = "";
		 
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
			 button = "<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Редагувати клієнта</button>";
			 		
		 
		 }
		 
		 List<String> productChecks = new ArrayList();
		 for(Product pro:products){
			 if(prods.contains(pro.getProduct())){
				 productChecks.add("checked");
			 }else{
				 productChecks.add("");
			 }
		 }
		 
		 
		 
		 
		 
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
		 model.addAttribute("button", button);
		 
		 //get informtion for post
		 

		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String companyNew = request.getParameter("company");
			
			String lprNew = request.getParameter("lpr");
			String phoneNew = request.getParameter("phone");
			String mobileNew = request.getParameter("mobile");
			String mailNew = request.getParameter("mail");
			String othercontactNew = request.getParameter("othercontact");
			String freightNew = request.getParameter("freight");
			
			
			
			if (companyNew != null){
				try {
					companyNew = new String(companyNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (lprNew != null){
				try {
					lprNew = new String(lprNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (othercontactNew != null){
				try {
					othercontactNew = new String(othercontactNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (freightNew != null){
				try {
					freightNew = new String(freightNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (phoneNew != null){
				try {
					phoneNew = new String(phoneNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (mobileNew != null){
				try {
					mobileNew = new String(mobileNew.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			String productsForClient = "";
			
			for(Product product:products){
				String check = request.getParameter(product.getId()+"");
				if(check != null){
				int checkid = Integer.parseInt(check);
				
				if(checkid==product.getId()){
					productsForClient = productsForClient.concat(product.getProduct());
					productsForClient = productsForClient.concat(" ");			
				}
				}
			}
			
			
			String responsiblemanager = request.getParameter("responsiblemanager");
			int newManagerId = client.getManagerid();
			String newManager = client.getManager();
			if(responsiblemanager != null){
				newManagerId = Integer.parseInt(responsiblemanager);
				Manager newOneManager = base.getManagerById(newManagerId);
				newManager = newOneManager.getName();
			}
			
		 base.editClientById(idOfClient, client.getFunel(), companyNew, client.getEdrpo(), freightNew, lprNew, mailNew, newManager, newManagerId, mobileNew, othercontactNew, phoneNew, productsForClient);

		 String newRecord = name + " змінив ";
		 
		 if(!company.equals(companyNew)){
			 newRecord = newRecord + " назву " + company + " на " + companyNew + "; ";
		 }
		 
		 if(!freight.equals(freightNew)){
			 newRecord = newRecord + " вантаж " + freight + " на " + freightNew + "; ";
		 }
		 if(!mail.equals(mailNew)){
			 newRecord = newRecord + " поштову адресу " + mail + " на " + mailNew + "; ";
		 }
		 if(!mobile.equals(mobileNew)){
			 newRecord = newRecord + " мобільний телефон " + mobile + " на " + mobileNew + "; ";
		 }
		 if(!phone.equals(phoneNew)){
			 newRecord = newRecord + " телефон " + phone + " на " + phoneNew + "; ";
		 }
		 if(!othercontact.equals(othercontactNew)){
			 newRecord = newRecord + " контакти " + othercontact + " на " + othercontactNew + "; ";
		 }
		 if(!lpr.equals(lprNew)){
			 newRecord = newRecord  + " ЛПР " + lpr + " на " + lprNew + "; ";
		 }
		 if(!prods.equals(productsForClient)){
			 newRecord = newRecord + " продукти " + prods + " на " + productsForClient + "; ";
		 }
		 if(responsiblemanager != null){
			 newRecord = newRecord + " відповідального " + manager + " на " + newManager + "; ";
		 }
		 
		 Records record = new Records();
		 
		 record.setClientid(idOfClient);
		 record.setDate(new Date());
		 record.setFunel(client.getFunel());
		 record.setManager(name);
		 record.setManagerid(id);
		 record.setRecord(newRecord);
		 record.setRecordstatus(constant.RECORDS_RECORDSTATUS_ADD_CHANGINGS);

		 base.addRecords(record);
    	 base.closeConnection();
    	 
    	 try {
				response.sendRedirect("/clientshisory/client/"+clientid);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return "client";
	}

}
