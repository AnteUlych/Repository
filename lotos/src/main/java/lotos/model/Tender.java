package lotos.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tender")
public class Tender {
	@Id
	@Column
	private int id;
	@Column
	private int companyid;
	@Column
	private String company;
	@Column
	private Date datetimecreation;
	@Column
	private String dateofopening;
	@Column
	private int weight;
	@Column
	private int size;
	@Column
	private int readytopickup;
	@Column
	private int appdelivery;
	@Column
	private Date timetoendtender;
	@Column
	private String countryfrom;
	@Column
	private String countryto;
	@Column
	private String possibletransport;
	@Column
	private String payconditions;
	@Column
	private int dayspay;
	@Column
	private String freightinformationandconditions;
	@Column
	private String visiability;
	@Column
	private String addresstopickup;
	@Column
	private String addresstodelivery;
	@Column
	private String incoterms;
	@Column
	private String isopen;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getDateofopening() {
		return dateofopening;
	}
	public void setDateofopening(String dateofopening) {
		this.dateofopening = dateofopening;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getReadytopickup() {
		return readytopickup;
	}
	public void setReadytopickup(int readytopickup) {
		this.readytopickup = readytopickup;
	}
	public int getAppdelivery() {
		return appdelivery;
	}
	public void setAppdelivery(int appdelivery) {
		this.appdelivery = appdelivery;
	}
	public Date getTimetoendtender() {
		return timetoendtender;
	}
	public void setTimetoendtender(Date timetoendtender) {
		this.timetoendtender = timetoendtender;
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
	public String getPossibletransport() {
		return possibletransport;
	}
	public void setPossibletransport(String possibletransport) {
		this.possibletransport = possibletransport;
	}
	public String getPayconditions() {
		return payconditions;
	}
	public void setPayconditions(String payconditions) {
		this.payconditions = payconditions;
	}
	public int getDayspay() {
		return dayspay;
	}
	public void setDayspay(int dayspay) {
		this.dayspay = dayspay;
	}
	public String getFreightinformationandconditions() {
		return freightinformationandconditions;
	}
	public void setFreightinformationandconditions(
			String freightinformationandconditions) {
		this.freightinformationandconditions = freightinformationandconditions;
	}
	public String getVisiability() {
		return visiability;
	}
	public void setVisiability(String visiability) {
		this.visiability = visiability;
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
	public String getIncoterms() {
		return incoterms;
	}
	public void setIncoterms(String incoterms) {
		this.incoterms = incoterms;
	}
	public String getIsopen() {
		return isopen;
	}
	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}
	public Date getDatetimecreation() {
		return datetimecreation;
	}
	public void setDatetimecreation(Date datetimecreation) {
		this.datetimecreation = datetimecreation;
	}
	
}
