package calculator.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import calculator.logic.ServiceCalculator;
import calculator.logic.TransportData;
import calculator.model.Order;
import calculator.model.Route;

@Controller
@RequestMapping("/order")
public class OrderServlet {
	

	@RequestMapping(method = RequestMethod.GET)
	public String calculate(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		Order order = (Order) session.getAttribute("order");
		//session.removeAttribute("order");
		model.addAttribute("transport", order.getTransport());
		
		return "order";

	}
	

}
