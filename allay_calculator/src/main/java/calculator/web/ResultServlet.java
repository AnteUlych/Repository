package calculator.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import calculator.logic.ServiceCalculator;
import calculator.logic.TransportData;
import calculator.model.Order;
import calculator.model.Route;

@Controller
@RequestMapping("/result")
public class ResultServlet {
	/**
	String waybill;
	int seaRate;
	int seaTime;
	int railRate;
	int railTime;
	*/
	@RequestMapping(method = RequestMethod.GET)
	public String calculate(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Route route = (Route) session.getAttribute("route");
		//session.removeAttribute("route");
		
		String way = new TransportData().createTheRoute(route.getPort(), route.getDestination());
		int volume = Integer.parseInt(route.getVolume());
		int weight = Integer.parseInt(route.getWeight());
		ServiceCalculator service = new ServiceCalculator(way, volume, weight);
		
		String waybill = service.getWay();
		int seaRate = service.getSeaRate();
		int seaTime = service.getSeaTime();
		
		boolean rail = service.isRailRatePossible();
		
		model.addAttribute("rail", rail);
		if(rail){
			int railRate = service.getRailRate();
			int railTime = service.getRailTime();
			model.addAttribute("railRate", railRate);
			model.addAttribute("railTime", railTime);
		}
		
		model.addAttribute("waybill", waybill);
		model.addAttribute("seaRate", seaRate);
		model.addAttribute("seaTime", seaTime);
		
		return "result";

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String calculate(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		Route route = (Route) session.getAttribute("route");
		//session.removeAttribute("route");
		
		String way = new TransportData().createTheRoute(route.getPort(), route.getDestination());
		int volume = Integer.parseInt(route.getVolume());
		int weight = Integer.parseInt(route.getWeight());
		ServiceCalculator service = new ServiceCalculator(way, volume, weight);
		
		String waybill = service.getWay();
		int seaRate = service.getSeaRate();
		int seaTime = service.getSeaTime();
		
		boolean rail = service.isRailRatePossible();
		
			int railRate = 0;
			int railTime = 0;
			
			if(rail){
				railRate = service.getRailRate();
				railTime = service.getRailTime();
			}
		
		//?
		String booking = request.getParameter("booking");
		Order order = new Order();
		order.setWay(waybill);
		order.setTransport(booking);
		
		if(booking.equals("booking via LCL")){
			order.setPrice(seaRate);
			order.setTime(seaTime);
		}
		if(booking.equals("booking via Rail")){
			order.setPrice(railRate);
			order.setTime(railTime);
		}
		 //HttpSession session = request.getSession();
		 session.setAttribute("order",order);
		 try {
			response.sendRedirect("/lcl/order");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "order";
	}

}
