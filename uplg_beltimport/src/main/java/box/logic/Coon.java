package box.logic;

public class Coon {

	public static void main(String[] args) {
		
		BeltService s = new BeltService();
		System.out.println(s.getPrice("Paris, FR", "2"));
		System.out.println(s.getDeliveryDate("Paris, FR", "05/14/2018"));
		System.out.println(s.getClientInfo("Oksana"));

	}

}
