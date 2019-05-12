package lotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "recomendation")
public class Recomendation {
	@Id
	@Column
	private int id;
	@Column
	private int dealid;
	@Column
	private int companyid;
	@Column
	private int companytenderid;
	@Column
	private int companytransportationid;
	@Column
	private String companytender;
	@Column
	private String companyproposition;
	@Column
	private String dealdate;
	@Column
	private String recomendationdate;
	@Column
	private String incoterms;
	@Column
	private String countryfrom;
	@Column
	private String countryto;
	@Column
	private String weight;
	@Column
	private String transport;
	@Column
	private String rate;
	@Column
	private String whyinfo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDealid() {
		return dealid;
	}
	public void setDealid(int dealid) {
		this.dealid = dealid;
	}
	public int getCompanytenderid() {
		return companytenderid;
	}
	public void setCompanytenderid(int companytenderid) {
		this.companytenderid = companytenderid;
	}
	public int getCompanytransportationid() {
		return companytransportationid;
	}
	public void setCompanytransportationid(int companytransportationid) {
		this.companytransportationid = companytransportationid;
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

	public String getRecomendationdate() {
		return recomendationdate;
	}
	public void setRecomendationdate(String recomendationdate) {
		this.recomendationdate = recomendationdate;
	}
	public String getIncoterms() {
		return incoterms;
	}
	public void setIncoterms(String incoterms) {
		this.incoterms = incoterms;
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
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getWhyinfo() {
		return whyinfo;
	}
	public void setWhyinfo(String whyinfo) {
		this.whyinfo = whyinfo;
	}
	public String getDealdate() {
		return dealdate;
	}
	public void setDealdate(String dealdate) {
		this.dealdate = dealdate;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
}
