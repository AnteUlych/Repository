package box.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Manager;

@Controller
@RequestMapping("/test")
public class TestServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
				
		DataBaseController db = new DataBaseController();
		List<Manager> m = db.getListOfManagers();
		
		String name ="";
		
		for(Manager ma:m){
			name = ma.getName();
		}
		
		model.addAttribute("name", name);
		
		return "test";
	}

}
