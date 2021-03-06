package box.model;

import java.util.List;

public class HistoryHTML {
	
	private String tracktor;
	private String trailer;
	private String driver;
	private String managerName;
	private List<Route> routes;
	private List<String> dates;
	
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

}
