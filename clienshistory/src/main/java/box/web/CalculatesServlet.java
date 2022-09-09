package box.web;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
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
import box.logic.DecoderDBtoHTML;
import box.model.Calculates;
import box.model.Client;
import box.model.Product;

@Controller
@RequestMapping("/calculates")
public class CalculatesServlet {

	Constants constant = new Constants();

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {

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
		List<Client> clients = base.getClientsSortedByName();
		
		//servlet logic
	
		String day0 = getComfortDateForPagr(0);
		String day1 = getComfortDateForPagr(1);
		String day2 = getComfortDateForPagr(2);
		String day3 = getComfortDateForPagr(3);
		String day4 = getComfortDateForPagr(4);
		String day5 = getComfortDateForPagr(5);
		String day6 = getComfortDateForPagr(6);
		
		String countDay6 = getDayFromCount(6);
		
		List<Calculates> week = new ArrayList();
		
		if(rank==0){
			week = base.getListOfCalculatesFromDateByManagerId(countDay6, id);
		}else{
		    week = base.getListOfCalculatesFromDate(countDay6);
		}
		
		Calendar calendar = Calendar.getInstance();
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
		int year = calendar.get(Calendar.YEAR); 
		
		int dayOfYear0 = dayOfYear-0;
		int dayOfYear1 = dayOfYear-1;
		int dayOfYear2 = dayOfYear-2;
		int dayOfYear3 = dayOfYear-3;
		int dayOfYear4 = dayOfYear-4;
		int dayOfYear5 = dayOfYear-5;
		int dayOfYear6 = dayOfYear-6;
		
		List<Calculates> listCalculates0 = new ArrayList();
		List<Calculates> listCalculates1 = new ArrayList();
		List<Calculates> listCalculates2 = new ArrayList();
		List<Calculates> listCalculates3 = new ArrayList();
		List<Calculates> listCalculates4 = new ArrayList();
		List<Calculates> listCalculates5 = new ArrayList();
		List<Calculates> listCalculates6 = new ArrayList();
		
		for(Calculates calc:week){
			  Calendar timeOfCalculation = Calendar.getInstance();
			  timeOfCalculation.setTime(calc.getDateofcalculate());
			  int calculationYear = timeOfCalculation.get(Calendar.YEAR);
			  int calculationDayOfYear = timeOfCalculation.get(Calendar.DAY_OF_YEAR);
			  
			  if(calculationYear==year){
				  if(dayOfYear0==calculationDayOfYear){
					  listCalculates0.add(calc);
				  }else if(dayOfYear1==calculationDayOfYear){
					  listCalculates1.add(calc);
				  }else if(dayOfYear2==calculationDayOfYear){
					  listCalculates2.add(calc);
				  }else if(dayOfYear3==calculationDayOfYear){
					  listCalculates3.add(calc);
				  }else if(dayOfYear4==calculationDayOfYear){
					  listCalculates4.add(calc);
				  }else if(dayOfYear5==calculationDayOfYear){
					  listCalculates5.add(calc);
				  }else if(dayOfYear6==calculationDayOfYear){
					  listCalculates6.add(calc);
				  }
				  
			  }
			
		}
		
		
		//servlet logic

		base.closeConnection();

		model.addAttribute("name", name);
		model.addAttribute("products", products);
		model.addAttribute("menuForHead", menuForHead);
		
		model.addAttribute("clients", clients);
		
		model.addAttribute("day0", day0);
		model.addAttribute("day1", day1);
		model.addAttribute("day2", day2);
		model.addAttribute("day3", day3);
		model.addAttribute("day4", day4);
		model.addAttribute("day5", day5);
		model.addAttribute("day6", day6);
		
		model.addAttribute("listCalculates0", listCalculates0);
		model.addAttribute("listCalculates1", listCalculates1);
		model.addAttribute("listCalculates2", listCalculates2);
		model.addAttribute("listCalculates3", listCalculates3);
		model.addAttribute("listCalculates4", listCalculates4);
		model.addAttribute("listCalculates5", listCalculates5);
		model.addAttribute("listCalculates6", listCalculates6);
		

		return "calculates";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		
		 HttpSession session = request.getSession();
			
		 int id = (Integer) session.getAttribute("id");
		 int rank = (Integer) session.getAttribute("rank");
		 String name = (String) session.getAttribute("name");
		
		 DataBaseController base = new DataBaseController();
		 
		 String menuForHead = "";
		 
		 if(rank == constant.MANAGER_RANK_MANAGER){

		 }else{

			 menuForHead = constant.MENU_FOR_HEAD;
		 }
		
		 List<Product> products = base.getListOfOpenProducts();
		 
		    String requestEnc = "ISO-8859-1";
			String clientEnc = request.getParameter("charset");
			if (clientEnc == null)
				clientEnc = "Cp1251";
			
			String idclient = request.getParameter("idclient");
			int clientid = Integer.parseInt(idclient);
			String company;
			if(clientid==0){
			company = "";
			}else{
			company = base.getClientById(clientid).getCompany();
			}
			String comments = request.getParameter("comments");
			if(comments==null){
				comments = "";
			}
			String weightString = request.getParameter("weight");
			int weight = Integer.parseInt(weightString);
			Date dateofcalculate = new Date();
			String freight = request.getParameter("freight");		
			String typetruck = request.getParameter("typetruck");
			String temperature = request.getParameter("temperature");
			if(temperature==null){
				temperature = "без режиму";
			}
			String adrCheck = request.getParameter("adr");
			String adr;
			if(adrCheck != null){
				adr = "ADR";
			}else{
				adr = "";
			}
			String countryfrom = request.getParameter("countryfrom");
			countryfrom = countryfrom.toUpperCase();
			String countryto = request.getParameter("countryto");
			countryto = countryto.toUpperCase();
			String cityfrom = request.getParameter("cityfrom");
			String cityto = request.getParameter("cityto");
			String budget = request.getParameter("budget");
			if(budget==null){
				budget = "";
			}
			String rate = request.getParameter("rate");	
			if(rate==null){
				rate = "";
			}
			String calculateonadate = request.getParameter("calculateonadate");
			
			String exportimport;
			
			if(countryfrom.equals("UA")&&countryto.equals("UA")){
				exportimport = "Ukraine";
			}else if(!countryfrom.equals("UA")&&!countryto.equals("UA")){
				exportimport = "Europe";
			}else if(countryto.equals("UA")){
				exportimport = "Import";
			}else{
				exportimport = "Export";
			}
			
			if (comments != null){
				try {
					comments = new String(comments.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (freight != null){
				try {
					freight = new String(freight.getBytes(requestEnc), clientEnc);
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
			
			if (temperature != null){
				try {
					temperature = new String(temperature.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (countryfrom != null){
				try {
					countryfrom = new String(countryfrom.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (countryto != null){
				try {
					countryto = new String(countryto.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (budget != null){
				try {
					budget = new String(budget.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (rate != null){
				try {
					rate = new String(rate.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			if (calculateonadate != null){
				try {
					calculateonadate = new String(calculateonadate.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (cityfrom != null){
				try {
					cityfrom = new String(cityfrom.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			if (cityto != null){
				try {
					cityto = new String(cityto.getBytes(requestEnc), clientEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}
			
			
			
			Calculates calculate = new Calculates();
			calculate.setCompany(company);
			calculate.setCompanyid(clientid);
			calculate.setManager(name);
			calculate.setManagerid(id);
			calculate.setComments(comments);
			calculate.setWeight(weight);
			calculate.setDateofcalculate(dateofcalculate);
			calculate.setFreight(freight);
			calculate.setTruck(typetruck);
			calculate.setTemperature(temperature);
			calculate.setDangerous(adr);
			calculate.setCountryfrom(countryfrom);
			calculate.setCountryto(countryto);
			calculate.setCityfrom(cityfrom);
			calculate.setCityto(cityto);
			calculate.setBudget(budget);
			calculate.setRate(rate);
			calculate.setExportimport(exportimport);
			calculate.setCalculateonadate(calculateonadate);
			
			base.addCalculates(calculate);
				
			List<Client> clients = base.getClientsSortedByName();
			
			//servlet logic
		
			String day0 = getComfortDateForPagr(0);
			String day1 = getComfortDateForPagr(1);
			String day2 = getComfortDateForPagr(2);
			String day3 = getComfortDateForPagr(3);
			String day4 = getComfortDateForPagr(4);
			String day5 = getComfortDateForPagr(5);
			String day6 = getComfortDateForPagr(6);
			
			String countDay6 = getDayFromCount(6);
			
			List<Calculates> week = new ArrayList();
			
			if(rank==0){
				week = base.getListOfCalculatesFromDateByManagerId(countDay6, id);
			}else{
			    week = base.getListOfCalculatesFromDate(countDay6);
			}
			
			Calendar calendar = Calendar.getInstance();
			int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR); 
			int year = calendar.get(Calendar.YEAR); 
			
			int dayOfYear0 = dayOfYear-0;
			int dayOfYear1 = dayOfYear-1;
			int dayOfYear2 = dayOfYear-2;
			int dayOfYear3 = dayOfYear-3;
			int dayOfYear4 = dayOfYear-4;
			int dayOfYear5 = dayOfYear-5;
			int dayOfYear6 = dayOfYear-6;
			
			List<Calculates> listCalculates0 = new ArrayList();
			List<Calculates> listCalculates1 = new ArrayList();
			List<Calculates> listCalculates2 = new ArrayList();
			List<Calculates> listCalculates3 = new ArrayList();
			List<Calculates> listCalculates4 = new ArrayList();
			List<Calculates> listCalculates5 = new ArrayList();
			List<Calculates> listCalculates6 = new ArrayList();
			
			for(Calculates calc:week){
				  Calendar timeOfCalculation = Calendar.getInstance();
				  timeOfCalculation.setTime(calc.getDateofcalculate());
				  int calculationYear = timeOfCalculation.get(Calendar.YEAR);
				  int calculationDayOfYear = timeOfCalculation.get(Calendar.DAY_OF_YEAR);
				  
				  if(calculationYear==year){
					  if(dayOfYear0==calculationDayOfYear){
						  listCalculates0.add(calc);
					  }else if(dayOfYear1==calculationDayOfYear){
						  listCalculates1.add(calc);
					  }else if(dayOfYear2==calculationDayOfYear){
						  listCalculates2.add(calc);
					  }else if(dayOfYear3==calculationDayOfYear){
						  listCalculates3.add(calc);
					  }else if(dayOfYear4==calculationDayOfYear){
						  listCalculates4.add(calc);
					  }else if(dayOfYear5==calculationDayOfYear){
						  listCalculates5.add(calc);
					  }else if(dayOfYear6==calculationDayOfYear){
						  listCalculates6.add(calc);
					  }
					  
				  }
				
			}
			
			
			//servlet logic

			base.closeConnection();

			model.addAttribute("name", name);
			model.addAttribute("products", products);
			model.addAttribute("menuForHead", menuForHead);
			
			model.addAttribute("clients", clients);
			
			model.addAttribute("day0", day0);
			model.addAttribute("day1", day1);
			model.addAttribute("day2", day2);
			model.addAttribute("day3", day3);
			model.addAttribute("day4", day4);
			model.addAttribute("day5", day5);
			model.addAttribute("day6", day6);
			
			model.addAttribute("listCalculates0", listCalculates0);
			model.addAttribute("listCalculates1", listCalculates1);
			model.addAttribute("listCalculates2", listCalculates2);
			model.addAttribute("listCalculates3", listCalculates3);
			model.addAttribute("listCalculates4", listCalculates4);
			model.addAttribute("listCalculates5", listCalculates5);
			model.addAttribute("listCalculates6", listCalculates6);
			

			return "calculates";
	}
	
	private String getComfortDateForPagr(int minusdays){
		
		Date date = new Date();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, -minusdays);
	    SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
	    String formatted = format1.format(calendar.getTime());
		
		return formatted;
	}
	
	private String getDayFromCount(int minusdays){
		
		Date date = new Date();
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DATE, -minusdays);
	    SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
	    String formatted = format1.format(calendar.getTime());
		
		return formatted;
	}

}
