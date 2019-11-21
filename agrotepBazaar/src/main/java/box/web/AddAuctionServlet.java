package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.DataBaseController;
import box.model.Auction;

@Controller
@RequestMapping("/addauction")
public class AddAuctionServlet {
	
	String top = "top";
	String coordinator = "coordinator";

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
        HttpSession session = request.getSession();
		
		int id = (Integer) session.getAttribute("id");
		String rank = (String) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");
			
		String button = "";
		
		if(rank.equals(top)||rank.equals(coordinator)){
			button ="<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Новий Тендер</button>";
		}
		

		model.addAttribute("name", name);
		model.addAttribute("button", button);
		
		return "addauction";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
			int id = (Integer) session.getAttribute("id");
			String rank = (String) session.getAttribute("rank");
			String name = (String) session.getAttribute("name");
				
			String button = "";
			
			if(rank.equals(top)||rank.equals(coordinator)){
				button ="<button type=\"submit\" class=\"w3-button w3-green w3-third\" name=\"add\" value=\"add\">Новий Тендер</button>";
			}
			

			model.addAttribute("name", name);
			model.addAttribute("button", button);
			
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String route = request.getParameter("route");
			String readiness = request.getParameter("readiness");
			String price = request.getParameter("rate");
			String currency = request.getParameter("currency");
			String truck = request.getParameter("truck");
			String direction = request.getParameter("direction");
			String important = request.getParameter("important");
			
			if (route != null){
				try {
					route = new String(route.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (readiness != null){
				try {
					readiness = new String(readiness.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (truck != null){
				try {
					truck = new String(truck.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			int rate = Integer.parseInt(price);	
			int importance = Integer.parseInt(important);
			
			DataBaseController base = new DataBaseController();
			
			Auction auction = new Auction();
			
			auction.setBetcount(0);
			auction.setCurrency(currency);
			auction.setDate(new Date());
			auction.setDirection(direction);
			auction.setImportance(importance);
			auction.setManagerid(id);
			auction.setRate(rate);
			auction.setReadiness(readiness);
			auction.setRoute(route);
			auction.setTruck(truck);
			
			base.addAuction(auction);
			
			base.closeConnection();
			
			try {
				response.sendRedirect("/bazaar/auction");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return "addauction";
		
	}

}
