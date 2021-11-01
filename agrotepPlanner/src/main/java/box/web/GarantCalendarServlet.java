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

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Garant;

@Controller
@RequestMapping("/garantcalendar")
public class GarantCalendarServlet {

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
        CalendarLogic calendar = new CalendarLogic();
		
		String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		String thirdDay = calendar.getNeedoneDayForDataBasePlusDays(2);
		String fourthDay = calendar.getNeedoneDayForDataBasePlusDays(3);
		String fifthDay = calendar.getNeedoneDayForDataBasePlusDays(4);
		String sixthDay = calendar.getNeedoneDayForDataBasePlusDays(5);
		String seventhDay = calendar.getNeedoneDayForDataBasePlusDays(6);
		
		String firstTableHeadDay = calendar.getHeaderDate(firstDay);
		String secondTableHeadDay = calendar.getHeaderDate(secondDay);
		String thirdTableHeadDay = calendar.getHeaderDate(thirdDay);
		String fourthTableHeadDay = calendar.getHeaderDate(fourthDay);
		String fifthTableHeadDay = calendar.getHeaderDate(fifthDay);
		String sixthTableHeadDay = calendar.getHeaderDate(sixthDay);
		String seventhTableHeadDay = calendar.getHeaderDate(seventhDay);
		
		List<Garant> firstDayGarants = new ArrayList();
		List<Garant> secondDayGarants = new ArrayList();
		List<Garant> thirdDayGarants = new ArrayList();
		List<Garant> fourthDayGarants = new ArrayList();
		List<Garant> fifthDayGarants = new ArrayList();
		List<Garant> sixthDayGarants = new ArrayList();
		List<Garant> seventhDayGarants = new ArrayList();
		
		DataBaseController base = new DataBaseController();

		Calendar c = Calendar.getInstance();	
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
		Date rubiconDate = c.getTime();
		
		List<Garant> garantsCheckDates = base.getListOfGarants(); //check old dates
		for(Garant g:garantsCheckDates){
		if(g.getPlandate().before(rubiconDate)){		
			Calendar cal = Calendar.getInstance();
			cal.setTime(g.getPlandate());
			cal.add(Calendar.DATE, 7);
			Date nextPlanDate = cal.getTime();
			
			base.editGarantById(g.getId(), "", Constants.GARANTS_STATUS_NO_COLOR, nextPlanDate);
		}
		} 
		
		Calendar calendarToday = Calendar.getInstance();
		int firstDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int secondDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int thirdDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int fourthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int fifthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int sixthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int seventhDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		
		//check old dates
		
		List<Garant> garants = base.getListOfGarants();
		
