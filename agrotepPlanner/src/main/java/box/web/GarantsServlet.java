package box.web;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.SecurityAccess;
import box.model.Client;
import box.model.Garant;

@Controller
@RequestMapping("/garants")
public class GarantsServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		SecurityAccess security = new SecurityAccess();
		if(security.isAccessNotAllowForManagerId((Integer) session.getAttribute("id"))){
			return "notallow";
		}
		
		DataBaseController base = new DataBaseController(); 
		List<Garant> garants = base.getListOfGarants();
		List<Client> clients = base.getListOfClients();
		
		//day of week
		List<String> daysweek = new ArrayList();		
		for(Garant g:garants){
			if(g.getDayofweek()==1){
				daysweek.add("нед≥л€");
			}else
			
			if(g.getDayofweek()==2){
				daysweek.add("понед≥лок");
			}else
			
			if(g.getDayofweek()==3){
				daysweek.add("в≥второк");
			}else
			
			if(g.getDayofweek()==4){
				daysweek.add("середа");
			}else
			
			if(g.getDayofweek()==5){
				daysweek.add("четвер");
			}else
			
			if(g.getDayofweek()==6){
				daysweek.add("п'€тниц€");
			}else
			
			if(g.getDayofweek()==7){
				daysweek.add("субота");
			}
		}
		//day of week
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("garants", garants);
		model.addAttribute("clients", clients);
		model.addAttribute("daysweek", daysweek);
		
		return "garants";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
				
		DataBaseController base = new DataBaseController(); 
		

		if(request.getParameter("add") != null){
			
			String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String client = request.getParameter("client");
			String route = request.getParameter("route");
			
			if (client != null){
				try {
					client = new String(client.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (route != null){
				try {
					route = new String(route.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			int price = Integer.parseInt(request.getParameter("price"));
			int numberoftrucks = Integer.parseInt(request.getParameter("numberoftrucks"));
			int dayofweek = Integer.parseInt(request.getParameter("dayofweek"));
			
			int onetimeuse = Constants.NOT_ONETIMEUSE_GARANT;
			String color = "w3-light-grey";
			
			if (request.getParameter("onetimeuse") != null) {
				onetimeuse = Constants.ONETIMEUSE_GARANT;
				color = "w3-yellow";
				client = client+ " - разове";
			}
			
			Garant garant = new Garant();
			garant.setClient(client);
			garant.setColor(color);
			garant.setDayofweek(dayofweek);
			garant.setOnetimeuse(onetimeuse);
			
			Calendar calendar = Calendar.getInstance();
	
			if(dayofweek==2){
				calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
			}else if(dayofweek==3){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
			}else if(dayofweek==4){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
			}else if(dayofweek==5){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
			}else if(dayofweek==6){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}else if(dayofweek==7){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			}else if(dayofweek==1){
					calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
			}
		    Date needDate = calendar.getTime();
		    
			if (request.getParameter("onetimeuse") != null) {
            
				Calendar c = Calendar.getInstance();	
				c.set(Calendar.HOUR_OF_DAY, 0);
				c.set(Calendar.MILLISECOND, 0);
		        c.set(Calendar.SECOND, 0);
		        c.set(Calendar.MINUTE, 0);
				Date rubiconDate = c.getTime();

				if(needDate.before(rubiconDate)){		
					Calendar cal = Calendar.getInstance();
					cal.setTime(needDate);
					cal.add(Calendar.DATE, 7);
					Date nextPlanDate = cal.getTime();
					
					needDate=nextPlanDate;
				}
		 
				
			}
		    
			garant.setPlandate(needDate);
			garant.setPrice(price);
			garant.setRoute(route);
			garant.setTruckandmanager("");
			
			for(int i=0; i<numberoftrucks;i++){
				base.addGarant(garant);
			}	
		}
		
		//start
		List<Garant> garantsForDelete = base.getListOfGarants();
		for(Garant g:garantsForDelete){
			if(request.getParameter("delete"+g.getId()) != null){
				base.deleteGarantById(g.getId());
			}
		}
		//finish
		
		List<Garant> garants = base.getListOfGarants();
		List<Client> clients = base.getListOfClients();
		
		//day of week
		List<String> daysweek = new ArrayList();		
		for(Garant g:garants){
			if(g.getDayofweek()==1){
				daysweek.add("нед≥л€");
			}else
			
			if(g.getDayofweek()==2){
				daysweek.add("понед≥лок");
			}else
			
			if(g.getDayofweek()==3){
				daysweek.add("в≥второк");
			}else
			
			if(g.getDayofweek()==4){
				daysweek.add("середа");
			}else
			
			if(g.getDayofweek()==5){
				daysweek.add("четвер");
			}else
			
			if(g.getDayofweek()==6){
				daysweek.add("п'€тниц€");
			}else
			
			if(g.getDayofweek()==7){
				daysweek.add("субота");
			}
		}
		//day of week
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		model.addAttribute("garants", garants);
		model.addAttribute("clients", clients);
		model.addAttribute("daysweek", daysweek);
		
		return "garants";
	}

}
