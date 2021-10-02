package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Client;
import box.model.Direction;

@Controller
public class ClientServlet {
	
	@RequestMapping(value = "/client/{clientid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request) {
		
        HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
		int idOfClient = Integer.parseInt(clientid);
		
		DataBaseController base = new DataBaseController();
		
		Client clien= base.getClientById(idOfClient);
		List<Direction> directions = base.getListOfDirectionsByClientId(idOfClient);
		
		String blacklist = "";
		String checkBlackList = "";
		if(clien.getBlacklist()==Constants.CLIENT_IN_BLACK_LIST){
			blacklist = "<p style=\"color:red;\">чорний список</p>";
			checkBlackList = "checked";
		}
		
		String tilt = "";
		String ref = "";
		String any = "";
		
		if(clien.getTypetruck().equals("тент")){
			tilt = "checked";
		}else if(clien.getTypetruck().equals("реф")){
			ref = "checked";
		}else if(clien.getTypetruck().equals("тент або реф")){
			any = "checked";
		}
		
		base.closeConnection();
		
		model.addAttribute("clien", clien);
		model.addAttribute("directions", directions);
		
		model.addAttribute("blacklist", blacklist);
		model.addAttribute("checkBlackList", checkBlackList);
		
		model.addAttribute("tilt", tilt);
		model.addAttribute("ref", ref);
		model.addAttribute("any", any);
        	
		return "client";
	}
	
	@RequestMapping(value = "/client/{clientid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		int id = (Integer) session.getAttribute("id");
		
	    int idOfClient = Integer.parseInt(clientid);
		DataBaseController base = new DataBaseController();
		
		Client clien= base.getClientById(idOfClient);
		List<Direction> directions = base.getListOfDirectionsByClientId(idOfClient);
		
		for(Direction d:directions){
			if (request.getParameter("delete"+d.getId()) != null) {
				base.deleteDirection(d.getId());
			}	
		}
		
		if (request.getParameter("button1") != null) {
		
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String oblastFrom = request.getParameter("oblastFrom");
			String oblastTo = request.getParameter("oblastTo");
			String directioninfo = request.getParameter("directioninfo");
		
			
			if (oblastFrom == null){
				oblastFrom=" ";
			}
			if (oblastFrom != null){
				try {
					oblastFrom = new String(oblastFrom.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (oblastTo != null){
				try {
					oblastTo = new String(oblastTo.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (directioninfo != null){
				try {
					directioninfo = new String(directioninfo.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			Direction d = new Direction();
		
			d.setClientId(idOfClient);
			d.setInfo(directioninfo);
			d.setOblastFrom(oblastFrom);
			d.setOblastTo(oblastTo);
			
			base.addDirection(d);
			
		}
		
		if (request.getParameter("button") != null) {
			
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String company = request.getParameter("company");
			String code = request.getParameter("code");
			String contactPerson = request.getParameter("contactPerson");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			String payment = request.getParameter("payment");
			String transportVolume = request.getParameter("transportVolume");
			String season = request.getParameter("season");
			String cargo = request.getParameter("cargo");
			String otherInfo = request.getParameter("otherInfo");
			String typetruck = request.getParameter("typetruck");
			String warning = request.getParameter("warning");
			String toblacklist = request.getParameter("toblacklist");
			String driverInstruction = request.getParameter("driverInstruction");
			
			int blackListForClient = Constants.CLIENT_NOT_IN_BLACK_LIST;
			if(toblacklist!=null){
				blackListForClient = Constants.CLIENT_IN_BLACK_LIST;
			}
			
			if (driverInstruction != null){
				try {
					driverInstruction = new String(driverInstruction.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (company != null){
				try {
					company = new String(company.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (contactPerson != null){
				try {
					contactPerson = new String(contactPerson.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (phone != null){
				try {
					phone = new String(phone.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (payment != null){
				try {
					payment = new String(payment.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (transportVolume != null){
				try {
					transportVolume = new String(transportVolume.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (season != null){
				try {
					season = new String(season.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (cargo != null){
				try {
					cargo = new String(cargo.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (otherInfo != null){
				try {
					otherInfo = new String(otherInfo.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (typetruck != null){
				try {
					typetruck = new String(typetruck.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (warning != null){
				try {
					warning = new String(warning.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			base.editClientById(idOfClient, blackListForClient, cargo, company, contactPerson, email, otherInfo, payment, phone, season, transportVolume, typetruck, warning, driverInstruction);
			
			
		}
		
		base.closeConnection();
		
		try {
			response.sendRedirect("/planner/client/"+clien.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return "client";
	}
		

}
