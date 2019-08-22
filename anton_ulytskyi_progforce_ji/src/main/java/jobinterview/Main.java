package jobinterview;

import java.sql.SQLException;
import java.text.DecimalFormat;

/**Tasks:
1.Create Store Class using fabric method;
2. Class Store must be Singleton;
3. In Class Store create methods which allow add, get products 
and change their price and category;
4. Create two Stores and run them in different Threads in 10 seconds;
5. I one of category change all status on "absent" and at half other 
products change status on "expected";
6. All goods which available make price on 20% higher;
7. Say in console about stopping threads.
*/
public class Main {

	public static void main(String[] args) {

		CompanyFactory companyFactory = new CompanyFactory();
		final Company catStore = companyFactory.getCompany("Happy Cat");
		final Company dogStore = companyFactory.getCompany("Lucky Dog");

		Thread firstThread = new Thread(new Runnable() {
			public void run() {

				try {
					catStore.addProduct(1, "product1", 12.54, "available");
					catStore.addProduct(1, "product2", 152.54, "expected");
					catStore.addProduct(1, "product3", 121.54, "absent");
					catStore.addProduct(2, "product4", 17.54, "available");
					catStore.addProduct(2, "product5", 14.54, "expected");
					catStore.addProduct(2, "product6", 2.54, "absent");

					doTechnicalTask(catStore);

				} catch (SQLException e) {
					e.printStackTrace();
				}

			}
		});
		firstThread.start();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		Thread secondThread = new Thread(new Runnable() {
			public void run() {
				try {
					dogStore.addProduct(3, "product7", 12.54, "available");
					dogStore.addProduct(3, "product8", 152.54, "expected");
					dogStore.addProduct(3, "product9", 121.54, "absent");
					dogStore.addProduct(4, "product10", 17.54, "available");
					dogStore.addProduct(4, "product11", 14.54, "expected");
					dogStore.addProduct(4, "product12", 2.54, "absent");

					doTechnicalTask(dogStore);

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		secondThread.start();

		System.out.println("Main Thread is done!");

	}

	private static void doTechnicalTask(Company company) throws SQLException {

		company.changeAllEqualStatusesInCattegorieAndotherHalfonExpectedStatus(
				"expected", "absent");
		company.changeAllAvailableStatusesMakeBiggerprice();

		System.out.println("Work with store " + company.getName()
				+ " has done.");
	}

}
