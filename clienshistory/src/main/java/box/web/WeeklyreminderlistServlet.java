package box.web;

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
import box.model.Product;
import box.model.Weeklyreminder;


@Controller
@RequestMapping("/weeklyreminderlist")
public class WeeklyreminderlistServlet {
	
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
			
			 List<Product> products = base.getListOfOpenProducts();
			 
			 List<Weeklyreminder> reminders = base.getListOfWeeklyreminderByManagerId(id);
			 
			 base.closeConnection();
			 
			 model.addAttribute("name", name);
			 model.addAttribute("products", products);
			 model.addAttribute("menuForHead", menuForHead);
			 
			 model.addAttribute("reminders", reminders);
		   
		     return "weeklyreminderlist";
	   }
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
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
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		 List<Weeklyreminder> remindersForDelete = base.getListOfWeeklyreminderByManagerId(id);
		 
		 //post method
		 for(Weeklyreminder w:remindersForDelete){
				if(request.getParameter("delete"+w.getId()) != null){
					base.deleteWeeklyreminderById(w.getId());
				}
		 }
		//post method
		 
		 List<Weeklyreminder> reminders = base.getListOfWeeklyreminderByManagerId(id);
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("reminders", reminders);
		
		return "weeklyreminderlist";
	}

}
