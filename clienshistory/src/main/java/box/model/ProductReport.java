package box.model;

public class ProductReport {
	
	private String productName;
	private int kpiLpr;
	private int kpiContract;
	private int kpiClient;
	private int newClients;
	private int productid;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getKpiLpr() {
		return kpiLpr;
	}
	public void setKpiLpr(int kpiLpr) {
		this.kpiLpr = kpiLpr;
	}
	public int getKpiContract() {
		return kpiContract;
	}
	public void setKpiContract(int kpiContract) {
		this.kpiContract = kpiContract;
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
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}

}
