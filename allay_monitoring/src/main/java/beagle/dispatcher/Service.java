package beagle.dispatcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beagle.model.Booking;
import beagle.model.Client;
import beagle.model.Manager;
import beagle.service.AccessService;
import beagle.service.BookingService;
import beagle.service.ClientService;
import beagle.service.ManagerService;

public class Service {

	ApplicationContext ctx = (ApplicationContext) new ClassPathXmlApplicationContext(
			"spring.xml");
	
	ClientService clientService = (ClientService) ctx.getBean("clientService");
	BookingService bookingService = (BookingService) ctx.getBean("bookingService");
	
	public List<String> getAllClients() {	
		return clientService.getAllClients();
	}
	public List<Client> getAllClientsInfo() {	
		return clientService.getAllClientsInfo();
	}
	public Client getClientByCompany(String company){
		return clientService.getClientByCompany(company);
	}
	public void addClient(Client client) {
		clientService.addClient(client);
	}
	
	public void editClientManager(int id, String manager) {
		clientService.editManager(id, manager);
	}
	public void addBooking(Booking booking) {
		bookingService.addBooking(booking);
	}
	public void editBooking(int id, Booking booking){
		bookingService.editBooking(id, booking);
	}
	public void deleteBooking(int id){
		bookingService.deleteBooking(id);
	}
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	public List<Booking> getAllBookingsByClient(String company){
		return bookingService.getAllBookingsByClient(company);
	}
	public List<String> getAllManagersOfBookings(){
		List<Booking> bookings = bookingService.getAllBookings();
		List<String> managers = new ArrayList();
		for(Booking booking:bookings){
			managers.add(clientService.getClientByCompany(booking.getCompany()).getManager());
		}
		return managers;
	}
	public List<Manager> getAllManagersInfo() {	
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		return managerService.getAllManagersInfo();
	}
	
	public void addManager(String name, String mail, String phone){
		
		Manager manager = new Manager();
		
		manager.setMail(mail);
		manager.setName(name);
		manager.setPhone(phone);
		
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		managerService.addManager(manager);
	
	}
	
	public void deleteManager(int id) {
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		managerService.deleteManager(id);
	}
	
	public void editManager(int id, String mail, String phone) {
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		managerService.editManager(id, mail, phone);
	}
	
	public Manager getManagerByName(String name) {
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		return managerService.getManagerByName(name);
	}
	
	public List<String> getAllUpdatesStatusOfBookings(){
		List<Booking> bookings = bookingService.getAllBookings();
		List<String> updates = new ArrayList();
		for(Booking booking:bookings){
			
			String timeStatus = getTimeStatus(booking);
			updates.add(timeStatus);
			}
		
		return updates; 
	}
	public String getTimeStatus(Booking booking){
		
     	long oldMonitoring = 3; //hours
		String status = booking.getUpdate();
		if(status.equals("")){
			return "danger";
		}
		SimpleDateFormat format = new SimpleDateFormat("d.MM.yyyy HH:mm:ss");
		Date now = new Date();
		Date monitoring = null;
		try {
		   
		    monitoring = format.parse(status);
		} catch (ParseException e) {
		    e.printStackTrace();
		}    
		
		long diff = now.getTime() - monitoring.getTime();
		long diffHours = diff / (60 * 60 * 1000); //in hours
		if(diffHours<oldMonitoring){
			return "info";
		}
		return "";
		
	}
	public List<String> getAllWebDeliveryDates(){
		List<Booking> bookings = bookingService.getAllBookings();
		List<String> dates = new ArrayList();
		for(Booking booking:bookings){
			dates.add(translateStringDateToWeb(booking.getDelivery()));
		}
		return dates;
	}
	public boolean isKeyExist(String key){
		List<Booking> bookings = bookingService.getAllBookings();
		for(;;){
			for(Booking existingBooking:bookings){
				if(existingBooking.getKey().equals(key)){
					return true;
				}
			}
			return false;
		}
	}
	public Booking getBookingByKey(String key) {
		return bookingService.getBookingByKey(key);
	}
	public String createKey(){
		
		int min = 1000000;
		int max = 9999999;
		Random rand = new Random();
		List<Booking> bookings = bookingService.getAllBookings();

		int  code = rand.nextInt(max) + min;
		String key = code+"";
	
		for(;;){
			for(Booking existingBooking:bookings){
				if(existingBooking.getKey().equals(key)){
					key = createKey();
				}
			}
			return key;
		}
		
	}
	
	public boolean isManagerHasClient(String manager){
		List<Client> clients = clientService.getAllClientsInfo();
		for(Client client:clients){
			if(client.getManager().equals(manager)){
				return true;
			}
		}
		return false;
	}
	
	public List<String> getAllManagers() {	
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		return managerService.getAllManagers();
	}
	public boolean getAccess(String requestIp){
		AccessService accessService = (AccessService) ctx.getBean("accessService");
		return accessService.getAccessConfirmation(requestIp);
	}
	public String translateDateToString(Date date){
		DateFormat df = new SimpleDateFormat("d.MM.yyyy HH:mm:ss");       
	    return df.format(date);	
	}
	public String translateStringToNormalStringDate(String delivery){
		DateFormat format = new SimpleDateFormat("yyyy-MM-d");
		try {
		Date date = format.parse(delivery);
		DateFormat df = new SimpleDateFormat("d.MM.yyyy");       
	    return df.format(date);	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
	public String translateStringDateToWeb(String delivery){
		DateFormat format = new SimpleDateFormat("d.MM.yyyy");
		try {
		Date date = format.parse(delivery);
		DateFormat df = new SimpleDateFormat("yyyy-MM-d");       
	    return df.format(date);	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "";
	}
}
