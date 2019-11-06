package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class Deal {
	
	@Id
	@Column
	private int id;
	@Column
	private int soldid;
	@Column
	private int managerid;
	@Column
	private String manager;
	@Column
	private String route;
	@Column
	private String information;
	@Column
	private String direction;
	@Column
	private String status;
	@Column
	private String truck;
	@Column
	private String truckdriver;
	@Column
	private Date date;
	@Column
	private Date dateoftransportation;
	@Column
	private int chiefid;
	@Column
	private String chiefname;
	@Column
	private int betid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoldid() {
		return soldid;
	}

	public void setSoldid(int soldid) {
		this.soldid = soldid;
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

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTruck() {
		return truck;
	}

	public void setTruck(String truck) {
		this.truck = truck;
	}

	public String getTruckdriver() {
		return truckdriver;
	}

	public void setTruckdriver(String truckdriver) {
		this.truckdriver = truckdriver;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDateoftransportation() {
		return dateoftransportation;
	}

	public void setDateoftransportation(Date dateoftransportation) {
		this.dateoftransportation = dateoftransportation;
	}

	public int getChiefid() {
		return chiefid;
	}

	public void setChiefid(int chiefid) {
		this.chiefid = chiefid;
	}

	public String getChiefname() {
		return chiefname;
	}

	public void setChiefname(String chiefname) {
		this.chiefname = chiefname;
	}

	public int getBetid() {
		return betid;
	}

	public void setBetid(int betid) {
		this.betid = betid;
	}

}
