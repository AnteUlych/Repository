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
	
	public Truck getTruckbyId(int id){
		return truckService.getTruckbyId(id);
	}
	//truck
	
	//clientTest
	public List<Client> getListOfClients(){
		return clientService.getListOfClients();
	}
	//direction
	public List<Direction> getListOfDirectionsByOblastAndClientid(int clientId, String oblast) {
		return directionService.getListOfDirectionsByOblastAndClientid(clientId, oblast);
	}

	public boolean isClientHasOblastFromByDirection(int clientId, String oblast){
		return directionService.isClientHasOblastFromByDirection(clientId, oblast);
	}
	
	//history
	public List<History> getListOfHistory() {
		return historyService.getListOfHistory();
	}
	
	public void addHistory(History history){
		historyService.addHistory(history);
	}
	
	//route
	public List<Route> getListOfRoutesBetweenDatesByTruckId(int truckid, String start, String finish) {
		return routeService.getListOfRoutesBetweenDatesByTruckId(truckid, start, finish);
	}
	
	public boolean isListOfRoutesBetweenDatesByTruckIdExist(int truckid, String start, String finish) {
		return routeService.isListOfRoutesBetweenDatesByTruckIdExist(truckid, start, finish);
	}
	
	public Route getLastRouteByTruckId(int truckid, String finish){
		return routeService.getLastRouteByTruckId(truckid, finish);
	}
	
	public Route getLastRouteBetweenDatesByTruckId(int truckid, String start, String finish) {
		return routeService.getLastRouteBetweenDatesByTruckId(truckid, start, finish);
	}
	
	public void addRoute(Route route){
		routeService.addRoute(route);
	}
	
	public void deleteRoute(int id) {
		routeService.deleteRoute(id);
	}
	
	public Route getRouteById(int id){
		return routeService.getRouteById(id);
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
