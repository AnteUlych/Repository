package racoon.model;

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
	private String code;
	@Column
	private String phone;
	@Column
	private String person;
	@Column
	private String mail;
	@Column
	private String category;
	@Column
	private String manager;
	@Column
	private String nextcall;
	@Column
	private String funnel;
	@Column
	private String answer;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getNextcall() {
		return nextcall;
	}
	public void setNextcall(String nextcall) {
		this.nextcall = nextcall;
	}
	public String getFunnel() {
		return funnel;
	}
	public void setFunnel(String funnel) {
		this.funnel = funnel;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
