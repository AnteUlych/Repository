package beagle.temp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beagle.model.Booking;
import beagle.model.Client;

public class TempService {

public Booking getBookingByKey(String key){
	
	Booking booking = new Booking();
	
	booking.setDelivery("3/06/2018");
	booking.setId(0);
	booking.setKey("booking1");
	booking.setLatitude(59.911964);
	booking.setLongitude(10.755234);
	booking.setRoute("Oslo - Wismar");
	booking.setStatus("Oslo loading");
	booking.setUpdate("1/06/2018");
	
	return booking;
}

public Client getClientByKey(String key){
	
	Client client = new Client();
	
	client.setId(0);
	client.setCompany("Ace of Chemicals, Ltd");
	client.setMail("satoru@i.ua");
	client.setManager("Siri");
	client.setName("Ante");
	client.setPhone("+380506473151");
	
	return client;
}

public List<Booking> getAllBookingsByCompany(String company){
	
Booking booking1 = new Booking();
	
	booking1.setDelivery("3/06/2018");
	booking1.setId(0);
	booking1.setKey("booking1");
	booking1.setLatitude(59.911964);
	booking1.setLongitude(10.755234);
	booking1.setRoute("Oslo - Wismar");
	booking1.setStatus("Oslo loading");
	booking1.setUpdate("1/06/2018");
	
Booking booking2 = new Booking();
	
	booking2.setDelivery("4/06/2018");
	booking2.setId(0);
	booking2.setKey("booking2");
	booking2.setLatitude(55.725058);
	booking2.setLongitude(12.426556);
	booking2.setRoute("Herlev - Lutsk");
	booking2.setStatus("SD 123");
	booking2.setUpdate("1/06/2018");
	
	ArrayList<Booking>  bookings = new ArrayList<Booking>();
	bookings.add(booking1);
	bookings.add(booking2);
	
	return bookings;
	
}

}
