package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
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
import box.model.Product;
import box.model.Weeklyreminder;

@Controller
public class AddweeklyreminderServlet {
	
	Constants constant = new Constants();
	
	@RequestMapping(value = "/addweeklyreminder/{clientid}", method = RequestMethod.GET)
	public String doGet(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int rank = (Integer) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		DataBaseController base = new DataBaseController();

		String menuForHead = "";

		if (rank == constant.MANAGER_RANK_MANAGER) {

		} else {
			menuForHead = constant.MENU_FOR_HEAD;
		}

		List<Product> products = base.getListOfOpenProducts();

		int idOfClient = Integer.parseInt(clientid);
		Client client = base.getClientById(idOfClient);
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("products", products);
		model.addAttribute("menuForHead", menuForHead);

		model.addAttribute("client", client.getCompany());
		
		return "addweeklyreminder";
	}
	
	@RequestMapping(value = "/addweeklyreminder/{clientid}", method = RequestMethod.POST)
	public String doPost(@PathVariable("clientid") String clientid,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int rank = (Integer) session.getAttribute("rank");
		String name = (String) session.getAttribute("name");

		DataBaseController base = new DataBaseController();
		int idOfClient = Integer.parseInt(clientid);
		Client client = base.getClientById(idOfClient);
		
		 String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String textreminder = request.getParameter("textreminder");
			
			if (textreminder != null){
				try {
					textreminder = new String(textreminder.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			String dayoftheweek = request.getParameter("dayofweek");
			int dayofweek = Integer.parseInt(dayoftheweek);
            String clientname = client.getCompany();
            String color = "";
            int isitnotchecked = constant.CHECKED_WEEKLYREMINDER;
            
            String dayofweekname = "";
            
            if(dayofweek==1){
            	dayofweekname = "нед≥л€";
			}else
			
			if(dayofweek==2){
				dayofweekname = "понед≥лок";
			}else
			
			if(dayofweek==3){
				dayofweekname = "в≥второк";
			}else
			
			if(dayofweek==4){
				dayofweekname = "середа";
			}else
			
			if(dayofweek==5){
				dayofweekname = "четвер";
			}else
			
			if(dayofweek==6){
				dayofweekname = "п'€тниц€";
			}else
			
			if(dayofweek==7){
				dayofweekname = "субота";
			}
            
            Date today = new Date();
            
            Weeklyreminder w = new Weeklyreminder();
            w.setBobdate(today);
            w.setClientid(idOfClient);
            w.setClientname(clientname);
            w.setColor(color);
            w.setDayofweek(dayofweek);
            w.setIsitnotchecked(isitnotchecked);
            w.setManagerid(id);
            w.setTextreminder(textreminder);
            w.setDayofweekname(dayofweekname);
            w.setManager(name);
            base.addWeeklyReminder(w);
		    		
		    base.closeConnection();
		
		    try {
				response.sendRedirect("/clientshisory/client/"+idOfClient);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
		return "addweeklyreminder";
	}

}
