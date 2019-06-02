package lotos.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lotos.logic.ConstantBase;
import lotos.logic.DataController;
import lotos.logic.SimpleLogic;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/addtender")
public class AddTenderServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		ConstantBase constant = new ConstantBase();
		
		List<String> incoterms = constant.getIncotermsBase();
		List<String> countries = constant.getCountryBase();
		List<String> transports = constant.getTransportBase();
		List<String> payments = constant.getPaymentBase();
		List<String> visiabilities = constant.getVisiabilityBase();
		
		model.addAttribute("id", id);
		
		model.addAttribute("incoterm", incoterms);
		model.addAttribute("countries", countries);
		model.addAttribute("transports", transports);
		model.addAttribute("payments", payments);
		model.addAttribute("visiabilities", visiabilities);
				
		return "addtender";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int companyId = (Integer) session.getAttribute("id");
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
		String weightInt = request.getParameter("weight");
		String size = request.getParameter("size");
		String readytopickup = request.getParameter("readytopickup");
		String appdelivery = request.getParameter("appdelivery");
		String timetoendtenderDate = request.getParameter("timetoendtender");
		String countryfrom = request.getParameter("countryfrom");
		String countryto = request.getParameter("countryto");
		String possibletransport = request.getParameter("transport");
		String payconditions = request.getParameter("payment");
		String dayspayInt = request.getParameter("dayspay");
		String freightinformationandconditions = request.getParameter("freightinformationandconditions");
		String visiability = request.getParameter("visiability");
		String addresstopickup = request.getParameter("addresstopickup");
		String addresstodelivery = request.getParameter("addresstodelivery");
		String incoterms = request.getParameter("incoterms");
		
		if (size != null){
			try {
				size = new String(size.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (readytopickup != null){
			try {
				readytopickup = new String(readytopickup.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (appdelivery != null){
			try {
				appdelivery = new String(appdelivery.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (freightinformationandconditions != null){
			try {
				freightinformationandconditions = new String(freightinformationandconditions.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (addresstopickup != null){
			try {
				addresstopickup = new String(addresstopickup.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		if (addresstodelivery != null){
			try {
				addresstodelivery = new String(addresstodelivery.getBytes(requestEnc), clientEnc);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		SimpleLogic logic = new SimpleLogic();
		
		int weight = Integer.parseInt(weightInt);
		Date timetoendtender = logic.convertStringToDate(timetoendtenderDate);
		int dayspay = Integer.parseInt(dayspayInt);
		
		DataController data = new DataController();
		String company = data.getCompanyById(companyId).getCompany();
		
		data.addTender(companyId, company, weight, size, readytopickup, appdelivery, timetoendtender, countryfrom, countryto, possibletransport, payconditions, dayspay, freightinformationandconditions, visiability, addresstopickup, addresstodelivery, incoterms);
		data.closeConnection();
		
		try {
			response.sendRedirect("/lotos/tenders");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "tenders";
		
	}

}
