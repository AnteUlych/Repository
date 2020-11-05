package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import box.model.Manager;
import box.model.Product;

@Controller
@RequestMapping("/managers")
public class ManagersServlet {
	
Constants constant = new Constants();
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String menuForHead = "";		 
		 List<Manager> managers = new ArrayList();
		 String addManager = "";
		 
		 List<Product> products = base.getListOfOpenProducts();
		 List<String> ranks = new ArrayList();
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
			 menuForHead = constant.MENU_FOR_HEAD;
			 addManager = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-plus\"> </i></button>";
			 
			 //hardcode
			 List<Manager> managers1 = base.getListOfManagers();
			
			 for(Manager m:managers1){
				 if(m.getRank()!=constant.MANAGER_RANK_ADMIN){
					 managers.add(m);
				 }
				 
			 }
			 
			 
			 for(Manager m:managers){
				 if(m.getRank()==constant.MANAGER_RANK_MANAGER){
					 ranks.add("менеджер");
				 }
				 if(m.getRank()==constant.MANAGER_RANK_HEAD){
					 ranks.add("керівник");
				 }
				 if(m.getRank()==constant.MANAGER_RANK_FIRED){
					 ranks.add("звільнений");
				 }
			 }
			 
			//hardcode
		 }
		 
		 
		 base.closeConnection();
		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("addManager", addManager);
		 model.addAttribute("managers", managers);
		 model.addAttribute("ranks", ranks);
		 
		 
		return "managers";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String menuForHead = "";		 
		 List<Manager> managers = new ArrayList();
		 String addManager = "";
		 
		 List<Product> products = base.getListOfOpenProducts();
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{
			 menuForHead = constant.MENU_FOR_HEAD;
			 addManager = "<button class=\"w3-button \" onclick=\"document.getElementById('add').style.display='block'\"><i class=\"fa fa-plus\"> </i></button>";
			 
			 //hardcode
			 List<Manager> managers1 = base.getListOfManagers();

			 for(Manager m:managers1){
				 if(m.getRank()!=constant.MANAGER_RANK_ADMIN){
					 managers.add(m);
				 }
			 }
			//hardcode
		 }
		 List<String> ranks = new ArrayList();
		 for(Manager m:managers){
			 if(m.getRank()==constant.MANAGER_RANK_MANAGER){
				 ranks.add("менеджер");
			 }
			 if(m.getRank()==constant.MANAGER_RANK_HEAD){
				 ranks.add("керівник");
			 }
			 if(m.getRank()==constant.MANAGER_RANK_FIRED){
				 ranks.add("звільнений");
			 }
		 }
		 		 
		 model.addAttribute("name", name);
		 model.addAttribute("products", products);
		 model.addAttribute("menuForHead", menuForHead);
		 
		 model.addAttribute("addManager", addManager);
		 model.addAttribute("managers", managers);
		 model.addAttribute("ranks", ranks);
		 
		 
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String managerName = request.getParameter("managerName");
		   	 
			if (managerName != null){
				try {
					managerName = new String(managerName.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			String managerMail = request.getParameter("managerMail");
			int rankManager = Integer.parseInt(request.getParameter("radioRank"));
			String code = base.generateCodeForManager();
			
			Manager manager = new Manager();
			manager.setCode(code);
			manager.setMail(managerMail);
			manager.setName(managerName);
			manager.setRank(rankManager);
			
			base.addManager(manager);
		  
		    base.closeConnection();
		  
		 try {
				response.sendRedirect("/clientshisory/managers");
			} catch (IOException e) {
				e.printStackTrace();
			}
		 
		 return "managers";
	}

}
