package box.model;

public class Statistic {
	
	private int id;
	private String managerName;
	private int numberOfCalculating;
	private int numberOfbooking;
	private int numberOfHelp;
	private int numberOfDeletes;
	private int numberOfNewClients;
	
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getNumberOfCalculating() {
		return numberOfCalculating;
	}
	public void setNumberOfCalculating(int numberOfCalculating) {
		this.numberOfCalculating = numberOfCalculating;
	}
	public int getNumberOfHelp() {
		return numberOfHelp;
	}
	public void setNumberOfHelp(int numberOfHelp) {
		this.numberOfHelp = numberOfHelp;
	}
	public int getNumberOfbooking() {
		return numberOfbooking;
	}
	public void setNumberOfbooking(int numberOfbooking) {
		this.numberOfbooking = numberOfbooking;
	}
	public int getNumberOfDeletes() {
		return numberOfDeletes;
	}
	public void setNumberOfDeletes(int numberOfDeletes) {
		this.numberOfDeletes = numberOfDeletes;
	}
	public int getNumberOfNewClients() {
		return numberOfNewClients;
	}
	public void setNumberOfNewClients(int numberOfNewClients) {
		this.numberOfNewClients = numberOfNewClients;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


}
