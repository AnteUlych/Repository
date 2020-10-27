package box.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
public class PlanproductServlet {
	
	Constants constant = new Constants();
	
    @RequestMapping(value = "/planproduct/{productid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("productid") String productid, ModelMap model, HttpServletRequest request) {
    	
		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 int idOfProduct = Integer.parseInt(productid);
		 String product = base.getProductById(idOfProduct).getProduct();
		 
		 List<Client> clients = new ArrayList();
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			 clients = base.getClientsByManagerIdAndProductSortedByNexcall(id, product);
		 }else{
		     clients = base.getClientsByProductSortedByNextcall(product);
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
		 model.addAttribute("product", product);
		
	return "planproduct";
	
	}

}
