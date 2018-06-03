package beagle.temp;

import java.util.List;

import beagle.model.Booking;
import beagle.model.Client;

public class SimpleTest {

	public static void main(String[] args) {
		
		TempService test = new TempService();
		
		Booking booking = test.getBookingByKey("booking1");
		System.out.println(booking.getRoute());
		
		Client client = test.getClientByKey("booking1");
		System.out.println(client.getManager() + " serve for " + client.getCompany());
		
		List <Booking> bookings = test.getAllBookingsByCompany(client.getCompany());
		
		for(Booking situation:bookings){
			System.out.println(situation.getStatus());
		}
		
		
		
		

	}

}
