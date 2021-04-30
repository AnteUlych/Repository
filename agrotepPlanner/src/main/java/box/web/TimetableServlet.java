package box.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.model.Truck;

@Controller
@RequestMapping("/timetable")
public class TimetableServlet {
	
	String checked = "checked";
	String weekendColour = "w3-pale-red";

	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) {

		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		int filterMy = (Integer) session.getAttribute("filterMy");
		int filterRemont = (Integer) session.getAttribute("filterRemont");
		int filterUrgent = (Integer) session.getAttribute("filterUrgent");
		int filterNotClosed = (Integer) session.getAttribute("filterNotClosed");
		
		String htmlFilterMy = "";
		String htmlFilterRemont = "";
		String htmlFilterUrgent = "";
		String htmlFilterNotClosed = "";
		
		if(filterMy==1){
			htmlFilterMy = checked;
		}
		if(filterRemont==1){
			htmlFilterRemont = checked;
		}
		if(filterUrgent==1){
			htmlFilterUrgent = checked;
		}
		if(filterNotClosed==1){
			htmlFilterNotClosed = checked;
		}
		
		CalendarLogic calendar = new CalendarLogic();
		
		String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		String thirdDay = calendar.getNeedoneDayForDataBasePlusDays(2);
		String fourthDay = calendar.getNeedoneDayForDataBasePlusDays(3);
		String fifthDay = calendar.getNeedoneDayForDataBasePlusDays(4);
		
		String firstTableHeadDay = calendar.getHeaderDate(firstDay);
		String secondTableHeadDay = calendar.getHeaderDate(secondDay);
		String thirdTableHeadDay = calendar.getHeaderDate(thirdDay);
		String fourthTableHeadDay = calendar.getHeaderDate(fourthDay);
		String fifthTableHeadDay = calendar.getHeaderDate(fifthDay);
		
		
		DataBaseController base = new DataBaseController();
		List <Truck> trucks = base.getListOfTrucksSortedByManager();
		
		
		if(filterMy==Constants.FILTER_TRUE){
			for(Truck truck:trucks){
				if(truck.getId()==id){
					trucks.remove(truck);
				}
			}
		}
		
		if(filterRemont==Constants.FILTER_TRUE){
			for(Truck truck:trucks){
				if(truck.getNotReady()==Constants.TRUCK_NOT_READY){
					trucks.remove(truck);
				}
			}
		}
		
		if(filterUrgent==Constants.FILTER_TRUE){
			for(Truck truck:trucks){
				if(truck.getPriority()==Constants.TRUCK_PRIORITY_REGULAR){
					trucks.remove(truck);
				}
			}
		}
		
		
		if(filterNotClosed==Constants.FILTER_TRUE){			
			for(Truck truck:trucks){
				if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)){
					trucks.remove(truck);
				}
			}
		}
		
		boolean weekendHeadFirstDay = calendar.isDayTheWeekend(firstDay);
		boolean weekendHeadSecondDay = calendar.isDayTheWeekend(secondDay);
		boolean weekendHeadThirdDay = calendar.isDayTheWeekend(thirdDay);
		boolean weekendHeadFourthDay = calendar.isDayTheWeekend(fourthDay);
		boolean weekendHeadFifthDay = calendar.isDayTheWeekend(fifthDay);
	
		String weekendStringHeadFirstDay = "";
		String weekendStringHeadSecondDay = "";
		String weekendStringHeadThirdDay = "";
		String weekendStringHeadFourthDay = "";
		String weekendStringHeadFifthDay = "";
		
		if(weekendHeadFirstDay){
			weekendStringHeadFirstDay = weekendColour;
		}
		if(weekendHeadSecondDay){
			weekendStringHeadSecondDay = weekendColour;
		}
		if(weekendHeadThirdDay){
			weekendStringHeadThirdDay = weekendColour;
		}
		if(weekendHeadFourthDay){
			weekendStringHeadFourthDay = weekendColour;
		}
		if(weekendHeadFifthDay){
			weekendStringHeadFifthDay = weekendColour;
		}
		
		//filter done without checking
		// total information with dates
		
		
		
		model.addAttribute("name", name);
		
		model.addAttribute("htmlFilterMy", htmlFilterMy);
		model.addAttribute("htmlFilterRemont", htmlFilterRemont);
		model.addAttribute("htmlFilterUrgent", htmlFilterUrgent);
		model.addAttribute("htmlFilterNotClosed", htmlFilterNotClosed);
		
		model.addAttribute("firstTableHeadDay", firstTableHeadDay);
		model.addAttribute("secondTableHeadDay", secondTableHeadDay);
		model.addAttribute("thirdTableHeadDay", thirdTableHeadDay);
		model.addAttribute("fourthTableHeadDay", fourthTableHeadDay);
		model.addAttribute("fifthTableHeadDay", fifthTableHeadDay);
		
		model.addAttribute("weekendStringHeadFirstDay", weekendStringHeadFirstDay);
		model.addAttribute("weekendStringHeadSecondDay", weekendStringHeadSecondDay);
		model.addAttribute("weekendStringHeadThirdDay", weekendStringHeadThirdDay);
		model.addAttribute("weekendStringHeadFourthDay", weekendStringHeadFourthDay);
		model.addAttribute("weekendStringHeadFifthDay", weekendStringHeadFifthDay);
		
		return "timetable";
	}

}
