package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class History {
	@Id
	@Column
	private int id;
	@Column
	private int managerid;
	@Column
	private int action;
	@Column
	private String manager;
	@Column
	private Date actionDate;
	@Column
	private String info;
	
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
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Date getActionDate() {
		return actionDate;
	}
	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
}
