package box.model;

import java.util.List;

public class VariantsHtml{
	
	private String startAddress;
	private int startClients;
	private List<Client> listStartClients;
	private String nextPoint;
	private int nextClients;
	private List<Client> listNextClients;
	private int nextPrice;
	private String finishPoint;
	private int finishPrice;
	
	public String getStartAddress() {
		return startAddress;
	}
	public void setStartAddress(String startAddress) {
		this.startAddress = startAddress;
	}
	public int getStartClients() {
		return startClients;
	}
	public void setStartClients(int startClients) {
		this.startClients = startClients;
	}
	public List<Client> getListStartClients() {
		return listStartClients;
	}
	public void setListStartClients(List<Client> listStartClients) {
		this.listStartClients = listStartClients;
	}
	public String getNextPoint() {
		return nextPoint;
	}
	public void setNextPoint(String nextPoint) {
		this.nextPoint = nextPoint;
	}
	public int getNextClients() {
		return nextClients;
	}
	public void setNextClients(int nextClients) {
		this.nextClients = nextClients;
	}
	public List<Client> getListNextClients() {
		return listNextClients;
	}
	public void setListNextClients(List<Client> listNextClients) {
		this.listNextClients = listNextClients;
	}
	public int getNextPrice() {
		return nextPrice;
	}
	public void setNextPrice(int nextPrice) {
		this.nextPrice = nextPrice;
	}
	public String getFinishPoint() {
		return finishPoint;
	}
	public void setFinishPoint(String finishPoint) {
		this.finishPoint = finishPoint;
	}
	public int getFinishPrice() {
		return finishPrice;
	}
	public void setFinishPrice(int finishPrice) {
		this.finishPrice = finishPrice;
	}


}
