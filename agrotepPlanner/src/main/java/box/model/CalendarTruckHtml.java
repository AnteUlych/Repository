package box.model;

import javax.persistence.Column;

public class CalendarTruckHtml {

	private int id;

	private String tracktor;

	private String trailer;

	private String driver;

	private String phone;

	private String type;

	private String managerName;

	private int managerid;

	private int priority;

	private int notReady;

	private String statusTruck;

	private String comment;
	
	private double mounthUAHforKm;
	private int mounthKm;
	
	private String day1Link;
	private String day2Link;
	private String day3Link;
	private String day4Link;
	private String day5Link;
	
	private String day1;
	private String day2;
	private String day3;
	private String day4;
	private String day5;
	
	private String columnUrgentClass;
	private String columnUrgentColorClass;
	private String fromOblastStatusStyle;
	private String fromLastOblast;
		
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getNotReady() {
		return notReady;
	}
	public void setNotReady(int notReady) {
		this.notReady = notReady;
	}
	public String getStatusTruck() {
		return statusTruck;
	}
	public void setStatusTruck(String statusTruck) {
		this.statusTruck = statusTruck;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getDay1() {
		return day1;
	}
	public void setDay1(String day1) {
		this.day1 = day1;
	}
	public String getDay2() {
		return day2;
	}
	public void setDay2(String day2) {
		this.day2 = day2;
	}
	public String getDay3() {
		return day3;
	}
	public void setDay3(String day3) {
		this.day3 = day3;
	}
	public String getDay4() {
		return day4;
	}
	public void setDay4(String day4) {
		this.day4 = day4;
	}
	public String getDay5() {
		return day5;
	}
	public void setDay5(String day5) {
		this.day5 = day5;
	}
	public String getColumnUrgentClass() {
		return columnUrgentClass;
	}
	public void setColumnUrgentClass(String columnUrgentClass) {
		this.columnUrgentClass = columnUrgentClass;
	}


	public String getColumnUrgentColorClass() {
		return columnUrgentColorClass;
	}
	public void setColumnUrgentColorClass(String columnUrgentColorClass) {
		this.columnUrgentColorClass = columnUrgentColorClass;
	}
	public String getFromLastOblast() {
		return fromLastOblast;
	}
	public void setFromLastOblast(String fromLastOblast) {
		this.fromLastOblast = fromLastOblast;
	}
	public String getFromOblastStatusStyle() {
		return fromOblastStatusStyle;
	}
	public void setFromOblastStatusStyle(String fromOblastStatusStyle) {
		this.fromOblastStatusStyle = fromOblastStatusStyle;
	}
	public String getDay1Link() {
		return day1Link;
	}
	public void setDay1Link(String day1Link) {
		this.day1Link = day1Link;
	}
	public String getDay2Link() {
		return day2Link;
	}
	public void setDay2Link(String day2Link) {
		this.day2Link = day2Link;
	}
	public String getDay3Link() {
		return day3Link;
	}
	public void setDay3Link(String day3Link) {
		this.day3Link = day3Link;
	}
	public String getDay4Link() {
		return day4Link;
	}
	public void setDay4Link(String day4Link) {
		this.day4Link = day4Link;
	}
	public String getDay5Link() {
		return day5Link;
	}
	public void setDay5Link(String day5Link) {
		this.day5Link = day5Link;
	}
	public double getMounthUAHforKm() {
		return mounthUAHforKm;
	}
	public void setMounthUAHforKm(double mounthUAHforKm) {
		this.mounthUAHforKm = mounthUAHforKm;
	}
	public int getMounthKm() {
		return mounthKm;
	}
	public void setMounthKm(int mounthKm) {
		this.mounthKm = mounthKm;
	}

}
