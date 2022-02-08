package box.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import box.logic.CalendarLogic;
import box.logic.Constants;
import box.logic.DataBaseController;
import box.logic.RuptelaLogic;
import box.model.HistoryHTML;
import box.model.Manager;
import box.model.Route;
import box.model.Statistic;
import box.model.StatisticKPI;
import box.model.Truck;

@Controller
@RequestMapping("/statistic")
public class StatisticServlet {
	
	@RequestMapping(method = RequestMethod.GET)
	public String doGet(ModelMap model, HttpServletRequest request) throws ParseException {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		CalendarLogic calendar = new CalendarLogic();
		
		String start = calendar.getFirstDateOfThatMounth();
		String finish = calendar.getNeedoneDayForDataBasePlusDays(0);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	    		
	    Date firstDate = sdf.parse(start);
	    Date secondDate = sdf.parse(finish);
			

	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    int days = (int) diff;
			
		DataBaseController base = new DataBaseController(); 
 		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
			HistoryHTML histories = new HistoryHTML();
			
			histories.setDriver(t.getDriver());
			histories.setManagerName(t.getManagerName());
			histories.setType(t.getType());
			histories.setTracktor(t.getTracktor());
			histories.setTrailer(t.getTrailer());
			
			List<Route> routes = base.getListOfRoutesBetweenDatesByTruckId(t.getId(), start, finish);
			
			histories.setRoutes(routes);
			
			int totalUAH = 0; 
			int totalStops = 0;
			int totalColona = 0;
			int totalRemont = 0;
			int totalWork = 0;
			
			for(Route r:routes){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				dateText.add(datetext);
			
				if(r.getRouteStatus()!=Constants.TRUCK_REPEAT){
				totalUAH = totalUAH + r.getPrice(); 
				}
				
				if(r.getRouteStatus()==Constants.TRUCK_NOT_READY){
					totalStops=totalStops+1;
				} 
				if(r.getRouteStatus()==Constants.TRUCK_COLONA){
					totalColona=totalColona+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_REMOMT){
					totalRemont=totalRemont+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_READY||r.getRouteStatus()==Constants.TRUCK_REPEAT){
					totalWork = totalWork+1;
				}
			}
			
			RuptelaLogic ruptela = new RuptelaLogic();
			int totalKm = ruptela.getKmFromRuptela(start, finish, t.getTruckKey());
			
			double totalUAHforKm = (int)(Math.round((double)totalUAH/(double)totalKm * 100))/100.0; 
			
			histories.setTotalUAHforKm(totalUAHforKm); 
			histories.setTotalUAH(totalUAH); 
			histories.setTotalKm(totalKm);
			histories.setDates(dateText);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			histories.setTotalWork(totalWork);
		   
			   trucksHTML.add(histories);
			
		}
		
		//before was history and no start statistic
		
		//trucksKPI
		
		List<StatisticKPI> trucksKPI = new ArrayList();
		
		StatisticKPI refKPI = calculateKPIbyTruckType(days, trucksHTML, "реф");
		StatisticKPI tiltKPI = calculateKPIbyTruckType(days, trucksHTML, "тент");
		StatisticKPI boxKPI = calculateKPIbyTruckType(days, trucksHTML, "цільномет");
		
		trucksKPI.add(refKPI);
		trucksKPI.add(tiltKPI);
		trucksKPI.add(boxKPI);
		
		
		//total KPI
		
		StatisticKPI totalKPI = new StatisticKPI(); 
		
		int kmtotal = 0;
		double uahkmtotal = 0;
		//int kmday = 0;
		 
    	int totalStopstotal = 0;
		int totalColonatotal = 0;
		int totalRemonttotal = 0;
		//int percentLogisticColonaRemomt = 0;
		//int percentLogisticNoStops = 0;
		
		int totalWorktotal = 0;
		int counttotal = 0;
		int countOfTruckstotal = base.getListOfReadyTrucksSortedByManager().size();
		int lackGPSError = 0;
		
		for(HistoryHTML th : trucksHTML){
				
			counttotal++;
			
			kmtotal = kmtotal+th.getTotalKm();
			uahkmtotal = uahkmtotal+th.getTotalUAHforKm();
			totalStopstotal = totalStopstotal+th.getTotalStops();
			totalColonatotal= totalColonatotal + th.getTotalColona();
			totalRemonttotal = totalRemonttotal + th.getTotalRemont();
			totalWorktotal = totalWorktotal + th.getTotalWork();
			if(th.getTotalKm()<5){
				lackGPSError++;
			}
		}
		
