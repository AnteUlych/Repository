package beagle.temp;

import java.util.Date;
import java.util.List;

import beagle.dispatcher.Service;
import beagle.model.Booking;
import beagle.model.Client;
import beagle.model.Manager;

public class SimpleTest {

	public static void main(String[] args) {

		Service service = new Service();
		List<String> m = service.getAllManagers();
        for(String ma:m){
		System.out.println(ma);
        }
	}

}
