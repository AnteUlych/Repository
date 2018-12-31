package racoon.model;

public class ManagerRequestReport {

	private String name;
	private int allAuto;
	private int allSar;
	private int notCalcAuto;
	private int notCalcSar;
	private int refuseAuto;
	private int refuseSar;
	private int bookedAuto;
	private int bookedSar;
	private int propositions;
	private int booked;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAllAuto() {
		return allAuto;
	}
	public void setAllAuto(int allAuto) {
		this.allAuto = allAuto;
	}
	
	public int getAllSar() {
		return allSar;
	}

	public void setAllSar(int allSar) {
		this.allSar = allSar;
	}
	
	public int getNotCalcAuto() {
		return notCalcAuto;
	}

	public void setNotCalcAuto(int notCalcAuto) {
		this.notCalcAuto = notCalcAuto;
	}

	public int getNotCalcSar() {
		return notCalcSar;
	}
	
	public void setNotCalcSar(int notCalcSar) {
		this.notCalcSar = notCalcSar;
	}
	
	public int getRefuseAuto() {
		return refuseAuto;
	}

	public void setRefuseAuto(int refuseAuto) {
		this.refuseAuto = refuseAuto;
	}

	public int getRefuseSar() {
		return refuseSar;
	}

	public void setRefuseSar(int refuseSar) {
		this.refuseSar = refuseSar;
	}

	public int getBookedAuto() {
		return bookedAuto;
	}

	public void setBookedAuto(int bookedAuto) {
		this.bookedAuto = bookedAuto;
	}

	public int getBookedSar() {
		return bookedSar;
	}

	public void setBookedSar(int bookedSar) {
		this.bookedSar = bookedSar;
	}

	public int getPropositions() {
		return propositions;
	}

	public void setPropositions(int propositions) {
		this.propositions = propositions;
	}

	public int getBooked() {
		return booked;
	}

	public void setBooked(int booked) {
		this.booked = booked;
	}
	
}
