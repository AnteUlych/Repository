package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "calculates")
public class Calculates {
	
	@Id
	@Column
	private int id;
	@Column
	private String company;
	@Column
	private int companyid; 
	@Column
	private String manager;
	@Column
	private int managerid;
	@Column
	private String comments;
	@Column
	private int weight;
	@Column
	private Date dateofcalculate;
	@Column
	private String freight;
	@Column
	private String truck;
	@Column
	private String temperature;
	@Column
	private int dangerous; 
	@Column
	private String countryfrom; 
	@Column
	private String countryto; 
	@Column
	private String customsfrom; 
	@Column
	private String customsto; 
	@Column
	private String calculateonadate;
	@Column
	private String budget;
	@Column
	private String rate;
	@Column
	private String exportimport;
	@Column
	private String cityfrom;
	@Column
	private String cityto;
	
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
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
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
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Date getDateofcalculate() {
		return dateofcalculate;
	}
	public void setDateofcalculate(Date dateofcalculate) {
		this.dateofcalculate = dateofcalculate;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public int getDangerous() {
		return dangerous;
	}
	public void setDangerous(int dangerous) {
		this.dangerous = dangerous;
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
	public String getCustomsfrom() {
		return customsfrom;
	}
	public void setCustomsfrom(String customsfrom) {
		this.customsfrom = customsfrom;
	}
	public String getCustomsto() {
		return customsto;
	}
	public void setCustomsto(String customsto) {
		this.customsto = customsto;
	}
	public String getCalculateonadate() {
		return calculateonadate;
	}
	public void setCalculateonadate(String calculateonadate) {
		this.calculateonadate = calculateonadate;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getExportimport() {
		return exportimport;
	}
	public void setExportimport(String exportimport) {
		this.exportimport = exportimport;
	}
	public String getCityfrom() {
		return cityfrom;
	}
	public void setCityfrom(String cityfrom) {
		this.cityfrom = cityfrom;
	}
	public String getCityto() {
		return cityto;
	}
	public void setCityto(String cityto) {
		this.cityto = cityto;
	}

}
