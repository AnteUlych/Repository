package lotos.model;

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
	private int tenderid;
	@Column
	private int companytenderid;
	@Column
	private int companypropositionid;
	@Column
	private int propositionid;
	@Column
	private String tenderstart;
	@Column
	private String tenderdeal;
	@Column
	private int weight;
	@Column
	private String size;
	@Column
	private String ready;
	@Column
	private String countryfrom;
	@Column
	private String countryto;
	@Column
	private String payterms;
	@Column
	private int dayspay;
	@Column
	private String freightinfo;
	@Column
	private String companytender;
	@Column
	private String companyproposition;
	@Column
	private String addresstopickup;
	@Column
	private String addresstodelivery;
	@Column
	private String deliverydate;
	@Column
	private int price;
	@Column
	private String currency;
	@Column
	private String freightinformationandconditions;
	@Column
	private String transport;
	
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
	public int getCompanytenderid() {
		return companytenderid;
	}
	public void setCompanytenderid(int companytenderid) {
		this.companytenderid = companytenderid;
	}
	public int getCompanypropositionid() {
		return companypropositionid;
	}
	public void setCompanypropositionid(int companypropositionid) {
		this.companypropositionid = companypropositionid;
	}
	public int getPropositionid() {
		return propositionid;
	}
	public void setPropositionid(int propositionid) {
		this.propositionid = propositionid;
	}
	public String getTenderstart() {
		return tenderstart;
	}
	public void setTenderstart(String tenderstart) {
		this.tenderstart = tenderstart;
	}
	public String getTenderdeal() {
		return tenderdeal;
	}
	public void setTenderdeal(String tenderdeal) {
		this.tenderdeal = tenderdeal;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getReady() {
		return ready;
	}
	public void setReady(String ready) {
		this.ready = ready;
	}
	public String getCountryfrom() {
		return countryfrom;
	}
	public void setCountryfrom(String countryfrom) {
		this.countryfrom = countryfrom;
	}
	public String getCountryto() {
		return countryto;
	}
	public void setCountryto(String countryto) {
		this.countryto = countryto;
	}
	public String getPayterms() {
		return payterms;
	}
	public void setPayterms(String payterms) {
		this.payterms = payterms;
	}
	public int getDayspay() {
		return dayspay;
	}
	public void setDayspay(int dayspay) {
		this.dayspay = dayspay;
	}
	public String getFreightinfo() {
		return freightinfo;
	}
	public void setFreightinfo(String freightinfo) {
		this.freightinfo = freightinfo;
	}
	public String getCompanytender() {
		return companytender;
	}
	public void setCompanytender(String companytender) {
		this.companytender = companytender;
	}
	public String getCompanyproposition() {
		return companyproposition;
	}
	public void setCompanyproposition(String companyproposition) {
		this.companyproposition = companyproposition;
	}
	public String getAddresstopickup() {
		return addresstopickup;
	}
	public void setAddresstopickup(String addresstopickup) {
		this.addresstopickup = addresstopickup;
	}
	public String getAddresstodelivery() {
		return addresstodelivery;
	}
	public void setAddresstodelivery(String addresstodelivery) {
		this.addresstodelivery = addresstodelivery;
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
	public String getFreightinformationandconditions() {
		return freightinformationandconditions;
	}
	public void setFreightinformationandconditions(
			String freightinformationandconditions) {
		this.freightinformationandconditions = freightinformationandconditions;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	
	
	
}
