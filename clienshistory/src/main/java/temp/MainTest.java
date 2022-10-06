package temp;

import java.text.ParseException;
import java.util.List;

import box.logic.Countries;
import box.logic.DataBaseController;
import box.model.Calculates;
import box.model.Client;

public class MainTest {

	public static void main(String[] args)  {

		Countries co = new Countries();
		List<String> cs = co.getListOfEuropeCountries();
		
		for(String c:cs) {
		System.out.println(c);
		}
	}
}