		for(Garant g:garants){
			
			if(g.getDayofweek()==firstDate){
				firstDayGarants.add(g);
			}else 
			if(g.getDayofweek()==secondDate){
				secondDayGarants.add(g);
			}else 
		    if(g.getDayofweek()==thirdDate){
				thirdDayGarants.add(g);
			}else 
			if(g.getDayofweek()==fourthDate){
				fourthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==fifthDate){
				fifthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==sixthDate){
			    sixthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==seventhDate){
				seventhDayGarants.add(g);
			}
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("firstTableHeadDay", firstTableHeadDay);
		model.addAttribute("secondTableHeadDay", secondTableHeadDay);
		model.addAttribute("thirdTableHeadDay", thirdTableHeadDay);
		model.addAttribute("fourthTableHeadDay", fourthTableHeadDay);
		model.addAttribute("fifthTableHeadDay", fifthTableHeadDay);
		model.addAttribute("sixthTableHeadDay", sixthTableHeadDay);
		model.addAttribute("seventhTableHeadDay", seventhTableHeadDay);
		
		model.addAttribute("firstDayGarants", firstDayGarants);
		model.addAttribute("secondDayGarants", secondDayGarants);
		model.addAttribute("thirdDayGarants", thirdDayGarants);
		model.addAttribute("fourthDayGarants", fourthDayGarants);
		model.addAttribute("fifthDayGarants", fifthDayGarants);
		model.addAttribute("sixthDayGarants", sixthDayGarants);
		model.addAttribute("seventhDayGarants", seventhDayGarants);
		
		model.addAttribute("garants", garants);
				
		return "garantcalendar";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
        CalendarLogic calendar = new CalendarLogic();
		
		String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		String thirdDay = calendar.getNeedoneDayForDataBasePlusDays(2);
		String fourthDay = calendar.getNeedoneDayForDataBasePlusDays(3);
		String fifthDay = calendar.getNeedoneDayForDataBasePlusDays(4);
		String sixthDay = calendar.getNeedoneDayForDataBasePlusDays(5);
		String seventhDay = calendar.getNeedoneDayForDataBasePlusDays(6);
		
		String firstTableHeadDay = calendar.getHeaderDate(firstDay);
		String secondTableHeadDay = calendar.getHeaderDate(secondDay);
		String thirdTableHeadDay = calendar.getHeaderDate(thirdDay);
		String fourthTableHeadDay = calendar.getHeaderDate(fourthDay);
		String fifthTableHeadDay = calendar.getHeaderDate(fifthDay);
		String sixthTableHeadDay = calendar.getHeaderDate(sixthDay);
		String seventhTableHeadDay = calendar.getHeaderDate(seventhDay);
		
		List<Garant> firstDayGarants = new ArrayList();
		List<Garant> secondDayGarants = new ArrayList();
		List<Garant> thirdDayGarants = new ArrayList();
		List<Garant> fourthDayGarants = new ArrayList();
		List<Garant> fifthDayGarants = new ArrayList();
		List<Garant> sixthDayGarants = new ArrayList();
		List<Garant> seventhDayGarants = new ArrayList();
		
		DataBaseController base = new DataBaseController();
		
		String requestEnc = "ISO-8859-1";
		String clientEnc = request.getParameter("charset");
		if (clientEnc == null)
			clientEnc = "Cp1251";
		
	    //post
		
		List<Garant> garantsPost = base.getListOfGarants();
		for(Garant g:garantsPost){
			
			if(request.getParameter("give"+g.getId()) != null){				
				String truckandmanager = request.getParameter("truckandmanager"+g.getId());			
				if (truckandmanager != null){
					try {
						truckandmanager = new String(truckandmanager.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				if(truckandmanager == null){
					truckandmanager = "";
				}
					base.editGarantById(g.getId(), truckandmanager+" - "+name, "w3-green", g.getPlandate());
			
			}
			
			if(request.getParameter("noneed"+g.getId()) != null){
				base.editGarantById(g.getId(), "відміна", "w3-red", g.getPlandate());		
			}
		}
		
		//post

		Calendar c = Calendar.getInstance();	
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MILLISECOND, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MINUTE, 0);
		Date rubiconDate = c.getTime();
		
		List<Garant> garantsCheckDates = base.getListOfGarants(); //check old dates
		for(Garant g:garantsCheckDates){
		if(g.getPlandate().before(rubiconDate)){		
			Calendar cal = Calendar.getInstance();
			cal.setTime(g.getPlandate());
			cal.add(Calendar.DATE, 7);
			Date nextPlanDate = cal.getTime();
			
			base.editGarantById(g.getId(), "", Constants.GARANTS_STATUS_NO_COLOR, nextPlanDate);
		}
		} 
		
		Calendar calendarToday = Calendar.getInstance();
		int firstDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int secondDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int thirdDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int fourthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int fifthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int sixthDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		int seventhDate = calendarToday.get(Calendar.DAY_OF_WEEK);
		calendarToday.add(Calendar.DATE, 1);
		
		//check old dates
		
		List<Garant> garants = base.getListOfGarants();
		
		for(Garant g:garants){
			
			if(g.getDayofweek()==firstDate){
				firstDayGarants.add(g);
			}else 
			if(g.getDayofweek()==secondDate){
				secondDayGarants.add(g);
			}else 
		    if(g.getDayofweek()==thirdDate){
				thirdDayGarants.add(g);
			}else 
			if(g.getDayofweek()==fourthDate){
				fourthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==fifthDate){
				fifthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==sixthDate){
			    sixthDayGarants.add(g);
			}else 
			if(g.getDayofweek()==seventhDate){
				seventhDayGarants.add(g);
			}
		}
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("firstTableHeadDay", firstTableHeadDay);
		model.addAttribute("secondTableHeadDay", secondTableHeadDay);
		model.addAttribute("thirdTableHeadDay", thirdTableHeadDay);
		model.addAttribute("fourthTableHeadDay", fourthTableHeadDay);
		model.addAttribute("fifthTableHeadDay", fifthTableHeadDay);
		model.addAttribute("sixthTableHeadDay", sixthTableHeadDay);
		model.addAttribute("seventhTableHeadDay", seventhTableHeadDay);
		
		model.addAttribute("firstDayGarants", firstDayGarants);
		model.addAttribute("secondDayGarants", secondDayGarants);
		model.addAttribute("thirdDayGarants", thirdDayGarants);
		model.addAttribute("fourthDayGarants", fourthDayGarants);
		model.addAttribute("fifthDayGarants", fifthDayGarants);
		model.addAttribute("sixthDayGarants", sixthDayGarants);
		model.addAttribute("seventhDayGarants", seventhDayGarants);
		
		model.addAttribute("garants", garants);
				
		return "garantcalendar";
		
	}

}
