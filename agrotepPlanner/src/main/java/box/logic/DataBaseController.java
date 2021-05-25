package box.logic;

import java.util.Date;
import java.util.List;
import java.util.Random;

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
	
	public List<Truck> getListOfReadyTrucksSortedByManager() {
		return truckService.getListOfReadyTrucksSortedByManager();
	}
	
	public void editTruckById(int id, String driver, int managerid, int notReady, String phone, String tracktor, String trailer, String type, String managerName) {
		truckService.editTruckById(id, driver, managerid, notReady, phone, tracktor, trailer, type, managerName);
	}
	
	public void addTruck(Truck truck){
		truckService.addTruck(truck);
	}
	
	public Truck gettruckByTracktorAndTrailer(String tracktor, String trailer) {
		return truckService.gettruckByTracktorAndTrailer(tracktor, trailer);
	}
	
	public boolean isManagerHasTruck(int managerid){
		return truckService.isManagerHasTruck(managerid);
	}
	//truck
	
	//client
	public List<Client> getListOfClients(){
		return clientService.getListOfClients();
	}
	
	public void addClient(Client client) {
		clientService.addClient(client);
	}
	
	public int getClientIdByCode(String code){
		return clientService.getClientIdByCode(code);
	}
	
	public boolean isClientExistbyCode(String code){
		return clientService.isClientExistbyCode(code);
	}
	
	public Client getClientById(int id){
		return clientService.getClientById(id);
	}
	
	public void editClientById(int id, int blacklist, String cargo, String company, String contactPerson, String email, String otherInfo, String payment, String phone, String season, String transportVolume, String typetruck, String warning){
		clientService.editClientById(id, blacklist, cargo, company, contactPerson, email, otherInfo, payment, phone, season, transportVolume, typetruck, warning);
	}
	
	//direction
	public List<Direction> getListOfDirectionsByOblastAndClientid(int clientId, String oblast) {
		return directionService.getListOfDirectionsByOblastAndClientid(clientId, oblast);
	}

	public boolean isClientHasOblastFromByDirection(int clientId, String oblast){
		return directionService.isClientHasOblastFromByDirection(clientId, oblast);
	}
	
	public List<Direction> getListOfDirectionsByClientId(int clientId){
		return directionService.getListOfDirectionsByClientId(clientId);
	}
	
	public void deleteDirection(int id) {
		directionService.deleteDirection(id);
	}
	
	public void addDirection(Direction direction) {
		directionService.addDirection(direction);
	}
	
	//history
	public List<History> getListOfHistory() {
		return historyService.getListOfHistory();
	}
	
	public void addHistory(History history){
		historyService.addHistory(history);
	}
	
	public List<History> getListOfHistoryByManageridBetweenDatesReverse(String start, String finish, int managerid) {
		return historyService.getListOfHistoryByManageridBetweenDatesReverse(start, finish, managerid);
	}
	
	public List<History> getListOfHistoryByActionAndManageridBetweenDates(String start, String finish, int managerid, int action) {
		return historyService.getListOfHistoryByActionAndManageridBetweenDates(start, finish, managerid, action);
	}
	
	public List<History> getListOfHistoryByManageridBetweenDates(String start, String finish, int managerid) {
		return historyService.getListOfHistoryByManageridBetweenDates(start, finish, managerid);
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
	
	public List<Route> getListOfRoutesByRouteStatusBetweenDates(int routeStatus, String start, String finish){
		return routeService.getListOfRoutesByRouteStatusBetweenDates(routeStatus, start, finish);
	}
	//route
	
	//manager
	public boolean isManagerExisByLoginPass(String loginPass){
		return managerService.isManagerExisByLoginPass(loginPass);
	}
	
	public Manager getManagersByLoginPass(String loginPass) {
		return managerService.getManagersByLoginPass(loginPass);
	}
	
	public List<Manager> getListOfManagers(){
		return managerService.getListOfManagers();
	}
	
	public Manager getManagerById(int id){
		return managerService.getManagerById(id);
	}
	
	public Manager getManagersByName(String name) {
		return managerService.getManagersByName(name);
	}
	
	public void addManager(Manager manager){
		managerService.addManager(manager);
	}
	
	public void deleteManagerById(int managerid) {
		managerService.deleteManagerById(managerid);
	}
	
	public void editCodeManagerById(int id, String code) {
		managerService.editCodeManagerById(id, code);
	}
	
	public String createPassword(){
		String code;
		
		for(;;){
			
			int min = 1000;
			int max = 9999;
	
			Random random = new Random();
			int i = random.nextInt((max-min)+1)+ min;
			code = i+"";
		
			if(!managerService.isManagerExisByLoginPass(code)){
				return code;
			}
		}
	}

	//manager

}
