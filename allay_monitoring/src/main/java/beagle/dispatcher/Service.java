package beagle.dispatcher;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beagle.model.Booking;
import beagle.model.Client;
import beagle.service.BookingService;
import beagle.service.ClientService;

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
	public Booking getBookingByKey(String key) {
		return bookingService.getBookingByKey(key);
	}
}
