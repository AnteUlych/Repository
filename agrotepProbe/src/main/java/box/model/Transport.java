package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transport")
public class Transport {
	@Id
	@Column
	private int id;
	@Column
	private Date date;
	@Column
	private String readiness;
	@Column
	private String route;
	@Column
	private String information;
	@Column
	private String status;
	@Column
	private String truckdriver;
	@Column
	private String direction;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTruckdriver() {
		return truckdriver;
	}
	public void setTruckdriver(String truckdriver) {
		this.truckdriver = truckdriver;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

}
