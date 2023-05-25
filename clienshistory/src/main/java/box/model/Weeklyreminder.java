package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "weeklyreminder")
public class Weeklyreminder {
	
	@Id
	@Column
	private int id;
	@Column
	private int clientid;
	@Column
	private String clientname;
	@Column
	private String textreminder;
	@Column
	private int dayofweek;
	@Column
	private String color;
	@Column
	private int managerid;
	@Column
	private int isitnotchecked;
	@Column
	private Date bobdate;
	@Column
	private String dayofweekname;
	@Column
	private String manager;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public String getClientname() {
		return clientname;
	}
	public void setClientname(String clientname) {
		this.clientname = clientname;
	}
	public int getDayofweek() {
		return dayofweek;
	}
	public void setDayofweek(int dayofweek) {
		this.dayofweek = dayofweek;
	}
	public String getTextreminder() {
		return textreminder;
	}
	public void setTextreminder(String textreminder) {
		this.textreminder = textreminder;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public int getIsitnotchecked() {
		return isitnotchecked;
	}
	public void setIsitnotchecked(int isitnotchecked) {
		this.isitnotchecked = isitnotchecked;
	}
	public Date getBobdate() {
		return bobdate;
	}
	public void setBobdate(Date bobdate) {
		this.bobdate = bobdate;
	}
	public String getDayofweekname() {
		return dayofweekname;
	}
	public void setDayofweekname(String dayofweekname) {
		this.dayofweekname = dayofweekname;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}


}
