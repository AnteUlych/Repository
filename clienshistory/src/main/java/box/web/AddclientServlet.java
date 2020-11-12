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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Client;
import box.model.Product;
import box.model.Records;

@Controller
@RequestMapping("/addclient")
public class AddclientServlet {
	
	Constants constant = new Constants();
	String RECORD_FOR_NEW_CLIENT = " л≥Їнт внесений в систему.";
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
		
		// int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String messagealert = "";
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		 base.closeConnection();
		 
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("messagealert", messagealert);
		 
		return "addclient";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String messagealert = "";
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		 
		 String edrpo = request.getParameter("edrpo");
	     boolean isClientAlreadyExist = base.isEDRPOExist(edrpo);
	     
	     if(isClientAlreadyExist){
	    	 messagealert =  "alert(\""+" л≥Їнт з ™ƒ–ѕќ” "+edrpo+" вже ≥снуЇ в систем≥!"+"\");";
	     }
		 
	//	 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 model.addAttribute("messagealert", messagealert);
		 
		 if(isClientAlreadyExist){
			 base.closeConnection();
			 return "addclient";
		 }else{
			 
		 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String company = request.getParameter("company");
			
			String lpr = request.getParameter("lpr");
			String phone = request.getParameter("phone");
			String mobile = request.getParameter("mobile");
			String mail = request.getParameter("mail");
			String othercontact = request.getParameter("othercontact");
			String freight = request.getParameter("freight");
			
			
			
			if (company != null){
				try {
					company = new String(company.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (lpr != null){
				try {
					lpr = new String(lpr.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (othercontact != null){
				try {
					othercontact = new String(othercontact.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (freight != null){
				try {
					freight = new String(freight.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (phone != null){
				try {
					phone = new String(phone.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (mobile != null){
				try {
					mobile = new String(mobile.getBytes(requestEnc), clientEnc);
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

			Client client = new Client();
			
			client.setCompany(company);
			client.setCreation(new Date());
			client.setEdrpo(edrpo);
			client.setFreight(freight);
			client.setFunel(0);
			client.setLastrecord(RECORD_FOR_NEW_CLIENT);
			client.setLpr(lpr);
			client.setMail(mail);
			client.setManager(name);
			client.setMobile(mobile);
			client.setManagerid(id);
			client.setNextcall(new Date());
			client.setOthercontact(othercontact);
			client.setPhone(phone);
			client.setProducts(productsForClient);
			
			base.addClient(client);
			
            base.closeConnection();
           
            DataBaseController base1 = new DataBaseController();
            
            Client client1 = base1.getClientByERDPO(edrpo);
            Records records = new Records();
            
            records.setClientid(client1.getId());
            records.setDate(new Date());
            records.setManager(name);
            records.setRecord(RECORD_FOR_NEW_CLIENT);
            records.setRecordstatus(constant.RECORDS_RECORDSTATUS_NEW_RECORD);
            records.setManagerid(id);
            
            base1.addRecords(records);
            
            base1.closeConnection();
            
            
			try {
				response.sendRedirect("/clientshisory/client/"+client1.getId());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		 }
		return "addclient";
	}

}
