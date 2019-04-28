package lotos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@Column
	private int id;
	@Column
	private String company;
	@Column
	private String code;
	@Column
	private String manager;
	@Column
	private String mail;
	@Column
	private String phone;
	@Column
	private String mobile;
	@Column
	private String login;
	@Column
	private String password;
	@Column
	private String webaddress;
	@Column
	private String youcontrol;
	@Column
	private String registration;
	
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
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getWebaddress() {
		return webaddress;
	}
	public void setWebaddress(String webaddress) {
		this.webaddress = webaddress;
	}
	public String getYoucontrol() {
		return youcontrol;
	}
	public void setYoucontrol(String youcontrol) {
		this.youcontrol = youcontrol;
	}
	public String getRegistration() {
		return registration;
	}
	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
}
