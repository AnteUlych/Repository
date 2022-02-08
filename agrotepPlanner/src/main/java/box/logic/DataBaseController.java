package box.logic;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import box.model.Client;
import box.model.Direction;
import box.model.Documents;
import box.model.Garant;
import box.model.History;
import box.model.Manager;
import box.model.Maplink;
import box.model.Route;
import box.model.Truck;
import box.service.ClientService;
import box.service.DirectionService;
import box.service.DocumentsService;
import box.service.GarantService;
import box.service.HistoryService;
import box.service.ManagerService;
import box.service.MaplinkService;
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
	MaplinkService maplinkService = (MaplinkService)ctx
			.getBean("maplinkService");
	DocumentsService documentsService = (DocumentsService) ctx
			.getBean("documentsService");
	GarantService garantService = (GarantService) ctx
			.getBean("garantService");
	
	public void closeConnection() {
		((AbstractApplicationContext) ctx).close();
	}
	
	//garant
	
	public List<Garant> getListOfGarants(){
		return garantService.getListOfGarants();
	}
	
	public void addGarant(Garant garant){
		garantService.addGarant(garant);
	}
	
	public void deleteGarantById(int id) {
		garantService.deleteGarantById(id);
	}
	
	public void editGarantById(int id, String truckandmanager, String color, Date plandate) {
		garantService.editGarantById(id, truckandmanager, color, plandate);
	}
	
	public Garant getGarantById(int id){
		return garantService.getGarantById(id);
	}
	
	//garant
	
	//documents
	public void addDocuments(Documents documents) {
		documentsService.addDocuments(documents);
	}
	
	public List<Documents> getListOfDocumentsWithStatus(String status){
		return documentsService.getListOfDocumentsWithStatus(status);
	}
	
	public List<Documents> getListOfDocumentsWithStatusByResponsibleId(String status, int responsibleid){
		return documentsService.getListOfDocumentsWithStatusByResponsibleId(status, responsibleid);
	}
	
	public void editDocumentsById(int id, Date datesolvving, String status, String color){
		documentsService.editDocumentsById(id, datesolvving, status, color);
	}
	
	public void editDocumentsLogistcomentById(int id, String logistcoment){
		documentsService.editDocumentsLogistcomentById(id, logistcoment);
	}
	
	//documents
	
	//maplink
	public Maplink getMaplinkById(int id) {
		return maplinkService.getMaplinkById(id);
	}
	
	public void editMaplinkById(int id, String link) {
		maplinkService.editMaplinkById(id, link);
	}
	//maplink
	
	//truck
	public List<Truck> getListOfReadyTrucksByManagerId(int managerid) {
		return truckService.getListOfReadyTrucksByManagerId(managerid);
	}
	
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
	
	public void editTruckById(int id, String driver, int managerid, int notReady, String phone, String tracktor, String trailer, String type, String managerName, String truckKey) {
		truckService.editTruckById(id, driver, managerid, notReady, phone, tracktor, trailer, type, managerName, truckKey);
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
	
	public void editTruckKmruptela0131tById(int id, int kmruptela0131, double uahkmruptela0131) {
		truckService.editTruckKmruptela0131tById(id, kmruptela0131, uahkmruptela0131);
	}
	
	public void editTruckNoremontdaysById(int id, int noremontdays) {
		truckService.editTruckNoremontdaysById(id, noremontdays);
	}
	
	public boolean isManagerHasReadyTruck(int managerid){
		return truckService.isManagerHasReadyTruck(managerid);
	}
	//truck
	
	//client
	public Client getClientByCompany(String company){
		return clientService.getClientByCompany(company);
	}
	
	public List<Client> getListOfClients(){
		return clientService.getListOfClients();
	}
	
	public List<Client> getListOfOrderClients(){
		return clientService.getListOfOrderClients();
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
	
	public void editClientById(int id, int blacklist, String cargo, String company, String contactPerson, String email, String otherInfo, String payment, String phone, String season, String transportVolume, String typetruck, String warning, String driverInstruction){
		clientService.editClientById(id, blacklist, cargo, company, contactPerson, email, otherInfo, payment, phone, season, transportVolume, typetruck, warning, driverInstruction);
	}
	
	public List<Client> getListOfClientsByOblastFtomAndOblastTo(String oblastFrom, String oblastTo){
		List<Client> clients = clientService.getListOfClients();
		List<Client> needClients = new ArrayList();
		
		for(Client c:clients){
			if(!directionService.isClientNotWorkByOblastFromAndOblastTo(oblastFrom, oblastTo, c.getId())){
				needClients.add(c);
			}			
		}
		
		return needClients;
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
	
	public boolean isClientNotWorkByOblastFromAndOblastTo(String oblastFrom, String oblastTo, int clientId) {
		return directionService.isClientNotWorkByOblastFromAndOblastTo(oblastFrom, oblastTo, clientId);
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
    
	public List<Route> getListOfRoutesBetweenDatesByTruckIdForHistory(int truckid, String start, String finish) {
		return routeService.getListOfRoutesBetweenDatesByTruckIdForHistory(truckid, start, finish);
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
	
	public String getCircleParametrByRoutes(int truckid, String finish){
		List<Route> routes = routeService.getLastTenRoutesByTruckId(truckid, finish);		
		int distence = 1;
		int price = 0;
        int count = 0;
		
		for(Route r:routes){
		
			if(r.getRouteStatus()==0){
				//hidden
			//System.out.println(r.getFromDate()+" "+r.getFromOblast()+" - "+r.getToOblast()+" "+r.getPrice()+" ãðí "+r.getKilometrs()+" km");
			//hidden
            distence = distence + r.getKilometrs();
			price = price + r.getPrice();
			count++;
			}
			if(r.getFromOblast().contains("Êè¿â")){
				break;
			}

		}
		
		int uahForKm = price/distence;
				
		return uahForKm+" ãðí/êì ("+count+")";
	}
	
	public List<Route> getListOfRoutesForCircle(int truckid, String finish){
		List<Route> routes = routeService.getLastTenRoutesByTruckId(truckid, finish);		
		List<Route> needRoutes = new ArrayList();
		for(Route r:routes){
		
			if(r.getRouteStatus()==0){ //can`t remember right constant
			needRoutes.add(r);
			
			if(r.getFromOblast().contains("Êè¿â")){
				break;
			}
			}
		}
			
		return needRoutes;
	}
	
	//changed from 30 mounth to o1 of each mounth
	public double getMounthUAHforKMByTruckId(int truckid, int km){
		
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.setTime(today);
		c1.setTime(today);
		//c.add(Calendar.MONTH, -1);
		c.set(Calendar.DAY_OF_MONTH, 1);
		//c1.add(Calendar.DATE, 1);
		Date tomorrow = c1.getTime();
		Date mounthAgo = c.getTime();
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String start = formatter.format(mounthAgo);
		String finish = formatter.format(tomorrow);
		
		List<Route> routes = routeService.getListOfRoutesBetweenDatesByTruckIdForHistory(truckid, start, finish);
		
		int uah = 0;
		
		for(Route r:routes){
			uah = uah + r.getPrice();	
		}
		
		double UAHforKm = (int)(Math.round((double)uah/((double)km) * 100))/100.0; 

		if(km==1){
			UAHforKm = 0;
		}
		
		return UAHforKm;
	}
	

	public int getMounthKm(String truckKey){
		
		Date today = new Date();
		Calendar c = Calendar.getInstance();
		Calendar c1 = Calendar.getInstance();
		c.setTime(today);
		c1.setTime(today);
	
		c.set(Calendar.DAY_OF_MONTH, 1);
		//c1.add(Calendar.DATE, 0);  // today
		Date tomorrow = c1.getTime();
		Date mounthAgo = c.getTime();
		
		Format formatter = new SimpleDateFormat("yyyy-MM-dd");
		String start = formatter.format(mounthAgo);
		String finish = formatter.format(tomorrow); //today
		
		RuptelaLogic ruptela = new RuptelaLogic();
		int km = ruptela.getKmFromRuptela(start, finish, truckKey);
		
		if(km==0){
			km=1;
		}
		
		/**
		List<Route> routes = routeService.getListOfRoutesBetweenDatesByTruckIdForHistory(truckid, start, finish);

		int km = 1;
		
		for(Route r:routes){
			km = km + r.getKilometrs();		
		}
		double doublekm = km*1.05;     //correction by 5% 
		int resultkm = (int)doublekm; //correction by 5% 
		return resultkm;              //correction by 5% 
		*/
		
		return km;
	}
	
	public int getHowManyDaysAgoTruckWasInService(int truckid, String finish){
		
		try {	
			
	    List<Route> routes = routeService.getLastRemontRouteByTruckId(truckid, finish);
	    
	    if(routes.size()==0){
	    	return 99;
	    }
	    
	    Route r =routes.get(0);
	  
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date remontDate = r.getFromDate();        
	    String dateOfRemont = sdf.format(remontDate);
	    		
	    Date firstDate = sdf.parse(finish);
	    Date secondDate = sdf.parse(dateOfRemont);
			

	    long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    int days = (int) diff;
	    	
	    return days;
	    
	    } catch (ParseException e) {
					e.printStackTrace();
		}
		return 0;
	}
	
	
	//test route
	public List<Route> getLastTenRoutesByTruckId(int truckid, String finish){
		return routeService.getLastTenRoutesByTruckId(truckid, finish);
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
