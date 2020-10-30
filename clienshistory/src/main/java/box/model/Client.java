package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@Column
	private int id;
	@Column
	private String company;
	@Column
	private int managerid;
	@Column
	private String manager;
	@Column
	private String lpr;
	@Column
	private String phone;
	@Column
	private String mobile;
	@Column
	private String mail;
	@Column
	private String othercontact;
	@Column
	private String products;
	@Column
	private Date creation;
	@Column
	private int funel;
	@Column
	private Date nextcall;
	@Column
	private String lastrecord;
	@Column
	private String freight;
	@Column
	private String edrpo;
	
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getLpr() {
		return lpr;
	}
	public void setLpr(String lpr) {
		this.lpr = lpr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getOthercontact() {
		return othercontact;
	}
	public void setOthercontact(String othercontact) {
		this.othercontact = othercontact;
	}
	public String getProducts() {
		return products;
	}
	public void setProducts(String products) {
		this.products = products;
	}
	public Date getCreation() {
		return creation;
	}
	public void setCreation(Date creation) {
		this.creation = creation;
	}
	public int getFunel() {
		return funel;
	}
	public void setFunel(int funel) {
		this.funel = funel;
	}
	public Date getNextcall() {
		return nextcall;
	}
	public void setNextcall(Date nextcall) {
		this.nextcall = nextcall;
	}
	public String getLastrecord() {
		return lastrecord;
	}
	public void setLastrecord(String lastrecord) {
		this.lastrecord = lastrecord;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getEdrpo() {
		return edrpo;
	}
	public void setEdrpo(String edrpo) {
		this.edrpo = edrpo;
	}

	

}
