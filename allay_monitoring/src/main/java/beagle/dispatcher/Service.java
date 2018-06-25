package beagle.dispatcher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beagle.model.Booking;
import beagle.model.Client;
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
	public Client getClientByCompany(String company){
		return clientService.getClientByCompany(company);
	}
	public void addClient(Client client) {
		clientService.addClient(client);
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

		int  code = rand.nextInt(9999999) + 1000000;
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
	public List<String> getAllManagers() {	
		ManagerService managerService = (ManagerService) ctx.getBean("managerService");
		return managerService.getAllClients();
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
}
