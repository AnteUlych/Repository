package box.model;

import java.util.List;

public class HistoryHTML {
	
	private String tracktor;
	private String trailer;
	private String driver;
	private String type; //check if no problems with that
	private String managerName;
	private List<Route> routes;
	private List<String> dates;
	private int totalKm;
	private int totalUAH;
	private double totalUAHforKm;
	private int totalStops;
	private int totalColona;
	private int totalRemont;
	private int totalWork;
	private int avarageKmDay;
	
	public String getTracktor() {
		return tracktor;
	}
	public void setTracktor(String tracktor) {
		this.tracktor = tracktor;
	}
	public String getTrailer() {
		return trailer;
	}
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public List<Route> getRoutes() {
		return routes;
	}
	public void setRoutes(List<Route> routes) {
		this.routes = routes;
	}
	public List<String> getDates() {
		return dates;
	}
	public void setDates(List<String> dates) {
		this.dates = dates;
	}
	public int getTotalKm() {
		return totalKm;
	}
	public void setTotalKm(int totalKm) {
		this.totalKm = totalKm;
	}
	public int getTotalUAH() {
		return totalUAH;
	}
	public void setTotalUAH(int totalUAH) {
		this.totalUAH = totalUAH;
	}
	public double getTotalUAHforKm() {
		return totalUAHforKm;
	}
	public void setTotalUAHforKm(double totalUAHforKm) {
		this.totalUAHforKm = totalUAHforKm;
	}
	public int getTotalStops() {
		return totalStops;
	}
	public void setTotalStops(int totalStops) {
		this.totalStops = totalStops;
	}
	public int getTotalColona() {
		return totalColona;
	}
	public void setTotalColona(int totalColona) {
		this.totalColona = totalColona;
	}
	public int getTotalRemont() {
		return totalRemont;
	}
	public void setTotalRemont(int totalRemont) {
		this.totalRemont = totalRemont;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTotalWork() {
		return totalWork;
	}
	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}
	public int getAvarageKmDay() {
		return avarageKmDay;
	}
	public void setAvarageKmDay(int avarageKmDay) {
		this.avarageKmDay = avarageKmDay;
	}

}