		if(counttotal==0){
			totalKPI.setIndicator("");
			totalKPI.setKm(0);
			totalKPI.setKmday(0);
			totalKPI.setTotalColona(totalColonatotal);
			totalKPI.setTotalRemont(totalRemonttotal);
			totalKPI.setTotalStops(totalStopstotal);
			totalKPI.setTotalWork(totalWorktotal);
			totalKPI.setUahkm(0);

			double percentLogisticColonaRemomt = 0;
			double percentPercentLogisticNoStops = 0;
			
            if((totalStopstotal+totalWorktotal)>0||(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal)>0){
    			percentLogisticColonaRemomt = 100*((double)totalWorktotal/(double)(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal));
    			percentPercentLogisticNoStops = 100*((double)totalWorktotal/(double)(totalStopstotal+totalWorktotal));	
            }
            totalKPI.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
    		totalKPI.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
			totalKPI.setTrucks(0);
			
		}else{
		
		
		totalKPI.setIndicator("");
		
		if(counttotal-lackGPSError!=0){
		totalKPI.setKm(kmtotal/(counttotal-lackGPSError));
		totalKPI.setUahkm((Math.round((double)uahkmtotal/(double)(counttotal-lackGPSError) * 100))/100.0);
		}else{
			totalKPI.setKm(0);
			totalKPI.setUahkm(0);
		}
		totalKPI.setKmday(kmtotal/(days-totalColonatotal-totalRemonttotal));
		totalKPI.setTotalColona(totalColonatotal);
		totalKPI.setTotalRemont(totalRemonttotal);
		totalKPI.setTotalStops(totalStopstotal);
		totalKPI.setTotalWork(totalWorktotal);
		
		double percentLogisticColonaRemomttotal = 100*((double)totalWorktotal/(double)(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal));
		double percentPercentLogisticNoStopstotal = 100*((double)totalWorktotal/(double)(totalStopstotal+totalWorktotal));
		totalKPI.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomttotal);
		totalKPI.setPercentLogisticNoStops((int)percentPercentLogisticNoStopstotal);
		totalKPI.setTrucks(countOfTruckstotal);
		}
		//managers KPI
		
		List<Manager> managers = base.getListOfManagers();  
		List<StatisticKPI> managersKPI = new ArrayList();
		
		for(Manager m:managers){
			if(base.isManagerHasReadyTruck(m.getId())){

				int km = 0;
				double uahkm = 0;
				//int kmday = 0;
				 
	        	int totalStops = 0;
				int totalColona = 0;
				int totalRemont = 0;
				//int percentLogisticColonaRemomt = 0;
				//int percentLogisticNoStops = 0;
				
				int totalWork = 0;
				int count = 0;
				int countOfTrucks = base.getListOfReadyTrucksByManagerId(m.getId()).size();
				
				int lackGPSError1 = 0;
				
				StatisticKPI managerKpi = new StatisticKPI();
				
				for(HistoryHTML th : trucksHTML){
					if(th.getManagerName().equals(m.getName())){
						
					count++;
					
					km = km+th.getTotalKm();
					uahkm = uahkm+th.getTotalUAHforKm();
					totalStops = totalStops+th.getTotalStops();
					totalColona = totalColona + th.getTotalColona();
					totalRemont = totalRemont + th.getTotalRemont();
					totalWork = totalWork + th.getTotalWork();
					if(th.getTotalKm()<5){
						lackGPSError1++;
					}
				}
				}
				if(count==0){
					managerKpi.setIndicator(m.getName());
					managerKpi.setKm(0);
					managerKpi.setKmday(0);
					managerKpi.setTotalColona(totalColona);
					managerKpi.setTotalRemont(totalRemont);
					managerKpi.setTotalStops(totalStops);
					managerKpi.setTotalWork(totalWork);
					managerKpi.setUahkm(0);
					
					double percentLogisticColonaRemomt = 0;
					double percentPercentLogisticNoStops = 0;
					
		            if((totalStops+totalWork)>0||(totalStops+totalColona+totalRemont+totalWork)>0){
		    			percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
		    			percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));	
		            }

		            
		            managerKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
		            managerKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
		            managerKpi.setTrucks(count);
				}else{
				
				
				managerKpi.setIndicator(m.getName());
				if(count-lackGPSError1!=0){
					managerKpi.setKm(km/(count-lackGPSError1));
					managerKpi.setUahkm((Math.round((double)uahkm/(double)(count-lackGPSError1) * 100))/100.0);
				}else{
					managerKpi.setKm(0);
					managerKpi.setUahkm(0);
				}
				
				managerKpi.setKmday(km/(days-totalColona-totalRemont));
				managerKpi.setTotalColona(totalColona);
				managerKpi.setTotalRemont(totalRemont);
				managerKpi.setTotalStops(totalStops);
				managerKpi.setTotalWork(totalWork);
				
				double percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
				double percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));
				managerKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
				managerKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
				managerKpi.setTrucks(countOfTrucks);
				
				managersKPI.add(managerKpi);
				}
			}
		}
		
		
		
		//other from here
	
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		model.addAttribute("managersKPI", managersKPI);
		model.addAttribute("totalKPI", totalKPI);
		model.addAttribute("trucksKPI", trucksKPI);
		
		return "statistic";
		
		
	}



	@RequestMapping(method = RequestMethod.POST)
	public String doPost(ModelMap model, HttpServletRequest request, HttpServletResponse response)throws ParseException {
		
		HttpSession session = request.getSession();
		String name = (String) session.getAttribute("name");
		
		CalendarLogic calendar = new CalendarLogic();
		
		String start = request.getParameter("start");
		String finish = request.getParameter("finish");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	    		
	    Date firstDate = sdf.parse(start);
	    Date secondDate = sdf.parse(finish);
			

	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    int days = (int) diff;
			
		DataBaseController base = new DataBaseController(); 
 		
		List<Truck> trucks = base.getListOfReadyTrucksSortedByManager();
		List<HistoryHTML> trucksHTML = new ArrayList();
		
		
		for(Truck t:trucks){
			List<String> dateText = new ArrayList();
			HistoryHTML histories = new HistoryHTML();
			
			histories.setDriver(t.getDriver());
			histories.setManagerName(t.getManagerName());
			histories.setType(t.getType());
			histories.setTracktor(t.getTracktor());
			histories.setTrailer(t.getTrailer());
			
			List<Route> routes = base.getListOfRoutesBetweenDatesByTruckId(t.getId(), start, finish);
			
			histories.setRoutes(routes);
			
			int totalUAH = 0; 
			int totalStops = 0;
			int totalColona = 0;
			int totalRemont = 0;
			int totalWork = 0;
			
			for(Route r:routes){
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String s = formatter.format(r.getFromDate());			
				String datetext = calendar.getHeaderDate(s);
				dateText.add(datetext);
			
				if(r.getRouteStatus()!=Constants.TRUCK_REPEAT){
				totalUAH = totalUAH + r.getPrice(); 
				}
				
				if(r.getRouteStatus()==Constants.TRUCK_NOT_READY){
					totalStops=totalStops+1;
				} 
				if(r.getRouteStatus()==Constants.TRUCK_COLONA){
					totalColona=totalColona+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_REMOMT){
					totalRemont=totalRemont+1;
				}
				if(r.getRouteStatus()==Constants.TRUCK_READY||r.getRouteStatus()==Constants.TRUCK_REPEAT){
					totalWork = totalWork+1;
				}
			}
			
			RuptelaLogic ruptela = new RuptelaLogic();
			int totalKm = ruptela.getKmFromRuptela(start, finish, t.getTruckKey());
			
			double totalUAHforKm = (int)(Math.round((double)totalUAH/(double)totalKm * 100))/100.0; 
			
			histories.setTotalUAHforKm(totalUAHforKm); 
			histories.setTotalUAH(totalUAH); 
			histories.setTotalKm(totalKm);
			histories.setDates(dateText);
			histories.setTotalStops(totalStops);
			histories.setTotalColona(totalColona);
			histories.setTotalRemont(totalRemont);
			histories.setTotalWork(totalWork);
		   
			   trucksHTML.add(histories);
			
		}
		
		//before was history and no start statistic
		
		//trucksKPI
		
		List<StatisticKPI> trucksKPI = new ArrayList();
		
		StatisticKPI refKPI = calculateKPIbyTruckType(days, trucksHTML, "реф");
		StatisticKPI tiltKPI = calculateKPIbyTruckType(days, trucksHTML, "тент");
		StatisticKPI boxKPI = calculateKPIbyTruckType(days, trucksHTML, "цільномет");
		
		trucksKPI.add(refKPI);
		trucksKPI.add(tiltKPI);
		trucksKPI.add(boxKPI);
		
		
		//total KPI
		
		StatisticKPI totalKPI = new StatisticKPI(); 
		
		int kmtotal = 0;
		double uahkmtotal = 0;
		//int kmday = 0;
		 
    	int totalStopstotal = 0;
		int totalColonatotal = 0;
		int totalRemonttotal = 0;
		//int percentLogisticColonaRemomt = 0;
		//int percentLogisticNoStops = 0;
		
		int totalWorktotal = 0;
		int counttotal = 0;
		int countOfTruckstotal = base.getListOfReadyTrucksSortedByManager().size();
		int lackGPSError = 0;
		
		for(HistoryHTML th : trucksHTML){
				
			counttotal++;
			
			kmtotal = kmtotal+th.getTotalKm();
			uahkmtotal = uahkmtotal+th.getTotalUAHforKm();
			totalStopstotal = totalStopstotal+th.getTotalStops();
			totalColonatotal= totalColonatotal + th.getTotalColona();
			totalRemonttotal = totalRemonttotal + th.getTotalRemont();
			totalWorktotal = totalWorktotal + th.getTotalWork();
			if(th.getTotalKm()<5){
				lackGPSError++;
			}
		}
		
		if(counttotal==0){
			totalKPI.setIndicator("");
			totalKPI.setKm(0);
			totalKPI.setKmday(0);
			totalKPI.setTotalColona(totalColonatotal);
			totalKPI.setTotalRemont(totalRemonttotal);
			totalKPI.setTotalStops(totalStopstotal);
			totalKPI.setTotalWork(totalWorktotal);
			totalKPI.setUahkm(0);

			double percentLogisticColonaRemomt = 0;
			double percentPercentLogisticNoStops = 0;
			
            if((totalStopstotal+totalWorktotal)>0||(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal)>0){
    			percentLogisticColonaRemomt = 100*((double)totalWorktotal/(double)(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal));
    			percentPercentLogisticNoStops = 100*((double)totalWorktotal/(double)(totalStopstotal+totalWorktotal));	
            }
            totalKPI.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
    		totalKPI.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
			totalKPI.setTrucks(0);
			
		}else{
		
		
		totalKPI.setIndicator("");
		
		if(counttotal-lackGPSError!=0){
		totalKPI.setKm(kmtotal/(counttotal-lackGPSError));
		totalKPI.setUahkm((Math.round((double)uahkmtotal/(double)(counttotal-lackGPSError) * 100))/100.0);
		}else{
			totalKPI.setKm(0);
			totalKPI.setUahkm(0);
		}
		totalKPI.setKmday(kmtotal/(days-totalColonatotal-totalRemonttotal));
		totalKPI.setTotalColona(totalColonatotal);
		totalKPI.setTotalRemont(totalRemonttotal);
		totalKPI.setTotalStops(totalStopstotal);
		totalKPI.setTotalWork(totalWorktotal);
		
		double percentLogisticColonaRemomttotal = 100*((double)totalWorktotal/(double)(totalStopstotal+totalColonatotal+totalRemonttotal+totalWorktotal));
		double percentPercentLogisticNoStopstotal = 100*((double)totalWorktotal/(double)(totalStopstotal+totalWorktotal));
		totalKPI.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomttotal);
		totalKPI.setPercentLogisticNoStops((int)percentPercentLogisticNoStopstotal);
		totalKPI.setTrucks(countOfTruckstotal);
		}
		//managers KPI
		
		List<Manager> managers = base.getListOfManagers();  
		List<StatisticKPI> managersKPI = new ArrayList();
		
		for(Manager m:managers){
			if(base.isManagerHasReadyTruck(m.getId())){

				int km = 0;
				double uahkm = 0;
				//int kmday = 0;
				 
	        	int totalStops = 0;
				int totalColona = 0;
				int totalRemont = 0;
				//int percentLogisticColonaRemomt = 0;
				//int percentLogisticNoStops = 0;
				
				int totalWork = 0;
				int count = 0;
				int countOfTrucks = base.getListOfReadyTrucksByManagerId(m.getId()).size();
				
				int lackGPSError1 = 0;
				
				StatisticKPI managerKpi = new StatisticKPI();
				
				for(HistoryHTML th : trucksHTML){
					if(th.getManagerName().equals(m.getName())){
						
					count++;
					
					km = km+th.getTotalKm();
					uahkm = uahkm+th.getTotalUAHforKm();
					totalStops = totalStops+th.getTotalStops();
					totalColona = totalColona + th.getTotalColona();
					totalRemont = totalRemont + th.getTotalRemont();
					totalWork = totalWork + th.getTotalWork();
					if(th.getTotalKm()<5){
						lackGPSError1++;
					}
				}
				}
				if(count==0){
					managerKpi.setIndicator(m.getName());
					managerKpi.setKm(0);
					managerKpi.setKmday(0);
					managerKpi.setTotalColona(totalColona);
					managerKpi.setTotalRemont(totalRemont);
					managerKpi.setTotalStops(totalStops);
					managerKpi.setTotalWork(totalWork);
					managerKpi.setUahkm(0);
					
					double percentLogisticColonaRemomt = 0;
					double percentPercentLogisticNoStops = 0;
					
		            if((totalStops+totalWork)>0||(totalStops+totalColona+totalRemont+totalWork)>0){
		    			percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
		    			percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));	
		            }

		            
		            managerKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
		            managerKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
		            managerKpi.setTrucks(count);
				}else{
				
				
				managerKpi.setIndicator(m.getName());
				if(count-lackGPSError1!=0){
					managerKpi.setKm(km/(count-lackGPSError1));
					managerKpi.setUahkm((Math.round((double)uahkm/(double)(count-lackGPSError1) * 100))/100.0);
				}else{
					managerKpi.setKm(0);
					managerKpi.setUahkm(0);
				}
				
				managerKpi.setKmday(km/(days-totalColona-totalRemont));
				managerKpi.setTotalColona(totalColona);
				managerKpi.setTotalRemont(totalRemont);
				managerKpi.setTotalStops(totalStops);
				managerKpi.setTotalWork(totalWork);
				
				double percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
				double percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));
				managerKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
				managerKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
				managerKpi.setTrucks(countOfTrucks);
				
				managersKPI.add(managerKpi);
				}
			}
		}
		
		
		
		//other from here
	
		
		base.closeConnection();
		
		model.addAttribute("name", name);
		
		model.addAttribute("start", start);
		model.addAttribute("finish", finish);
		
		model.addAttribute("managersKPI", managersKPI);
		model.addAttribute("totalKPI", totalKPI);
		model.addAttribute("trucksKPI", trucksKPI);
		
		return "statistic";
		
		
	}
	
	private StatisticKPI calculateKPIbyTruckType(int days, List<HistoryHTML> trucksHTML,
			String typeOftruck) {
		int km = 0;
		double uahkm = 0;
		//int kmday = 0;
		 
    	int totalStops = 0;
		int totalColona = 0;
		int totalRemont = 0;
		//int percentLogisticColonaRemomt = 0;
		//int percentLogisticNoStops = 0;
		
		int totalWork = 0;
		int count = 0;
		//int countOfTrucks = 0;
		int lackGPSError = 0;
		
		StatisticKPI truckKpi = new StatisticKPI();
		
		for(HistoryHTML th : trucksHTML){
			if(th.getType().equals(typeOftruck)){
				
			count++;
			
			km = km+th.getTotalKm();
			uahkm = uahkm+th.getTotalUAHforKm();
			totalStops = totalStops+th.getTotalStops();
			totalColona = totalColona + th.getTotalColona();
			totalRemont = totalRemont + th.getTotalRemont();
			totalWork = totalWork + th.getTotalWork();
			if(th.getTotalKm()<5){
				lackGPSError++;
			}
		}
		}
		
		if(count==0){
			truckKpi.setIndicator(typeOftruck);
			truckKpi.setKm(0);
			truckKpi.setKmday(0);
			truckKpi.setTotalColona(totalColona);
			truckKpi.setTotalRemont(totalRemont);
			truckKpi.setTotalStops(totalStops);
			truckKpi.setTotalWork(totalWork);
			truckKpi.setUahkm(0);
			
			double percentLogisticColonaRemomt = 0;
			double percentPercentLogisticNoStops = 0;
			
            if((totalStops+totalWork)>0||(totalStops+totalColona+totalRemont+totalWork)>0){
    			percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
    			percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));	
            }

            
			truckKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
			truckKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
			truckKpi.setTrucks(count);
			
			return truckKpi;
		}
		
		truckKpi.setIndicator(typeOftruck);
		if(count-lackGPSError!=0){
			truckKpi.setKm(km/(count-lackGPSError));
			truckKpi.setUahkm((Math.round((double)uahkm/(double)(count-lackGPSError) * 100))/100.0);
		}else{
			truckKpi.setKm(0);
			truckKpi.setUahkm(0);
		}
		
		
		truckKpi.setKmday(km/(days-totalColona-totalRemont));
		truckKpi.setTotalColona(totalColona);
		truckKpi.setTotalRemont(totalRemont);
		truckKpi.setTotalStops(totalStops);
		truckKpi.setTotalWork(totalWork);
		
		double percentLogisticColonaRemomt = 100*((double)totalWork/(double)(totalStops+totalColona+totalRemont+totalWork));
		double percentPercentLogisticNoStops = 100*((double)totalWork/(double)(totalStops+totalWork));
		truckKpi.setPercentLogisticColonaRemomt((int)percentLogisticColonaRemomt);
		truckKpi.setPercentLogisticNoStops((int)percentPercentLogisticNoStops);
		truckKpi.setTrucks(count);
	
		return truckKpi;
	}
}
