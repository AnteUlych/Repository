package box.logic;

import java.util.ArrayList;
import java.util.List;

import box.mail.Sender;
import box.web.Request;

public class Coon {

	public static void main(String[] args) {
		
		Request request = new Request();
		
		request.setAddress("London, UK");
		request.setClient("Oksana");
		
		System.out.println(request.getClient());
		
		List<String> documents = new ArrayList<String>();
		documents.add("EX-1 - 45 EUR ");
	
		
		request.setDocumentation(documents);
		request.setPickup("01/01/2017");
		request.setQuantity("2");
		
		String price = "150 eur";
		String delivery = "at Kyiv 1 February, 2018";
		
		Sender bird = new Sender();
		
		bird.sendOrder(request, price, delivery);
	}

}
