package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@Column
	private int id;
	@Column
	private int truckid;
	@Column
	private String fromCity;
	@Column
	private String toCity;
	@Column
	private String fromOblast;
	@Column
	private String toOblast;
	@Column
	private double fromLon;
	@Column
	private double fromLat;
	@Column
	private double toLon;
	@Column
	private double toLat;
	@Column
	private Date fromDate;
	@Column
	private Date toDate;
	@Column
	private int price;
	@Column
	private int kilometrs;
	@Column
	private int piceForKilometr;
	@Column
	private String info;
	@Column
	private int routeStatus;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTruckid() {
		return truckid;
	}
	public void setTruckid(int truckid) {
		this.truckid = truckid;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public String getFromOblast() {
		return fromOblast;
	}
	public void setFromOblast(String fromOblast) {
		this.fromOblast = fromOblast;
	}
	public String getToOblast() {
		return toOblast;
	}
	public void setToOblast(String toOblast) {
		this.toOblast = toOblast;
	}
	public double getFromLon() {
		return fromLon;
	}
	public void setFromLon(double fromLon) {
		this.fromLon = fromLon;
	}
	public double getFromLat() {
		return fromLat;
	}
	public void setFromLat(double fromLat) {
		this.fromLat = fromLat;
	}
	public double getToLon() {
		return toLon;
	}
	public void setToLon(double toLon) {
		this.toLon = toLon;
	}
	public double getToLat() {
		return toLat;
	}
	public void setToLat(double toLat) {
		this.toLat = toLat;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKilometrs() {
		return kilometrs;
	}
	public void setKilometrs(int kilometrs) {
		this.kilometrs = kilometrs;
	}
	public int getPiceForKilometr() {
		return piceForKilometr;
	}
	public void setPiceForKilometr(int piceForKilometr) {
		this.piceForKilometr = piceForKilometr;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getRouteStatus() {
		return routeStatus;
	}
	public void setRouteStatus(int routeStatus) {
		this.routeStatus = routeStatus;
	}
	
}
