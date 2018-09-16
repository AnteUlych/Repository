package racoon.model;

import java.util.Date;

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
	private int requestId;
	@Column
	private Date answer;
	@Column
	private String rate;
	@Column
	private String Delivery;
	@Column
	private String  description;
	@Column
	private String manager;
	@Column
	private String  result;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAnswer() {
		return answer;
	}
	public void setAnswer(Date answer) {
		this.answer = answer;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getDelivery() {
		return Delivery;
	}
	public void setDelivery(String delivery) {
		Delivery = delivery;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
