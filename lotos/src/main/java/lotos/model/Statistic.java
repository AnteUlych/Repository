package lotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "statistic")
public class Statistic {
	
	@Id
	@Column
	private int id;
	@Column
	private int companyid;
	@Column
	private String company;
	@Column
	private String code;
	@Column
	private int tenderscount;
	@Column
	private int propositionscount;
	@Column
	private int confirmpropositionscount;
	@Column
	private int badrecomendationscount;
	@Column
	private int goodrecomendationscount;
	@Column
	private String lastvisit;
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getTenderscount() {
		return tenderscount;
	}
	public void setTenderscount(int tenderscount) {
		this.tenderscount = tenderscount;
	}
	public int getPropositionscount() {
		return propositionscount;
	}
	public void setPropositionscount(int propositionscount) {
		this.propositionscount = propositionscount;
	}
	public int getConfirmpropositionscount() {
		return confirmpropositionscount;
	}
	public void setConfirmpropositionscount(int confirmpropositionscount) {
		this.confirmpropositionscount = confirmpropositionscount;
	}
	public int getBadrecomendationscount() {
		return badrecomendationscount;
	}
	public void setBadrecomendationscount(int badrecomendationscount) {
		this.badrecomendationscount = badrecomendationscount;
	}
	public int getGoodrecomendationscount() {
		return goodrecomendationscount;
	}
	public void setGoodrecomendationscount(int goodrecomendationscount) {
		this.goodrecomendationscount = goodrecomendationscount;
	}
	public String getLastvisit() {
		return lastvisit;
	}
	public void setLastvisit(String lastvisit) {
		this.lastvisit = lastvisit;
	}

}
