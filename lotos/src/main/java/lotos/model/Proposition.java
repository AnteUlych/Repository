package lotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proposition")
public class Proposition {
	@Id
	@Column
	private int id;
	@Column
	private int tenderid;
	@Column
	private int companyid;
	@Column
	private String company;
	@Column
	private String dateproposition;
	@Column
	private String transport;
	@Column
	private String pickup;
	@Column
	private String deliverydate;
	@Column
	private int price;
	@Column
	private String currency;
	@Column
	private String otherinformation;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTenderid() {
		return tenderid;
	}
	public void setTenderid(int tenderid) {
		this.tenderid = tenderid;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDateproposition() {
		return dateproposition;
	}
	public void setDateproposition(String dateproposition) {
		this.dateproposition = dateproposition;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getOtherinformation() {
		return otherinformation;
	}
	public void setOtherinformation(String otherinformation) {
		this.otherinformation = otherinformation;
	}
	
}
