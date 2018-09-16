package racoon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "request")
public class Request {
	@Id
	@Column
	private int id;
	@Column
	private String company;
	@Column
	private String route;
	@Column
	private Date creating;
	@Column
	private String manager;
	@Column
	private String size;
	@Column
	private String weight;
	@Column
	private String other;
	@Column
	private String readiness;
	@Column
	private String result;
	@Column
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getRoute() {
		return route;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public Date getCreating() {
		return creating;
	}
	public void setCreating(Date creating) {
		this.creating = creating;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	public String getReadiness() {
		return readiness;
	}
	public void setReadiness(String readiness) {
		this.readiness = readiness;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
