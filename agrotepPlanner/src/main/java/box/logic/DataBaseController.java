package box.logic;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Client;
import box.model.Direction;
import box.model.History;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;
import box.service.ClientService;
import box.service.DirectionService;
import box.service.HistoryService;
import box.service.ManagerService;
import box.service.RouteService;
import box.service.TruckService;



public class DataBaseController {
	
	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");	
	TruckService truckService = (TruckService) ctx
			.getBean("truckService");
	ClientService clientService = (ClientService) ctx
			.getBean("clientService");
	DirectionService directionService = (DirectionService) ctx
			.getBean("directionService");
	HistoryService historyService = (HistoryService) ctx
			.getBean("historyService");
	RouteService routeService = (RouteService) ctx
			.getBean("routeService");
	ManagerService managerService = (ManagerService) ctx
			.getBean("managerService");
	
	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	//truckTest
	public List<Truck> getListOfTrucks() {
		return truckService.getListOfTrucks();
	}
	//clientTest
	public List<Client> getListOfClients(){
		return clientService.getListOfClients();
	}
	//directionTest
	public List<Direction> getListOfDirections() {
		return directionService.getListOfDirections();
	}
	//historyTest
	public List<History> getListOfHistory() {
		return historyService.getListOfHistory();
	}
	//routeTest
	public List<Route> getListOfRoutes() {
		return routeService.getListOfRoutes();
	}
	
	//managerTest
	public List<Manager> getListOfManagers(){
		return managerService.getListOfManagers();
	}

}
