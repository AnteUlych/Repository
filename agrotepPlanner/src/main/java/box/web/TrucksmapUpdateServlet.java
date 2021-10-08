package box.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Manager;
import box.model.Route;
import box.model.Statistic;

@Controller
@RequestMapping("/trucksmapupdate")
public class TrucksmapUpdateServlet {
	
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
		
		return "trucksmapupdate";
				
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		String maplink = request.getParameter("maplink");
		
		DataBaseController base = new DataBaseController();
	
		//bad code
		if(maplink.contains("ruptela")){
			base.editMaplinkById(1, maplink);
		}else{
			maplink = base.getMaplinkById(1).getLink();
		}
		//bad code
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("maplink", maplink);
		
		return "trucksmapupdate";
		
	}

}
