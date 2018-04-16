package helper;

import calculator.logic.ServiceCalculator;
import calculator.logic.TransportData;

public class Helper {

	public static void main(String[] args) {

		TransportData base = new TransportData();
		String data = base.createTheRoute("Foshan", "Lviv");
		
		ServiceCalculator test = new ServiceCalculator(data,2,2);
		System.out.println(test.isRailRatePossible());
		System.out.println(test.getSeaRate());
		System.out.println(test.getRailRate());
		System.out.println(test.getRailTime());
		System.out.println(test.getSeaTime());
		System.out.println(test.getWay());
	}

}
