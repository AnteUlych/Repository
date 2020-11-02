package box.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class ClientServlet {

	Constants constant = new Constants();
	String rejected = "доступ закритий";
	
    @RequestMapping(value = "/client/{clientid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("clientid") String clientid, ModelMap model, HttpServletRequest request) {
    	
         HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String addRecord = "";
		 String editClient = "";
         String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		 
		 List<Product> products = base.getListOfOpenProducts();
		 
		 int idOfClient = Integer.parseInt(clientid);
		 
		 Client client = base.getClientById(idOfClient);
		 
		 int responsibleManager = client.getManagerid();
		 String company = client.getCompany();
		 String freight = client.getFreight();
		 String productsOfClient = client.getProducts();
		 String manager = client.getManager();
		 String edrpo = client.getEdrpo();
		 
		 int funel = client.getFunel();	 
		 DecoderDBtoHTML decoder = new DecoderDBtoHTML();
		 String funelIcon = decoder.translateForClientsFunelfromIntegerToIcons(funel);
		 
		 Date creation = client.getCreation();
		 
		 String pattern = "dd/MM/yyyy";
		 DateFormat df = new SimpleDateFormat(pattern);      
		 String creationAsString = df.format(creation);
		 
		 String lpr = rejected;
		 String phone = rejected;
		 String  mobile = rejected;
		 String mail = rejected;
		 String othercontact = rejected;
		 
		 List<Records> records = new ArrayList();
		 
		 if((id==responsibleManager)||(rank!=constant.MANAGER_RANK_MANAGER)){
			 lpr = client.getLpr();
			 phone = client.getPhone();
			 mobile = client.getMobile();
			 mail = client.getMail();
			 othercontact = client.getOthercontact();
			 
			 records = base.getListOfRecordsByClientId(idOfClient);
			 
			 addRecord = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-comments-o\"> </i></button>";
			 editClient =  "<a href=\"/clientshisory/editclient/"+clientid+" class=\"w3-button\"><i class=\"fa fa-edit\"></i></a>";
		 }
		 
		 List<String> icons = decoder.translateForRecordsFunelfromDBtoIcons(records);
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("edrpo", edrpo);
		 model.addAttribute("company", company);
		 model.addAttribute("freight", freight);
		 model.addAttribute("productsOfClient", productsOfClient);
		 model.addAttribute("manager", manager);
		 model.addAttribute("funelIcon", funelIcon);
		 model.addAttribute("creationAsString", creationAsString);
		 model.addAttribute("lpr", lpr);
		 model.addAttribute("phone", phone);
		 model.addAttribute("mobile", mobile);
		 model.addAttribute("mail", mail);
		 model.addAttribute("othercontact", othercontact);
		 model.addAttribute("records", records);
		 
		 model.addAttribute("addRecord", addRecord);
		 
		 model.addAttribute("icons", icons);
		 
		 model.addAttribute("clientid", clientid);
		 model.addAttribute("editClient", editClient);
		    	
    	 return "client";
    }
}
