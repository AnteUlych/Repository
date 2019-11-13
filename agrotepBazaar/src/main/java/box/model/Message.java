package box.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@Column
	private int id;
	@Column
	private String text;
	@Column
	private int recipientid;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getRecipientid() {
		return recipientid;
	}
	public void setRecipientid(int recipientid) {
		this.recipientid = recipientid;
	}

}
