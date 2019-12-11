package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "archiveauction")
public class Archiveauction {
	@Id
	@Column
	private int id;
	@Column
	private int auctionid;
	@Column
	private int managerid;
	@Column
	private String route;
	@Column
	private String truck;
	@Column
	private String direction;
	@Column
	private String readiness;
	@Column
	private int rate;
	@Column
	private String currency;
	@Column
	private int importance;
	@Column
	private int betcount;
	@Column
	private Date date;
	@Column
	private String result;
	@Column
	private int trucks;
	@Column
	private int trucksclosed;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuctionid() {
		return auctionid;
	}
	public void setAuctionid(int auctionid) {
		this.auctionid = auctionid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getReadiness() {
		return readiness;
	}
	public void setReadiness(String readiness) {
		this.readiness = readiness;
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
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public int getBetcount() {
		return betcount;
	}
	public void setBetcount(int betcount) {
		this.betcount = betcount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getTrucks() {
		return trucks;
	}
	public void setTrucks(int trucks) {
		this.trucks = trucks;
	}
	public int getTrucksclosed() {
		return trucksclosed;
	}
	public void setTrucksclosed(int trucksclosed) {
		this.trucksclosed = trucksclosed;
	}

}
