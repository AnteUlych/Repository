package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.model.Tender;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPropositionServlet {

	@RequestMapping(value = "/addProposition/{tenderId}", method = RequestMethod.GET)
	public String selectService(@PathVariable("tenderId") String tenderId,
			ModelMap model, HttpServletRequest request) {
		
		int idTender = Integer.parseInt(tenderId);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		Tender tender = data.getTenderByTenderId(idTender);
		data.closeConnection();
		
		ConstantBase constant = new ConstantBase();
		List<String> currencies = constant.getCurrencyBase();
		List<String> transports = constant.getTransportBase();
		transports.remove("any");
		
		model.addAttribute("logo", logo);
		model.addAttribute("tender", tender);
		model.addAttribute("currencies", currencies);
		model.addAttribute("transports", transports);
		model.addAttribute("id", id);
	
		return "addproposition";
	}
	
	@RequestMapping(value = "/addProposition/{tenderId}", method = RequestMethod.POST)
	public String podtService(@PathVariable("tenderId") String tenderId,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		

		int idTender = Integer.parseInt(tenderId);
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		String logo = (String) session.getAttribute("logo");
		
		DataController data = new DataController();
		
		Tender tender = data.getTenderByTenderId(idTender);
		
		ConstantBase constant = new ConstantBase();
		List<String> currencies = constant.getCurrencyBase();
		List<String> transports = constant.getTransportBase();
		transports.remove("any");
		
		model.addAttribute("logo", logo);
		model.addAttribute("tender", tender);
		model.addAttribute("currencies", currencies);
		model.addAttribute("transports", transports);
		model.addAttribute("id", id);
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String pickup = request.getParameter("pickup");
		String deliverydate = request.getParameter("deliverydate");
		String otherinformation = request.getParameter("otherinformation");
		String price = request.getParameter("price");
		String currency = request.getParameter("currency");
		String transport = request.getParameter("transport");
		
		
		if (pickup != null){
			try {
				pickup = new String(pickup.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (deliverydate != null){
			try {
				deliverydate = new String(deliverydate.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (otherinformation != null){
			try {
				otherinformation = new String(otherinformation.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		data.addProposition(idTender, id, logo, transport, pickup, deliverydate, Integer.parseInt(price), currency, otherinformation);
		data.closeConnection();
		
		try {
			response.sendRedirect("/lotos/tender/"+idTender);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "tender";
		
	}
}
