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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.DecoderDBtoHTML;
import box.model.Calculates;
import box.model.Client;
import box.model.Product;
import box.model.Records;
import box.model.Weeklyreminder;

@Controller
public class ClientServlet {

	Constants constant = new Constants();
	String rejected = "доступ закритий";
	String checked = "checked";
	
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
		 List<Calculates> calculates = new ArrayList();
		 
		 if((id==responsibleManager)||(rank!=constant.MANAGER_RANK_MANAGER)){
			 lpr = client.getLpr();
			 phone = client.getPhone();
			 mobile = client.getMobile();
			 mail = client.getMail();
			 othercontact = client.getOthercontact();
			 
			 records = base.getListOfRecordsByClientId(idOfClient);
			 calculates = base.getListOfCalculatesByCompanyid(idOfClient);
			 
			 addRecord = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-comments-o\"> </i></button>";
			 editClient =  "<a href=\"/clientshisory/editclient/"+clientid+"\" class=\"w3-button\"><i class=\"fa fa-edit\"></i></a>";
		 }
		 
		 List<String> icons = decoder.translateForRecordsFunelfromDBtoIcons(records);
		 
		 String check0 = "";
		 String check1 = "";
		 String check2 = "";
		 String check3 = "";
		 String check4 = "";
		 
		 if(funel == constant.CLIENT_FUNEL_COLD_CALL){
			 check0 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_COMUNICATION_WITH_LPR){
			 check1 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_CONTRACT_DEALING){
			 check2 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_BECAME_CLIENT){
			 check3 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_STOP_COWORKING){
			 check4 = checked;
		 }
		 
		 List <Weeklyreminder> reminders = base.getListOfWeeklyreminderByClientid(idOfClient);
		 
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("idOfClient", idOfClient);
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
		 model.addAttribute("calculates", calculates);
		 
		 model.addAttribute("addRecord", addRecord);
		 
		 model.addAttribute("icons", icons);
		 
		 model.addAttribute("clientid", clientid);
		 model.addAttribute("editClient", editClient);
		 
		 model.addAttribute("check0", check0);
		 model.addAttribute("check1", check1);
		 model.addAttribute("check2", check2);
		 model.addAttribute("check3", check3);
		 model.addAttribute("check4", check4);
		 
		 model.addAttribute("reminders", reminders);
		    	
    	 return "client";
    }
    
	@RequestMapping(value = "/client/{clientid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
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
		 
		 List <Weeklyreminder> reminders = base.getListOfWeeklyreminderByClientid(idOfClient);
		 
		 
		 
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
		 List<Calculates> calculates = new ArrayList();
		 
		 if((id==responsibleManager)||(rank!=constant.MANAGER_RANK_MANAGER)){
			 lpr = client.getLpr();
			 phone = client.getPhone();
			 mobile = client.getMobile();
			 mail = client.getMail();
			 othercontact = client.getOthercontact();
			 
			 records = base.getListOfRecordsByClientId(idOfClient);
			 calculates = base.getListOfCalculatesByCompanyid(idOfClient);
			 
			 addRecord = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-comments-o\"> </i></button>";
			 editClient =  "<a href=\"/clientshisory/editclient/"+clientid+" class=\"w3-button\"><i class=\"fa fa-edit\"></i></a>";
		 }
		 
		 List<String> icons = decoder.translateForRecordsFunelfromDBtoIcons(records);
		 
		 String check0 = "";
		 String check1 = "";
		 String check2 = "";
		 String check3 = "";
		 String check4 = "";
		 
		 if(funel == constant.CLIENT_FUNEL_COLD_CALL){
			 check0 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_COMUNICATION_WITH_LPR){
			 check1 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_CONTRACT_DEALING){
			 check2 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_BECAME_CLIENT){
			 check3 = checked;
		 }else if(funel == constant.CLIENT_FUNEL_STOP_COWORKING){
			 check4 = checked;
		 }
		 
		 //base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("idOfClient", idOfClient);
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
		 model.addAttribute("calculates", calculates);
		 
		 model.addAttribute("addRecord", addRecord);
		 
		 model.addAttribute("icons", icons);
		 
		 model.addAttribute("clientid", clientid);
		 model.addAttribute("editClient", editClient);
		 
		 model.addAttribute("check0", check0);
		 model.addAttribute("check1", check1);
		 model.addAttribute("check2", check2);
		 model.addAttribute("check3", check3);
		 model.addAttribute("check4", check4);
		 
		 model.addAttribute("reminders", reminders);
		 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
						 
		 String planrecord = request.getParameter("planrecord");
		 String stringDate = request.getParameter("callfornexttime");
		 String radiofunel = request.getParameter("radiofunel");

		 if (planrecord != null){
				try {
					planrecord = new String(planrecord.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		 
		 DateFormat format = new SimpleDateFormat("yyyy-MM-dd"); //changed bug of mounth
		 Date planNextCall = null;

			try {
				planNextCall = format.parse(stringDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			int funelradio = Integer.parseInt(radiofunel);
			int managerid = client.getManagerid();
			
			int recordStatus = 0;
		 
		 if((rank != constant.MANAGER_RANK_MANAGER)&&(id!=managerid)){
			 recordStatus = 6;
		 }else if(funelradio!=funel){
			 recordStatus = funelradio;
		 }
		 
		 base.editNectcallAndLastrecordAndFunekOfClientById(idOfClient, planNextCall, funelradio, planrecord);
		 
		 Records rec = new Records();
		 
		 rec.setClientid(idOfClient);
		 rec.setDate(new Date());
		 rec.setFunel(funelradio);
		 rec.setManager(name);
		 rec.setManagerid(id);
		 rec.setRecord(planrecord);
		 rec.setRecordstatus(recordStatus);
		
		 base.addRecords(rec);
		 
		 base.closeConnection();
		 
		 try {
				response.sendRedirect("/clientshisory/client/"+idOfClient);
			} catch (IOException e) {
				e.printStackTrace();
			}
		    	
   	 return "client";
	}
}
