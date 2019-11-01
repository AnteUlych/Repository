package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sold")
public class Sold {
	@Id
	@Column
	private int id;
	@Column
	private String route;
	@Column
	private int managerid;
	@Column
	private String information;
	@Column
	private String direction;
	@Column
	private int rate;
	@Column
	private String currency;
	@Column
	private String truck;
	@Column
	private Date date;
	@Column
	private String readiness;
	@Column
	private int importance;
	@Column
	private int auctionid;
	@Column
	private int betid;
	@Column
	private String manager;
	
	
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
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
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
	public String getReadiness() {
		return readiness;
	}
	public void setReadiness(String readiness) {
		this.readiness = readiness;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public int getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}
	public int getBetid() {
		return betid;
	}
	public void setBetid(int betid) {
		this.betid = betid;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

}
