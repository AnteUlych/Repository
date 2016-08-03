package fsmac.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import fsmac.service.QuestionnaireService;

@Entity(name = "questionnaire")
@Table(name = "questionnaire")
public class Questionnaire {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "question1")
	private int question1;
	
	@Column(name = "question2")
	private int question2;
	
	@Column(name = "question3")
	private int question3;
	
	@Column(name = "question4")
	private int question4;
	
	@Column(name = "question5")
	private int question5;
	
	@Column(name = "question6")
	private int question6;
	
	@Column(name = "question7")
	private int question7;
	
	@Column(name = "question8")
	private int question8;
	
	@Column(name = "question9")
	private int question9;
	
	@Column(name = "question10")
	private int question10;
	
	
	@Column(name = "registration")
	private Date registration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getQuestion1() {
		return question1;
	}

	public void setQuestion1(int question1) {
		this.question1 = question1;
	}

	public int getQuestion2() {
		return question2;
	}

	public void setQuestion2(int question2) {
		this.question2 = question2;
	}

	public int getQuestion3() {
		return question3;
	}

	public void setQuestion3(int question3) {
		this.question3 = question3;
	}

	public int getQuestion4() {
		return question4;
	}

	public void setQuestion4(int question4) {
		this.question4 = question4;
	}

	public int getQuestion5() {
		return question5;
	}

	public void setQuestion5(int question5) {
		this.question5 = question5;
	}

	public int getQuestion6() {
		return question6;
	}

	public void setQuestion6(int question6) {
		this.question6 = question6;
	}

	public int getQuestion7() {
		return question7;
	}

	public void setQuestion7(int question7) {
		this.question7 = question7;
	}

	public int getQuestion8() {
		return question8;
	}

	public void setQuestion8(int question8) {
		this.question8 = question8;
	}

	public int getQuestion9() {
		return question9;
	}

	public void setQuestion9(int question9) {
		this.question9 = question9;
	}

	public int getQuestion10() {
		return question10;
	}

	public void setQuestion10(int question10) {
		this.question10 = question10;
	}

	public Date getRegistration() {
		return registration;
	}

	public void setRegistration(Date registration) {
		this.registration = registration;
	}
	
	public String getTotalRate() {

		double result = (double)(getQuestion1()
				+ getQuestion2() + getQuestion3()
				+ getQuestion4() + getQuestion5()
				+ getQuestion6() + getQuestion7()
				+ getQuestion8() + getQuestion9() + getQuestion10()) / QuestionnaireService.NUMBER_OF_QUESTIONS;

		return String.format("%.1f", result);
	}
	
	public String getDate(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		return df.format(getRegistration());	
	}
	

}
