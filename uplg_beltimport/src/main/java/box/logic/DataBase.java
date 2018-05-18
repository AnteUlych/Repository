package box.logic;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
	
	public List <String> getAddresses(){
		
		List<String> addresses = new ArrayList<String>();
		addresses.add("Paris, FR");
		addresses.add("Berlin, DE");
		return addresses;
		
	}
	
	public List <String> getData(){
		
		List<String> data = new ArrayList<String>();
		data.add("Paris, FR|100|120|140|160|180|220|250|280|310|320|3");
		data.add("Berlin, DE|90|100|130|140|170|210|230|250|300|300|1");
		return data;
		
	}
	
	public List <String> getClients(){
		
		List<String> clients = new ArrayList<String>();
		clients.add("Natalia");
		clients.add("Oksana");
		return clients;
		
	}
	
public List <String> getClientsBase(){
		
		List<String> clients = new ArrayList<String>();
		clients.add("Natalia, +380506473151, nata@belt.ua");
		clients.add("Oksana, +380506471414, os@belt.ua");
		return clients;
		
	}

}
