package jobinterview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Store implements Company {

	private static Store store;
	private String name;

	Store(String name) {
		this.name = name;
	}

	public static Store getStore(String name) {
		if (store == null) {
			store = new Store(name);
		}
		return store;
	}

	private static Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection connection = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/progforce", "root", "root");
		return connection;

	}

	public synchronized void addProduct(int category_id, String title,
			Double price, String status) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		int recordCounter = 0;

		try {

			connection = this.getConnection();
			ps = connection
					.prepareStatement("insert into product(category_id,title,price,status)values('"
							+ category_id
							+ "','"
							+ title
							+ "','"
							+ price
							+ "','" + status + "');");
			recordCounter = ps.executeUpdate();

			System.out.println("Store " + name + ": was added new product "
					+ title + " by " + price + " USD (" + status + ");");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public void getProductsbyStore() throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = this.getConnection();
			ps = connection
					.prepareStatement("select * from store INNER JOIN category ON store.id = category.store_id INNER JOIN product  ON category.id = product.category_id where name ='"
							+ name + "'");
			rs = ps.executeQuery();

			System.out.println("Store " + name + ": ");

			while (rs.next()) {
				System.out.println(rs.getString("title") + ": "
						+ rs.getString("product_category") + " "
						+ rs.getString("price") + " USD ("
						+ rs.getString("status") + ")");
			}

			System.out.println("----------------------------");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public void getProductbyId(int idOfProduct) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			connection = this.getConnection();
			ps = connection
					.prepareStatement("select * from product where id ='"
							+ idOfProduct + "'");
			rs = ps.executeQuery();
			System.out.println("Store " + name + ": ");

			while (rs.next()) {
				System.out.println(rs.getString("title") + " "
						+ rs.getString("price") + " USD ("
						+ rs.getString("status") + ");");
			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public synchronized void setStatusOfProduct(String title, String status)
			throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;

		int recordCounter = 0;
		try {
			connection = this.getConnection();
			ps = connection
					.prepareStatement(" update product set product.status='"
							+ status + "' where product.title='" + title + "' ");
			recordCounter = ps.executeUpdate();

			System.out.println("Store " + name + ": " + title
					+ " status was chanched on " + status + ";");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public synchronized void setPriceOfProduct(String title, Double price)
			throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		int recordCounter = 0;

		try {
			connection = this.getConnection();
			ps = connection
					.prepareStatement(" update product set product.price='"
							+ price + "' where product.title='" + title + "' ");
			recordCounter = ps.executeUpdate();

			System.out.println("Store " + name + ": " + title
					+ " price was chanched on " + price + ";");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}

	}

	public synchronized void changeAllEqualStatusesInCattegorieAndotherHalfonExpectedStatus(
			String oldStatus, String newStatus) throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = this.getConnection();
			ps = connection
					.prepareStatement("select * from store INNER JOIN category ON store.id = category.store_id INNER JOIN product  ON category.id = product.category_id where name ='"
							+ name + "'");
			rs = ps.executeQuery();
			int counter = 0;

			System.out.println("Store " + name + " changing statuses: ");

			while (rs.next()) {

				if (rs.getString("status").equals(oldStatus)) {
					setStatusOfProduct(rs.getString("title"), newStatus);
				} else {
					counter++;
					if ((counter % 2) != 0) {
						setStatusOfProduct(rs.getString("title"), "expected");
					}
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public synchronized void changeAllAvailableStatusesMakeBiggerprice()
			throws SQLException {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			connection = this.getConnection();
			ps = connection
					.prepareStatement("select * from store INNER JOIN category ON store.id = category.store_id INNER JOIN product  ON category.id = product.category_id where name ='"
							+ name + "'");
			rs = ps.executeQuery();
			Double newprice;

			System.out.println("Store " + name + " changing prices: ");

			while (rs.next()) {

				if (rs.getString("status").equals("available")) {
					newprice = makeBigerPrice(Double.parseDouble(rs
							.getString("price")));
					setPriceOfProduct(rs.getString("title"), newprice);
				}

			}

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	private double makeBigerPrice(double oldPrice) {
		return Math.floor((oldPrice * 1.2) * 100) / 100;
	}

	public String getName() {
		return name;
	}

}
