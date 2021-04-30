package box.logic;

import java.util.Date;
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
	
	//truck
	public List<Truck> getListOfTrucksSortedByManager() {
		return truckService.getListOfTrucksSortedByManager();
	}
	
	public void editTruckPriorityToHighById(int id) {
		truckService.editTruckPriorityToHighById(id);
	}
	
	public void editTruckPriorityToRegularById(int id) {
		truckService.editTruckPriorityToRegularById(id);
	}
	
	public void editTruckCommentById(int id, String comment) {
		truckService.editTruckCommentById(id, comment);
	}
	//truck
	
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
	
	//route
	public List<Route> getListOfRoutesBetweenDatesByTruckId(int truckid, String start, String finish) {
		return routeService.getListOfRoutesBetweenDatesByTruckId(truckid, start, finish);
	}
	
	public boolean isListOfRoutesBetweenDatesByTruckIdExist(int truckid, String start, String finish) {
		return routeService.isListOfRoutesBetweenDatesByTruckIdExist(truckid, start, finish);
	}
	//route
	
	//manager
	public boolean isManagerExisByLoginPass(String loginPass){
		return managerService.isManagerExisByLoginPass(loginPass);
	}
	
	public Manager getManagersByLoginPass(String loginPass) {
		return managerService.getManagersByLoginPass(loginPass);
	}
	//manager

}
