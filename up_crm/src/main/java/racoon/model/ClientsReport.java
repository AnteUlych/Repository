package racoon.model;

import java.util.Date;

public class ClientsReport {
	
	private String company;
	private String manager;
	private String category;
	private int requests;
	private int bookings;
	private String nextCall;
	private String lastComment;
	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getRequests() {
		return requests;
	}
	public void setRequests(int requests) {
		this.requests = requests;
	}
	public int getBookings() {
		return bookings;
	}
	public void setBookings(int bookings) {
		this.bookings = bookings;
	}

	public String getLastComment() {
		return lastComment;
	}
	public void setLastComment(String lastComment) {
		this.lastComment = lastComment;
	}
	public String getNextCall() {
		return nextCall;
	}
	public void setNextCall(String nextCall) {
		this.nextCall = nextCall;
	}

}
