package calculator.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import calculator.logic.TransportData;
import calculator.model.Route;

@Controller
@RequestMapping("/calculator")
public class CalculatorServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String calculate(Model model) {

		Route route = new Route();
		model.addAttribute("route", route);
		initModelList(model);
		
		return "calculator";

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String calculate(Model model, Route route, HttpServletRequest request, HttpServletResponse response) {
		
		 model.addAttribute("route", route);
		 initModelList(model);
		 
		 HttpSession session = request.getSession();
		 session.setAttribute("route",route);
		 		 
		 if(route.getDestination().equals("")||route.getPort().equals("")||route.getVolume().equals("")||route.getWeight().equals("")){
			 return "calculator"; 
		 }
	
		 try {
			response.sendRedirect("/lcl/result");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "result";
	}
	
	private void initModelList(Model model) {
		
		TransportData data = new TransportData();
		
		List <String> destinations = data.getDestinations();
		model.addAttribute("destinations", destinations);
		
		List <String> americanPorts = data.getAmericansPorts();
		List <String> eastAsiaPorts = data.getEastAsiaPorts();
		List <String> southAsiaPorts = data.getSouthAsiaPorts();
		List <String> africaPorts = data.getAfricaPorts();		
		List <String> ocaniaPorts = data.getOcaniaPorts();
				
		model.addAttribute("americanPorts", americanPorts);
		model.addAttribute("eastAsiaPorts", eastAsiaPorts);
		model.addAttribute("southAsiaPorts", southAsiaPorts);
		model.addAttribute("africaPorts", africaPorts);
		model.addAttribute("ocaniaPorts", ocaniaPorts);
		
		data = null;
		
		americanPorts = null;
		eastAsiaPorts = null;
		southAsiaPorts = null;
		africaPorts = null;
		ocaniaPorts = null;
		
		destinations = null;
	}
	
}
