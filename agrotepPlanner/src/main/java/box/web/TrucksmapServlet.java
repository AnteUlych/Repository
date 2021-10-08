package box.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;

@Controller
@RequestMapping("/trucksmap")
public class TrucksmapServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
			
		DataBaseController base = new DataBaseController();
		//bad code
		String  maplink = base.getMaplinkById(1).getLink();
		//bad code
		base.closeConnection();	
		
		model.addAttribute("name", name);
		model.addAttribute("maplink", maplink);
		
		return "trucksmap";
				
	}
}
