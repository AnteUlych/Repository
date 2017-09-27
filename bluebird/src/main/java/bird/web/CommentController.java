package bird.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bird.expediter.Expediter;


@Controller
@RequestMapping("/notion")
public class CommentController {
	
	Expediter monitoring = new Expediter();

	// if radio null - exception
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		String cargoId = (String) session.getAttribute("cargoID");
		//String clientId = (String) session.getAttribute("clientID");
		
		//String cargoId = "7"; //!
		//String clientId = "1"; //!
		int cargoID = Integer.parseInt(cargoId);
		
		String route = monitoring.getSimplInformationByCargoId(cargoID);

		model.addAttribute("route", route);

		return "notion";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(Model model, HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		try{
		String cargoId = (String) session.getAttribute("cargoID");
		//String clientId = (String) session.getAttribute("clientID");
		//String cargoId = "7"; //!
		//String clientId = "1"; //!
		//session.setAttribute("cargoID",cargoId); //!
		//session.setAttribute("clientID",clientId); //!
		
		String inReturn = "Cabinet";
	
			//model.addAttribute("comment", comment);
			String rate = request.getParameter("rate");
			String opinion = request.getParameter("opinion");
			boolean rated = true;
			if(rate.equals(null)){
				
				rated = false;
				rate = "5";
			}
			if (opinion.equals(null)){
				opinion = "";
			}
			int cargoRate = Integer.parseInt(rate);
			int cargoID = Integer.parseInt(cargoId);
			if(rated){
			monitoring.addComment(cargoID, cargoRate, opinion);
			}
			try {
				response.sendRedirect("/bluebird/cabinet");
				return inReturn;
			} catch (IOException e) {

				e.printStackTrace();
			}
		
				
		return inReturn;
	
	} catch (NullPointerException e) {

		try {
			response.sendRedirect("/bluebird/cabinet");
			return "Cabinet";
		} catch (IOException e1) {
			e.printStackTrace();
		}
	
			
	return "password";
	}
	}
}
