package bird.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Route;

@Controller
public class EditRouteController {
	
	Expediter monitoring = new Expediter();
	
	@RequestMapping(value = "editRoute/{id}", method = RequestMethod.GET)
	public String selectRoute(@PathVariable("id") String id, ModelMap model) {

		Route cargo = monitoring.getRouteBy(Integer.parseInt(id));
		model.addAttribute("cargo", cargo);

		return "editRoute";

	}

	@RequestMapping(value = "editRoute/{id}", method = RequestMethod.POST)
	public String openProject(@PathVariable("id") String id, HttpServletRequest req, HttpServletRequest resp) {

		int routeID = Integer.parseInt(id);
		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		String status = req.getParameter("status");

		if (monitoring.isDouble(longitude)
				&& monitoring.isDouble(latitude)) {
			
		monitoring.editRoute(routeID, Double.parseDouble(longitude),
					Double.parseDouble(latitude), status);
		return "ok";
		
		}
		
		return "redirect:" + id;
	}

}


