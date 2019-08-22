package jobinterview;

import java.sql.SQLException;

public interface Company {

	public void addProduct(int category_id, String title, Double price,
			String status) throws SQLException;

	public void getProductsbyStore() throws SQLException;

	public void getProductbyId(int idOfProduct) throws SQLException;

	public void setStatusOfProduct(String title, String status)
			throws SQLException;

	public void setPriceOfProduct(String title, Double price)
			throws SQLException;

	public void changeAllEqualStatusesInCattegorieAndotherHalfonExpectedStatus(
			String oldStatus, String newStatus) throws SQLException;

	public void changeAllAvailableStatusesMakeBiggerprice() throws SQLException;

	public String getName();
}
