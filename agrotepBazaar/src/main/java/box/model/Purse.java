package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purse")
public class Purse {
	@Id
	@Column
	private int id;
	@Column
	private int managerid;
	@Column
	private String manager;
	@Column
	private Date date;
	@Column
	private int uah;
	@Column
	private int eur;
	@Column
	private int usd;
	@Column
	private String client;
	@Column
	private String route;
	@Column
	private String truck;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getUah() {
		return uah;
	}
	public void setUah(int uah) {
		this.uah = uah;
	}
	public int getEur() {
		return eur;
	}
	public void setEur(int eur) {
		this.eur = eur;
	}
	public int getUsd() {
		return usd;
	}
	public void setUsd(int usd) {
		this.usd = usd;
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
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}

}
