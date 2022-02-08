package box.model;

public class StatisticKPI {
	
	private String indicator;
	private double uahkm;
	private int kmday;
	private int km;
	private int totalStops;
	private int totalColona;
	private int totalRemont;
	private int totalWork;
	private int percentLogisticColonaRemomt;
	private int percentLogisticNoStops;
	private int trucks;
	
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	public double getUahkm() {
		return uahkm;
	}
	public void setUahkm(double uahkm) {
		this.uahkm = uahkm;
	}
	
	public int getTotalStops() {
		return totalStops;
	}
	public void setTotalStops(int totalStops) {
		this.totalStops = totalStops;
	}
	public int getTotalColona() {
		return totalColona;
	}
	public void setTotalColona(int totalColona) {
		this.totalColona = totalColona;
	}
	public int getTotalRemont() {
		return totalRemont;
	}
	public void setTotalRemont(int totalRemont) {
		this.totalRemont = totalRemont;
	}
	public int getPercentLogisticColonaRemomt() {
		return percentLogisticColonaRemomt;
	}
	public void setPercentLogisticColonaRemomt(int percentLogisticColonaRemomt) {
		this.percentLogisticColonaRemomt = percentLogisticColonaRemomt;
	}
	public int getPercentLogisticNoStops() {
		return percentLogisticNoStops;
	}
	public void setPercentLogisticNoStops(int percentLogisticNoStops) {
		this.percentLogisticNoStops = percentLogisticNoStops;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public int getKmday() {
		return kmday;
	}
	public void setKmday(int kmday) {
		this.kmday = kmday;
	}
	public int getTrucks() {
		return trucks;
	}
	public void setTrucks(int trucks) {
		this.trucks = trucks;
	}
	public int getTotalWork() {
		return totalWork;
	}
	public void setTotalWork(int totalWork) {
		this.totalWork = totalWork;
	}
}
