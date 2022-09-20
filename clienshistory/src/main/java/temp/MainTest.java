package temp;

import java.text.ParseException;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Calculates;

public class MainTest {

	public static void main(String[] args) throws ParseException {

		DataBaseController b = new DataBaseController();
		List<Calculates> cs = b.getListOfCalculatesBetweenDatesByManagerId(
				"2022-09-08", "2022-09-09", 7);

		System.out.println();
	}
}
