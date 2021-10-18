package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Documents {
	@Id
	@Column
	private int id;
	@Column
	private int drnumber;
	@Column
	private String truck;
	@Column
	private String client;
	@Column
	private String weclient;
	@Column
	private String aboutroute;
	@Column
	private int responsibleid;
	@Column
	private String responsiblename;
	@Column
	private int whoaskingid;
	@Column
	private String whoaskingname;
	@Column
	private String whatneed;
	@Column
	private Date datecreating;
	@Column
	private Date datesolvving;
	@Column
	private String status;
	@Column
	private String color;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDrnumber() {
		return drnumber;
	}
	public void setDrnumber(int drnumber) {
		this.drnumber = drnumber;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getWeclient() {
		return weclient;
	}
	public void setWeclient(String weclient) {
		this.weclient = weclient;
	}
	public String getAboutroute() {
		return aboutroute;
	}
	public void setAboutroute(String aboutroute) {
		this.aboutroute = aboutroute;
	}
	public int getResponsibleid() {
		return responsibleid;
	}
	public void setResponsibleid(int responsibleid) {
		this.responsibleid = responsibleid;
	}
	public String getResponsiblename() {
		return responsiblename;
	}
	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}
	public int getWhoaskingid() {
		return whoaskingid;
	}
	public void setWhoaskingid(int whoaskingid) {
		this.whoaskingid = whoaskingid;
	}
	public String getWhatneed() {
		return whatneed;
	}
	public void setWhatneed(String whatneed) {
		this.whatneed = whatneed;
	}
	public String getWhoaskingname() {
		return whoaskingname;
	}
	public void setWhoaskingname(String whoaskingname) {
		this.whoaskingname = whoaskingname;
	}
	public Date getDatecreating() {
		return datecreating;
	}
	public void setDatecreating(Date datecreating) {
		this.datecreating = datecreating;
	}
	public Date getDatesolvving() {
		return datesolvving;
	}
	public void setDatesolvving(Date datesolvving) {
		this.datesolvving = datesolvving;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
