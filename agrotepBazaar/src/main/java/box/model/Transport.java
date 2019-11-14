package box.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transport")
public class Transport {
	@Id
	@Column
	private int id;
	@Column
	private String trucknumber;
	@Column
	private String truck;
	@Column
	private String driver;
	@Column
	private String chiefname;
	@Column
	private int chiefid;
	@Column
	private String euro;
	@Column
	private String otherinformation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTrucknumber() {
		return trucknumber;
	}
	public void setTrucknumber(String trucknumber) {
		this.trucknumber = trucknumber;
	}
	public String getTruck() {
		return truck;
	}
	public void setTruck(String truck) {
		this.truck = truck;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getChiefname() {
		return chiefname;
	}
	public void setChiefname(String chiefname) {
		this.chiefname = chiefname;
	}
	public int getChiefid() {
		return chiefid;
	}
	public void setChiefid(int chiefid) {
		this.chiefid = chiefid;
	}
	public String getEuro() {
		return euro;
	}
	public void setEuro(String euro) {
		this.euro = euro;
	}
	public String getOtherinformation() {
		return otherinformation;
	}
	public void setOtherinformation(String otherinformation) {
		this.otherinformation = otherinformation;
	}

}
