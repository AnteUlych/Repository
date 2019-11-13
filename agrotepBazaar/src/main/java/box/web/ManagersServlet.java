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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Manager;

@Controller
@RequestMapping("/managers")
public class ManagersServlet {
	
	String RANK_TOP = "top";
	String ADD_MANAGER_BUTTON = "<button class=\"w3-button\" onclick=\"document.getElementById('subscribe').style.display='block'\"><i class=\"fa fa-user-plus fa-fw\"></i></button>";
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 
		 String addManager = "";
		 
		 List <Manager> managers = new ArrayList();
		 
		 if(rank.equals("top")){
			 DataBaseController base = new DataBaseController();
			 managers = base.getListOfManagers();
			 addManager = ADD_MANAGER_BUTTON;
			  base.closeConnection();
		 }
		
		 
		 model.addAttribute("name", name);
		 model.addAttribute("managers", managers);
		 model.addAttribute("addManager", addManager);
		
		return "managers";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 String rank = (String) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		 
		 DataBaseController base = new DataBaseController();
		 String addManager = "";
		 
		 List <Manager> managers = new ArrayList();
		 
		 if(rank.equals("top")){
			 managers = base.getListOfManagers();
			 addManager = ADD_MANAGER_BUTTON;
			
		 }
		 		 
		 model.addAttribute("name", name);
		 model.addAttribute("managers", managers);
		 model.addAttribute("addManager", addManager);
		 
		
		 
		 
		 if(request.getParameter("add") != null){
			 
			 String manager = request.getParameter("name");
			 String mail = request.getParameter("mail");
			 String san = request.getParameter("san");
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
				
				if (manager != null){
					try {
						manager = new String(manager.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

			Manager newManager = new Manager();
			
			newManager.setMail(mail);
			newManager.setName(manager);
			newManager.setRank(san);
			newManager.setCode(base.generateCodeForManager());
			
		 
			base.addManager(newManager);
		 }
		 
		 for(Manager m:managers){
			 
			 if(request.getParameter("edit"+m.getId()) != null){
				 
				 String manager = request.getParameter("name"+m.getId());
				 String mail = request.getParameter("mail"+m.getId());
				 String san = request.getParameter("san"+m.getId());
					
					String requestEnc = "ISO-8859-1";
					String clientEnc = request.getParameter("charset");
					if (clientEnc == null)
						clientEnc = "Cp1251";
					
					if (manager != null){
						try {
							manager = new String(manager.getBytes(requestEnc), clientEnc);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					
					base.editManager(m.getId(), manager, mail, san, base.getManagerById(m.getId()).getCode());
				 
			 }
			 
			 if(request.getParameter("fired"+m.getId()) != null){
				 
				 String manager = request.getParameter("name"+m.getId());
				 String mail = request.getParameter("mail"+m.getId());
				 
					
					String requestEnc = "ISO-8859-1";
					String clientEnc = request.getParameter("charset");
					if (clientEnc == null)
						clientEnc = "Cp1251";
					
					if (manager != null){
						try {
							manager = new String(manager.getBytes(requestEnc), clientEnc);
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
				 
				 base.editManager(m.getId(), name, mail, "fired", base.getManagerById(m.getId()).getCode()+"f");
			 }
			 
		 }
		 
		 base.closeConnection();
		 
		 try {
				response.sendRedirect("/bazaar/managers");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		 return "managers";
		
	}
	

}
