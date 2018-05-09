package calculator.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import calculator.logic.Mail;
import calculator.logic.ServiceCalculator;
import calculator.logic.TransportData;
import calculator.model.Order;
import calculator.model.Route;

@Controller
@RequestMapping("/order")
public class OrderServlet {

	Order order;

	@RequestMapping(method = RequestMethod.GET)
	public String calculate(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();
		order = (Order) session.getAttribute("order");
	   // session.removeAttribute("order");
		model.addAttribute("transport", order.getTransport());
		model.addAttribute("way", order.getWay());
		model.addAttribute("time", order.getTime());
		model.addAttribute("price", order.getPrice());

		return "order";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String calculate(Model model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		order = (Order) session.getAttribute("order");
		String date = request.getParameter("date");
		
		 String requestEnc = "ISO-8859-1";
		   String clientEnc = request.getParameter("charset");
		   if( clientEnc==null ) clientEnc="Cp1251";
		    String name = request.getParameter("name");
			String company = request.getParameter("company");
			String mail = request.getParameter("mail");
			String phone = request.getParameter("phone");
		   if( name!=null )
			try {
				name = new String(name.getBytes(requestEnc),clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		   if( company!=null )
				try {
					company = new String(company.getBytes(requestEnc),clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		   if( mail!=null )
				try {
					mail = new String(mail.getBytes(requestEnc),clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
		   if( phone!=null )
				try {
					phone = new String(phone.getBytes(requestEnc),clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
        order.setDate(date);
		order.setCompany(company);
		order.setMail(mail);
		order.setName(name);
		order.setPhone(phone);
		
		Mail sender = new Mail();
		sender.send(order);

		return "booked";
	}

}
