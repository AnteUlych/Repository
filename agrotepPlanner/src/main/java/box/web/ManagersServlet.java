package box.web;

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

@Controller
@RequestMapping("/managers")
public class ManagersServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		List<Manager> managers = new ArrayList();
		List<String> buttons = new ArrayList();
		
		String visibleButton = "disabled";
		
		if(status==Constants.TOTAL_ACCESS){
			visibleButton = "";
			DataBaseController base = new DataBaseController();
			managers = base.getListOfManagers();
			
			for(Manager m:managers){
				if(base.isManagerHasTruck(m.getId())){
					buttons.add("disabled");
				}else{
					buttons.add("");
				}
			}
			base.closeConnection();
		}
		
		model.addAttribute("name", name);
		
		model.addAttribute("visibleButton", visibleButton);
		model.addAttribute("managers", managers);
		model.addAttribute("buttons", buttons);
		
		return "managers";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		List<Manager> managers = new ArrayList();
		List<String> buttons = new ArrayList();
		
		DataBaseController base = new DataBaseController();
		
			managers = base.getListOfManagers();
			
			for(Manager m:managers){
				if(request.getParameter("edit"+m.getId()) != null){
					String newCode = base.createPassword();
					base.editCodeManagerById(m.getId(), newCode);
				}
				if(request.getParameter("delete"+m.getId()) != null){
					base.deleteManagerById(m.getId());
				}
			}
			
			if(request.getParameter("add") != null){
				
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
				
				String statusVision = request.getParameter("statusVision");
				int statusOfManager = Integer.parseInt(statusVision);
				String code = base.createPassword();
				
				Manager newManager = new Manager();
				
				newManager.setLoginPass(code);
				newManager.setName(managerName);
				newManager.setStatus(statusOfManager);
				
				base.addManager(newManager);
			}
			
			managers = base.getListOfManagers();
			
			for(Manager m:managers){
				if(base.isManagerHasTruck(m.getId())){
					buttons.add("disabled");
				}else{
					buttons.add("");
				}
			}
			
			base.closeConnection();

		model.addAttribute("name", name);
		
		model.addAttribute("managers", managers);
		model.addAttribute("buttons", buttons);
		
		return "managers";
		
	}

}
