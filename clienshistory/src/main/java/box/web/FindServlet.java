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

@Controller
@RequestMapping("/find")
public class FindServlet {
	
	Constants constant = new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
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
		 
		 
		 DecoderDBtoHTML decoder = new DecoderDBtoHTML();
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		
		 return "find";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		

		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String word = request.getParameter("word");
			
			if (word != null){
				try {
					word = new String(word.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
		
		 DataBaseController base = new DataBaseController();
		 
		 List<Client> clients = base.getClientsByCodeOrCompany(word);
		 String menuForHead = "";
		 
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			
		 }else{
			 
			 menuForHead = constant.MENU_FOR_HEAD;
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
			
		 return "find";
		
	}

}
