package box.model;

public class ManagerReport {
	
	private String managerName;
	private int kpiLpr;
	private int kpiContract;
	private int kpiClient;
	private int newClients;
	private int managerid;
	

	public int getKpiLpr() {
		return kpiLpr;
	}
	public void setKpiLpr(int kpiLpr) {
		this.kpiLpr = kpiLpr;
	}

	public int getKpiClient() {
		return kpiClient;
	}
	public void setKpiClient(int kpiClient) {
		this.kpiClient = kpiClient;
	}
	public int getNewClients() {
		return newClients;
	}
	public void setNewClients(int newClients) {
		this.newClients = newClients;
	}
	public int getKpiContract() {
		return kpiContract;
	}
	public void setKpiContract(int kpiContract) {
		this.kpiContract = kpiContract;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}


}
