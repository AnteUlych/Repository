package box.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deal")
public class Deal {
	
	@Id
	@Column
	private int id;
	@Column
	private int soldid;
	@Column
	private int managerid;
	@Column
	private String manager;
	@Column
	private String route;
	@Column
	private String information;
	@Column
	private String direction;
	@Column
	private String status;
	@Column
	private String truck;
	@Column
	private String truckdriver;
	@Column
	private Date date;
	@Column
	private Date dateoftransportation;

}
