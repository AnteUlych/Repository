package box.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "truck")
public class Truck {
	@Id
	@Column
	private int id;
	@Column
	private String tracktor;
	@Column
	private String trailer;
	@Column
	private String driver;
	@Column
	private String phone;
	@Column
	private String type;
	@Column
	private String managerName;
	@Column
	private int managerid;
	@Column
	private int priority;
	@Column
	private int notReady;
	@Column
	private String statusTruck;
	@Column
	private String comment;
	@Column
	private String truckKey;
	@Column
	private int kmruptela0131;
	@Column
	private double uahkmruptela0131;
	
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
	public String getTruckKey() {
		return truckKey;
	}
	public void setTruckKey(String truckKey) {
		this.truckKey = truckKey;
	}
	public int getKmruptela0131() {
		return kmruptela0131;
	}
	public void setKmruptela0131(int kmruptela0131) {
		this.kmruptela0131 = kmruptela0131;
	}
	public double getUahkmruptela0131() {
		return uahkmruptela0131;
	}
	public void setUahkmruptela0131(double uahkmruptela0131) {
		this.uahkmruptela0131 = uahkmruptela0131;
	}

}
