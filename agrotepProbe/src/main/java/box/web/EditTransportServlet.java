package box.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.LogicDataBase;
import box.model.Proposition;
import box.model.Transport;

@Controller
public class EditTransportServlet {
	
	@RequestMapping(value = "/editransport/{transportid}", method = RequestMethod.GET)
	public String selectService(@PathVariable("transportid") String transportid,
			ModelMap model) {
		
		int id = Integer.parseInt(transportid);	
		
		LogicDataBase logic = new LogicDataBase();
		Transport transport = logic.getTransportById(id);
		
		model.addAttribute("transport", transport);
		
		logic.closeConnection();
		
		return "edittransport";
	}
	
	@RequestMapping(value = "/editransport/{transportid}", method = RequestMethod.POST)
	public String postProposition(@PathVariable("transportid") String transportid,
			ModelMap model, HttpServletRequest req, HttpServletResponse resp) {
		
        int id = Integer.parseInt(transportid);	
		
		LogicDataBase logic = new LogicDataBase();
		Transport transport = logic.getTransportById(id);
		
		model.addAttribute("transport", transport);
		
		String truckdriver = req.getParameter("truck");
		logic.setTransportTruckdriver(id, truckdriver);
		
		try {
			logic.closeConnection();
			resp.sendRedirect("/probe/transports/"+transport.getDirection());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		return "transports";
		
	}

}
