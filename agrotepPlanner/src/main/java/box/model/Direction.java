package box.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "direction")
public class Direction {
	
	@Id
	@Column
	private int id;
	@Column
	private String oblastFrom;
	@Column
	private String oblastTo;
	@Column
	private int clientId;
	@Column
	private String info;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOblastFrom() {
		return oblastFrom;
	}
	public void setOblastFrom(String oblastFrom) {
		this.oblastFrom = oblastFrom;
	}
	public String getOblastTo() {
		return oblastTo;
	}
	public void setOblastTo(String oblastTo) {
		this.oblastTo = oblastTo;
	}
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

}
