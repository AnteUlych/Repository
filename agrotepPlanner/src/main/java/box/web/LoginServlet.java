package box.web;

import java.io.IOException;
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
import box.model.Truck;

@Controller
@RequestMapping("/login")
public class LoginServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model) {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String doPost(HttpServletRequest request,
			HttpServletResponse response) {

		DataBaseController base = new DataBaseController();
		String pass = request.getParameter("pass");

		if (!base.isManagerExisByLoginPass(pass)) {
	
			base.closeConnection();
			return "login";
		}

		Manager manager = base.getManagersByLoginPass(pass);
		
		List <Truck> trucksUrgent = base.getListOfReadyTrucksSortedByManager();
		for(Truck truck:trucksUrgent){
			int mounthKm = base.getMounthKm(truck.getTruckKey());
			double uahkmruptela0131 = base.getMounthUAHforKMByTruckId(truck.getId(), mounthKm);
			base.editTruckKmruptela0131tById(truck.getId(), mounthKm, uahkmruptela0131);
		}

		HttpSession session = request.getSession();

		session.setAttribute("id", manager.getId());
		session.setAttribute("status", manager.getStatus());
		session.setAttribute("name", manager.getName());
		
		session.setAttribute("filterMy", Constants.FILTER_FALSE);
		session.setAttribute("filterUrgent", Constants.FILTER_FALSE);
		session.setAttribute("filterNotClosed", Constants.FILTER_FALSE);

		base.closeConnection();

		try {
			if(manager.getStatus()==Constants.DOCUMENTS_ACCESS){
				response.sendRedirect("/planner/documents");
				return "documents";
			}else{
			response.sendRedirect("/planner/timetable");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "timetable";
	}

}
