package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposition")
public class Proposition {
	
	@Id
	@Column
	private int id;
	@Column
	private String route;
	@Column
	private String direction;
	@Column
	private int rate;
	@Column
	private String currency;
	@Column
	private String status;
	@Column
	private int managerid;
	@Column
	private String manager;
	@Column
	private String truck;
	@Column
	private Date date;
	@Column
	private Date readiness;
	@Column
	private String information;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public Date getReadiness() {
		return readiness;
	}
	public void setReadiness(Date readiness) {
		this.readiness = readiness;
	}

}
