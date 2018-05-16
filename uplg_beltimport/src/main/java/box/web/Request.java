package box.web;

import java.util.List;

public class Request {
	
	private String client;
	private String pickup;
	private String address;
	private String quantity;
	private List <String> documentation;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public List <String> getDocumentation() {
		return documentation;
	}
	public void setDocumentation(List <String> documentation) {
		this.documentation = documentation;
	}

}
