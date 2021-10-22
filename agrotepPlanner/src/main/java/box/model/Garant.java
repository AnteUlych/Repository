package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "garant")
public class Garant {
	
	@Id
	@Column
	private int id;
	@Column
	private String client;
	@Column
	private String route;
	@Column
	private int price;
	@Column
	private String truckandmanager;
	@Column
	private int dayofweek;
	@Column
	private String color;
	@Column
	private Date plandate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTruckandmanager() {
		return truckandmanager;
	}
	public void setTruckandmanager(String truckandmanager) {
		this.truckandmanager = truckandmanager;
	}
	public int getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Date getPlandate() {
		return plandate;
	}
	public void setPlandate(Date plandate) {
		this.plandate = plandate;
	}

}
