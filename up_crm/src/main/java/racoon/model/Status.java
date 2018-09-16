package racoon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	@Id
	@Column
	private int id;
	@Column
	private int clientId;
	@Column
	private String last;
	@Column
	private String answer;
	@Column
	private String funnel;
	@Column
	private String nexttime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getFunnel() {
		return funnel;
	}

	public void setFunnel(String funnel) {
		this.funnel = funnel;
	}



	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public String getNexttime() {
		return nexttime;
	}

	public void setNexttime(String nexttime) {
		this.nexttime = nexttime;
	}

}
