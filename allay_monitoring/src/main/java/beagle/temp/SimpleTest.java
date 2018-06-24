package beagle.temp;

import java.util.List;

import beagle.dispatcher.Service;
import beagle.model.Booking;
import beagle.model.Client;


public class SimpleTest {

	public static void main(String[] args) {

		Service service = new Service();

		
		Booking booking = service.getBookingByKey("789456123");

		System.out.println(booking.getDelivery());
		

	}

}
