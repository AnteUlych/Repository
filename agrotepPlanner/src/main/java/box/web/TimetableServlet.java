package box.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import box.logic.RuptelaLogic;
import box.model.CalendarTruckHtml;
import box.model.Route;
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
		int filterUrgent = (Integer) session.getAttribute("filterUrgent");
		int filterNotClosed = (Integer) session.getAttribute("filterNotClosed");
		int filterNextDayNotClosed = (Integer) session.getAttribute("filterNextDayNotClosed"); //filterNextDayNotClosed
		
		String htmlFilterMy = "";
		String htmlFilterRemont = "";
		String htmlFilterUrgent = "";
		String htmlFilterNotClosed = "";
		String htmlFilterNextDayNotClosed = ""; //filterNextDayNotClosed
		
		if(filterMy==Constants.FILTER_TRUE){
			htmlFilterMy = checked;
		}

		if(filterUrgent==Constants.FILTER_TRUE){
			htmlFilterUrgent = checked;
		}
		if(filterNotClosed==Constants.FILTER_TRUE){
			htmlFilterNotClosed = checked;
		}
		
		//filterNextDayNotClosed
		if(filterNextDayNotClosed==Constants.FILTER_TRUE){ 
			htmlFilterNextDayNotClosed = checked;  
		} 
		//filterNextDayNotClosed
		
		CalendarLogic calendar = new CalendarLogic();
		
		String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		String thirdDay = calendar.getNeedoneDayForDataBasePlusDays(2);
		String fourthDay = calendar.getNeedoneDayForDataBasePlusDays(3);
		String fifthDay = calendar.getNeedoneDayForDataBasePlusDays(4);
		String sixthDay = calendar.getNeedoneDayForDataBasePlusDays(5);
		
		String firstTableHeadDay = calendar.getHeaderDate(firstDay);
		String secondTableHeadDay = calendar.getHeaderDate(secondDay);
		String thirdTableHeadDay = calendar.getHeaderDate(thirdDay);
		String fourthTableHeadDay = calendar.getHeaderDate(fourthDay);
		String fifthTableHeadDay = calendar.getHeaderDate(fifthDay);
		
		
		DataBaseController base = new DataBaseController();
		List <Truck> trucks = base.getListOfReadyTrucksSortedByManager();
			
		if(filterMy==Constants.FILTER_TRUE){
			List <Truck> trucksForRemoveFilterMy = new ArrayList();
			for(Truck truck:trucks){
				if((truck.getManagerid())!=id&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterMy.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterMy);	
		}
		
	
		if(filterUrgent==Constants.FILTER_TRUE){
			List <Truck> trucksForRemoveFilterUrgent = new ArrayList();
			for(Truck truck:trucks){
				if(truck.getPriority()==Constants.TRUCK_PRIORITY_REGULAR){
					trucksForRemoveFilterUrgent.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterUrgent);
		}
		
		
		if(filterNotClosed==Constants.FILTER_TRUE){	
			List <Truck> trucksForRemoveFilterNotClosed = new ArrayList();
			for(Truck truck:trucks){
				if((base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay))&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterNotClosed.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterNotClosed);
		}
		//filterNextDayNotClosed
		if(filterNextDayNotClosed==Constants.FILTER_TRUE){	
			List <Truck> trucksForRemoveFilterNotClosed = new ArrayList();
			for(Truck truck:trucks){
				if((base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), secondDay, thirdDay))&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterNotClosed.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterNotClosed);
		}
		//filterNextDayNotClosed
		
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
		
		
		List<CalendarTruckHtml> htmlTrucks = new ArrayList();
		
		for(Truck truck:trucks){
			CalendarTruckHtml htmlTruck = new CalendarTruckHtml();
			
			htmlTruck.setId(truck.getId());
			htmlTruck.setTracktor(truck.getTracktor());
			htmlTruck.setTrailer(truck.getTrailer());
			htmlTruck.setDriver(truck.getDriver());
			htmlTruck.setPhone(truck.getPhone());
			htmlTruck.setType(truck.getType());
			htmlTruck.setManagerName(truck.getManagerName());
			htmlTruck.setManagerid(truck.getManagerid());
			htmlTruck.setPriority(truck.getPriority());
			htmlTruck.setNotReady(truck.getNotReady());
			htmlTruck.setStatusTruck(truck.getStatusTruck());
			htmlTruck.setComment(truck.getComment());
			
		
			int mounthKm = truck.getKmruptela0131();
			double mounthUAHforKm = truck.getUahkmruptela0131();
			htmlTruck.setMounthUAHforKm(mounthUAHforKm);
			htmlTruck.setMounthKm(mounthKm);
			
			int noremontdays = truck.getNoremontdays();
			htmlTruck.setNoremontdays(noremontdays);
			
			if(truck.getPriority()==Constants.TRUCK_PRIORITY_HIGH){
				htmlTruck.setColumnUrgentClass("checked");
				htmlTruck.setColumnUrgentColorClass("w3-lime");
			}
			
			if(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH){
				htmlTruck.setColumnUrgentClass("");
				htmlTruck.setColumnUrgentColorClass("");
			}
			
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)){
				htmlTruck.setFromOblastStatusStyle("color:green");
				htmlTruck.setFromLastOblast(base.getLastRouteByTruckId(truck.getId(), secondDay).getFromCity()+" -> "+base.getLastRouteByTruckId(truck.getId(), secondDay).getToCity());
			
			}else{
				htmlTruck.setFromOblastStatusStyle("color:red");
				htmlTruck.setFromLastOblast(base.getLastRouteByTruckId(truck.getId(), secondDay).getToCity());
			
			}
			
		     //test from to Oblasts
			
			//first day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), firstDay, secondDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day1Link ="/planner/route/"+truck.getId()+"&"+firstDay+"&"+secondDay;
					
					htmlTruck.setDay1Link(day1Link);
					htmlTruck.setDay1(day1);
				}else{
					//fixing
					
					String day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					
					String day1Link ="/planner/route/"+truck.getId()+"&"+firstDay+"&"+secondDay;
					
					htmlTruck.setDay1Link(day1Link);
					htmlTruck.setDay1(day1);
				}
			}else{
                   //empty space
				String day1 = "";
				
				String day1Link ="/planner/newRoute/"+truck.getId()+"&"+firstDay+"&"+secondDay;
				
				htmlTruck.setDay1Link(day1Link);
				htmlTruck.setDay1(day1);
			}
			
			//second day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), secondDay, thirdDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), secondDay, thirdDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day2Link ="/planner/route/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
					
					htmlTruck.setDay2Link(day2Link);
					htmlTruck.setDay2(day2);
				}else{
					//fixing
					
					String day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day2Link ="/planner/route/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
					
					htmlTruck.setDay2Link(day2Link);
					htmlTruck.setDay2(day2);
				}
			}else{
                   //empty space
				String day2 = "";
				
				String day2Link ="/planner/newRoute/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
				
				htmlTruck.setDay2Link(day2Link);
				htmlTruck.setDay2(day2);
			}
			
			//third day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), thirdDay, fourthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), thirdDay, fourthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day3Link ="/planner/route/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
					
					htmlTruck.setDay3Link(day3Link);
					htmlTruck.setDay3(day3);
				}else{
					//fixing
					
					String day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day3Link ="/planner/route/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
					
					htmlTruck.setDay3Link(day3Link);
					htmlTruck.setDay3(day3);
				}
			}else{
                   //empty space
				String day3 = "";
				
				String day3Link ="/planner/newRoute/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
				
				htmlTruck.setDay3Link(day3Link);
				htmlTruck.setDay3(day3);
			}
			
			/**
			//fourth
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), fourthDay, fifthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), fourthDay, fifthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day4Link ="/planner/route/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
					
					htmlTruck.setDay4Link(day4Link);
					htmlTruck.setDay4(day4);
				}else{
					//fixing
					
					String day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day4Link ="/planner/route/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
					
					htmlTruck.setDay4Link(day4Link);
					htmlTruck.setDay4(day4);
				}
			}else{
                   //empty space
				String day4 = "";
				
				String day4Link ="/planner/newRoute/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
				
				htmlTruck.setDay4Link(day4Link);
				htmlTruck.setDay4(day4);
			}
			
			//fifth
			
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), fifthDay, sixthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), fifthDay, sixthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day5Link ="/planner/route/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
					
					htmlTruck.setDay5Link(day5Link);
					htmlTruck.setDay5(day5);
				}else{
					//fixing
					
					String day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day5Link ="/planner/route/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
					
					htmlTruck.setDay5Link(day5Link);
					htmlTruck.setDay5(day5);
				}
			}else{
                   //empty space
				String day5 = "";
				
				String day5Link ="/planner/newRoute/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
				
				htmlTruck.setDay5Link(day5Link);
				htmlTruck.setDay5(day5);
			}
			*/
			
			htmlTrucks.add(htmlTruck);
			
		}
		
		base.closeConnection();
	
		model.addAttribute("name", name);
		
		model.addAttribute("htmlFilterMy", htmlFilterMy);
		model.addAttribute("htmlFilterRemont", htmlFilterRemont);
		model.addAttribute("htmlFilterUrgent", htmlFilterUrgent);
		model.addAttribute("htmlFilterNotClosed", htmlFilterNotClosed);
		model.addAttribute("htmlFilterNextDayNotClosed", htmlFilterNextDayNotClosed); //filterNextDayNotClosed
		
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
		
		model.addAttribute("htmlTrucks", htmlTrucks);
		
		return "timetable";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();

		int id = (Integer) session.getAttribute("id");
		int status = (Integer) session.getAttribute("status");
		String name = (String) session.getAttribute("name");
		
		int filterMy = (Integer) session.getAttribute("filterMy");
		int filterUrgent = (Integer) session.getAttribute("filterUrgent");
		int filterNotClosed = (Integer) session.getAttribute("filterNotClosed");
		int filterNextDayNotClosed = (Integer) session.getAttribute("filterNextDayNotClosed"); //filterNextDayNotClosed
		
		DataBaseController base = new DataBaseController();
		
		
		//post checkbox urgent
		List <Truck> trucksUrgent = base.getListOfReadyTrucksSortedByManager();
		
		//if((request.getParameter("checkMy") != null)&&(request.getParameter("checkMy") != null)&&(request.getParameter("checkMy") != null)){
		for(Truck truck:trucksUrgent){
			
			if((request.getParameter("checkUrgentBox"+truck.getId()) != null)&&(truck.getPriority()==Constants.TRUCK_PRIORITY_REGULAR)){
					base.editTruckPriorityToHighById(truck.getId());	
				}else if((request.getParameter("checkUrgentBox"+truck.getId()) == null)&&(truck.getPriority()==Constants.TRUCK_PRIORITY_HIGH)){
					base.editTruckPriorityToRegularById(truck.getId());
				}
			
			if(request.getParameter("button"+truck.getId()) != null){
				
				String requestEnc = "ISO-8859-1";
				String clientEnc = request.getParameter("charset");
				if (clientEnc == null)
					clientEnc = "Cp1251";
				
				String comment = request.getParameter("newComment"+truck.getId());
				
				if (comment != null){
					try {
						comment = new String(comment.getBytes(requestEnc), clientEnc);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}else{
					comment = "";
				}
				
				base.editTruckCommentById(truck.getId(), comment);
			}
					
		}
	
		//post checkbox urgent
		
		
		//post from here
		if((request.getParameter("checkMy") != null)&&(filterMy==Constants.FILTER_FALSE)){
				filterMy=Constants.FILTER_TRUE;
			}else if((request.getParameter("checkMy") == null)&&(filterMy==Constants.FILTER_TRUE)){
				filterMy=Constants.FILTER_FALSE;
			}
		
		if((request.getParameter("checkUrgent") != null)&&(filterUrgent==Constants.FILTER_FALSE)){
			filterUrgent=Constants.FILTER_TRUE;
		}else if((request.getParameter("checkUrgent") == null)&&(filterUrgent==Constants.FILTER_TRUE)){
			filterUrgent=Constants.FILTER_FALSE;
		}
	
		if((request.getParameter("checkNotClosed") != null)&&(filterNotClosed==Constants.FILTER_FALSE)){
			filterNotClosed=Constants.FILTER_TRUE;
		}else if((request.getParameter("checkNotClosed") == null)&&(filterNotClosed==Constants.FILTER_TRUE)){
			filterNotClosed=Constants.FILTER_FALSE;
		}
		
		//filterNextDayNotClosed
		if((request.getParameter("checkNextDayNotClosed") != null)&&(filterNextDayNotClosed==Constants.FILTER_FALSE)){
			filterNextDayNotClosed=Constants.FILTER_TRUE;
		}else if((request.getParameter("checkNextDayNotClosed") == null)&&(filterNextDayNotClosed==Constants.FILTER_TRUE)){
			filterNextDayNotClosed=Constants.FILTER_FALSE;
		}
		//filterNextDayNotClosed
		
		//post from here
		
		String htmlFilterMy = "";
		String htmlFilterRemont = "";
		String htmlFilterUrgent = "";
		String htmlFilterNotClosed = "";
		String htmlFilterNextDayNotClosed = ""; //filterNextDayNotClosed
		
		if(filterMy==Constants.FILTER_TRUE){
			htmlFilterMy = checked;
		}

		if(filterUrgent==Constants.FILTER_TRUE){
			htmlFilterUrgent = checked;
		}
		if(filterNotClosed==Constants.FILTER_TRUE){
			htmlFilterNotClosed = checked;
		}
		
		//filterNextDayNotClosed
		if(filterNextDayNotClosed==Constants.FILTER_TRUE){ 
			htmlFilterNextDayNotClosed = checked;  
		} 
		//filterNextDayNotClosed
		
		CalendarLogic calendar = new CalendarLogic();
		
		String firstDay = calendar.getNeedoneDayForDataBasePlusDays(0);
		String secondDay = calendar.getNeedoneDayForDataBasePlusDays(1);
		String thirdDay = calendar.getNeedoneDayForDataBasePlusDays(2);
		String fourthDay = calendar.getNeedoneDayForDataBasePlusDays(3);
		String fifthDay = calendar.getNeedoneDayForDataBasePlusDays(4);
		String sixthDay = calendar.getNeedoneDayForDataBasePlusDays(5);
		
		String firstTableHeadDay = calendar.getHeaderDate(firstDay);
		String secondTableHeadDay = calendar.getHeaderDate(secondDay);
		String thirdTableHeadDay = calendar.getHeaderDate(thirdDay);
		String fourthTableHeadDay = calendar.getHeaderDate(fourthDay);
		String fifthTableHeadDay = calendar.getHeaderDate(fifthDay);
		
		
	
		
		
		
		List <Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		
		
		
		if(filterMy==Constants.FILTER_TRUE){
			List <Truck> trucksForRemoveFilterMy = new ArrayList();
			for(Truck truck:trucks){
				if((truck.getManagerid()!=id)&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterMy.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterMy);	
		}
		
				
		if(filterUrgent==Constants.FILTER_TRUE){
			List <Truck> trucksForRemoveFilterUrgent = new ArrayList();
			for(Truck truck:trucks){
				if(truck.getPriority()==Constants.TRUCK_PRIORITY_REGULAR){
					trucksForRemoveFilterUrgent.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterUrgent);
		}
		
		
		if(filterNotClosed==Constants.FILTER_TRUE){	
			List <Truck> trucksForRemoveFilterNotClosed = new ArrayList();
			for(Truck truck:trucks){
				if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterNotClosed.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterNotClosed);
		}
		
		//filterNextDayNotClosed
		if(filterNextDayNotClosed==Constants.FILTER_TRUE){	
			List <Truck> trucksForRemoveFilterNotClosed = new ArrayList();
			for(Truck truck:trucks){
				if((base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), secondDay, thirdDay))&&(truck.getPriority()!=Constants.TRUCK_PRIORITY_HIGH)){
					trucksForRemoveFilterNotClosed.add(truck);
				}
			}
			trucks.removeAll(trucksForRemoveFilterNotClosed);
		}
		//filterNextDayNotClosed
		
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
		
		
		List<CalendarTruckHtml> htmlTrucks = new ArrayList();
		
		for(Truck truck:trucks){
			CalendarTruckHtml htmlTruck = new CalendarTruckHtml();
			
			htmlTruck.setId(truck.getId());
			htmlTruck.setTracktor(truck.getTracktor());
			htmlTruck.setTrailer(truck.getTrailer());
			htmlTruck.setDriver(truck.getDriver());
			htmlTruck.setPhone(truck.getPhone());
			htmlTruck.setType(truck.getType());
			htmlTruck.setManagerName(truck.getManagerName());
			htmlTruck.setManagerid(truck.getManagerid());
			htmlTruck.setPriority(truck.getPriority());
			htmlTruck.setNotReady(truck.getNotReady());
			htmlTruck.setStatusTruck(truck.getStatusTruck());
			htmlTruck.setComment(truck.getComment());
			
		
			int mounthKm = truck.getKmruptela0131();
			double mounthUAHforKm = truck.getUahkmruptela0131();
			htmlTruck.setMounthUAHforKm(mounthUAHforKm);
			htmlTruck.setMounthKm(mounthKm);
			
			int noremontdays = truck.getNoremontdays();
			htmlTruck.setNoremontdays(noremontdays);
			
			if(truck.getPriority()==Constants.TRUCK_PRIORITY_HIGH){
				htmlTruck.setColumnUrgentClass("checked");
				htmlTruck.setColumnUrgentColorClass("w3-lime");
			}else if(truck.getPriority()==Constants.TRUCK_PRIORITY_REGULAR){
				htmlTruck.setColumnUrgentClass("");
				htmlTruck.setColumnUrgentColorClass("");
			}
			
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)){
				htmlTruck.setFromOblastStatusStyle("color:green");
				htmlTruck.setFromLastOblast(base.getLastRouteByTruckId(truck.getId(), secondDay).getFromCity()+" -> "+base.getLastRouteByTruckId(truck.getId(), secondDay).getToCity());
			
			}else{
				htmlTruck.setFromOblastStatusStyle("color:red");
				htmlTruck.setFromLastOblast(base.getLastRouteByTruckId(truck.getId(), secondDay).getToCity());
				
			}
			
		     //test from to Oblasts
			
			//first day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), firstDay, secondDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), firstDay, secondDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day1Link ="/planner/route/"+truck.getId()+"&"+firstDay+"&"+secondDay;
					
					htmlTruck.setDay1Link(day1Link);
					htmlTruck.setDay1(day1);
				}else{
					//fixing
					
					String day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day1 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day1Link ="/planner/route/"+truck.getId()+"&"+firstDay+"&"+secondDay;
					
					htmlTruck.setDay1Link(day1Link);
					htmlTruck.setDay1(day1);
				}
			}else{
                   //empty space
				String day1 = "";
				
				String day1Link ="/planner/newRoute/"+truck.getId()+"&"+firstDay+"&"+secondDay;
				
				htmlTruck.setDay1Link(day1Link);
				htmlTruck.setDay1(day1);
			}
			
			//second day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), secondDay, thirdDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), secondDay, thirdDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day2Link ="/planner/route/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
					
					htmlTruck.setDay2Link(day2Link);
					htmlTruck.setDay2(day2);
				}else{
					//fixing
					
					String day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day2 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day2Link ="/planner/route/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
					
					htmlTruck.setDay2Link(day2Link);
					htmlTruck.setDay2(day2);
				}
			}else{
                   //empty space
				String day2 = "";
				
				String day2Link ="/planner/newRoute/"+truck.getId()+"&"+secondDay+"&"+thirdDay;
				
				htmlTruck.setDay2Link(day2Link);
				htmlTruck.setDay2(day2);
			}
			
			//third day
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), thirdDay, fourthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), thirdDay, fourthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day3Link ="/planner/route/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
					
					htmlTruck.setDay3Link(day3Link);
					htmlTruck.setDay3(day3);
				}else{
					//fixing
					
					String day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day3 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day3Link ="/planner/route/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
					
					htmlTruck.setDay3Link(day3Link);
					htmlTruck.setDay3(day3);
				}
			}else{
                   //empty space
				String day3 = "";
				
				String day3Link ="/planner/newRoute/"+truck.getId()+"&"+thirdDay+"&"+fourthDay;
				
				htmlTruck.setDay3Link(day3Link);
				htmlTruck.setDay3(day3);
			}
			/**
			//fourth
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), fourthDay, fifthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), fourthDay, fifthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day4Link ="/planner/route/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
					
					htmlTruck.setDay4Link(day4Link);
					htmlTruck.setDay4(day4);
				}else{
					//fixing
					
					String day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day4 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day4Link ="/planner/route/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
					
					htmlTruck.setDay4Link(day4Link);
					htmlTruck.setDay4(day4);
				}
			}else{
                   //empty space
				String day4 = "";
				
				String day4Link ="/planner/newRoute/"+truck.getId()+"&"+fourthDay+"&"+fifthDay;
				
				htmlTruck.setDay4Link(day4Link);
				htmlTruck.setDay4(day4);
			}
			
			//fifth
			
			if(base.isListOfRoutesBetweenDatesByTruckIdExist(truck.getId(), fifthDay, sixthDay)){
				Route route = base.getLastRouteBetweenDatesByTruckId(truck.getId(), fifthDay, sixthDay);
				if(route.getRouteStatus()==Constants.TRUCK_READY||route.getRouteStatus()==Constants.TRUCK_REPEAT){
					
					//inRoad					
					String day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-truck\" style=\"color:green\"><span class=\"tooltiptext\">"+
							route.getFromCity()+" - "+ route.getToCity()+",<br>"+ route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��"+
							"<br><br><button onclick=\"myFunctionAlert('"+"�� ����� ����: "+route.getDriverInstruction()+"')\" "+
					 "class=\"w3-button w3-padding-small w3-black\"><i style=\"color:white\" class=\"fa fa-skype\"></i></button>"+
							 "</span></i></center>";
					
					String day5Link ="/planner/route/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
					
					htmlTruck.setDay5Link(day5Link);
					htmlTruck.setDay5(day5);
				}else{
					//fixing
					
					String day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-hourglass-end\" style=\"color:red\"><span class=\"tooltiptext\">"+
							route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";
					
					if(route.getRouteStatus()==Constants.TRUCK_COLONA){
						day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-suitcase\" style=\"color:purple\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					if(route.getRouteStatus()==Constants.TRUCK_REMOMT){
						day5 = "<center><div class=\"tooltip\"><i class=\"fa fa-wrench\" style=\"color:blue\"><span class=\"tooltiptext\">"+
								route.getInfo()+ ",<br>"+route.getPiceForKilometr()+" ���/��</span></i></center>";	
					}
					
					String day5Link ="/planner/route/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
					
					htmlTruck.setDay5Link(day5Link);
					htmlTruck.setDay5(day5);
				}
			}else{
                   //empty space
				String day5 = "";
				
				String day5Link ="/planner/newRoute/"+truck.getId()+"&"+fifthDay+"&"+sixthDay;
				
				htmlTruck.setDay5Link(day5Link);
				htmlTruck.setDay5(day5);
			}
			*/
			
			htmlTrucks.add(htmlTruck);
			
		}
		
	
		base.closeConnection();
	
		model.addAttribute("name", name);
		
		model.addAttribute("htmlFilterMy", htmlFilterMy);
		model.addAttribute("htmlFilterRemont", htmlFilterRemont);
		model.addAttribute("htmlFilterUrgent", htmlFilterUrgent);
		model.addAttribute("htmlFilterNotClosed", htmlFilterNotClosed);
		model.addAttribute("htmlFilterNextDayNotClosed", htmlFilterNextDayNotClosed); //filterNextDayNotClosed
		
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
		
		model.addAttribute("htmlTrucks", htmlTrucks);
		
		session.setAttribute("filterMy", filterMy);
		session.setAttribute("filterUrgent", filterUrgent);
		session.setAttribute("filterNotClosed", filterNotClosed);

	
		return "timetable";
	}

}
