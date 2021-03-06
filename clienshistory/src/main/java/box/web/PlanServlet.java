package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
@RequestMapping("/plan")
public class PlanServlet {
	
	Constants constant = new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
		
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 List<Client> clients = new ArrayList();
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){
			 clients = base.getClientsByManagerIdSortedByNexcall(id);
		 }else{
			 clients = base.getClientsSortedByNextcall();
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
		 
		return "plan";
	}

}
