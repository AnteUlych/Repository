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
	private String answer;
	@Column
	private String funnel;
	@Column
	private Date lasttime;

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

	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}


}
