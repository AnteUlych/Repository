package calculator.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import calculator.model.Route;

@Controller
@RequestMapping("/calculator")
public class CalculatorServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String calculate(Model model) {

		Route route = new Route();
		model.addAttribute("route", route);
	//	initModelList(model);
		
		return "calculator";

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String calculate(Model model, Route route, HttpServletRequest request, HttpServletResponse response) {
		
		 model.addAttribute("route", route);
		 
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
	/**
	private void initModelList(Model model) {
		List<String> ports = new ArrayList<String>();
		ports.add("Buenos Aires, Argentina");
		ports.add("Rosario, Argentina");
		model.addAttribute("ports", ports);
	}
	*/
}
