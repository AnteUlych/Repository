package bird.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;
import bird.model.Cargo;
import bird.model.Route;

@Controller
//@RequestMapping("/route/{id}")
public class RouteController {
	
	
	Expediter monitoring = new Expediter();

	@RequestMapping(value = "route/{id}", method = RequestMethod.GET)
	public String selectRoute(@PathVariable("id") String id, ModelMap model,HttpServletRequest request) {

		 if(!monitoring.isAccessAvailable(request.getRemoteAddr())){
			 return "denied";
		 }
		 
		Cargo cargo = monitoring.getCargoBy(Integer.parseInt(id));
		List<Route> route = monitoring.getRoutebyCargoId(Integer.parseInt(id));
		String way = monitoring.getStatisticForMap(Integer.parseInt(id));
		String lastStatus = monitoring.getLastStatusByCargoId(Integer.parseInt(id));
		
		model.addAttribute("lastStatus", lastStatus);
		model.addAttribute("route", route);
		model.addAttribute("cargo", cargo);
		model.addAttribute("way", way);
		model.addAttribute("time", detCargoDate(cargo));

		return "Route";
	}



	@RequestMapping(value = "route/{id}", method = RequestMethod.POST)
	public String selectRoute(@PathVariable("id") String id,
			HttpServletRequest req, HttpServletRequest resp, ModelMap model) {

		Cargo cargo = monitoring.getCargoBy(Integer.parseInt(id));
		List<Route> route = monitoring.getRoutebyCargoId(Integer.parseInt(id));
		String way = monitoring.getStatisticForMap(Integer.parseInt(id));
        String lastStatus = monitoring.getLastStatusByCargoId(Integer.parseInt(id));
		
		model.addAttribute("lastStatus", lastStatus);
		model.addAttribute("route", route);
		model.addAttribute("cargo", cargo);
		model.addAttribute("way", way);
		model.addAttribute("time", detCargoDate(cargo));
		
		int cargoID = Integer.parseInt(id);
		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		String status = req.getParameter("status");
		
		String ETD = req.getParameter("ETD");
		
		
			String finish = (String)req.getParameter("finish");
		
		if ("on".equals(finish)) {
			monitoring.finishCargo(cargoID);
			return "ok";
		}
		
		if (!longitude.equals(null) && !latitude.equals(null)
				&& !status.equals(null) && !longitude.equals("")
				&& !latitude.equals("") && !status.equals("")
				&& monitoring.isDouble(longitude)
				&& monitoring.isDouble(latitude)) {
			monitoring.editDeliveryDateForCargo(cargoID, ETD);
			monitoring.addRoute(cargoID, Double.parseDouble(longitude),
					Double.parseDouble(latitude), status);

			return "ok";
		}

		return "redirect:" + id;
	}
	
	private String detCargoDate(Cargo cargo) {
		
		Date delivery = cargo.getDelivery();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		return df.format(delivery);
	}

}
