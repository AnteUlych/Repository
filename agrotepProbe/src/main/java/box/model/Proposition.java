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
	private int transportid;
	@Column
	private Date date;
	@Column
	private String readiness;
	@Column
	private String route;
	@Column
	private String information;
	@Column
	private int price;
	@Column
	private String manager;
	@Column
	private String status;
	@Column
	private String direction;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTransportid() {
		return transportid;
	}
	public void setTransportid(int transportid) {
		this.transportid = transportid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReadiness() {
		return readiness;
	}
	public void setReadiness(String readiness) {
		this.readiness = readiness;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
}
