package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Calculates;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController base = new DataBaseController();
		List<Calculates> cs = base.getListOfCalculates();
		
		for(Calculates c:cs){
			System.out.println(c.getCompany());
		}
		
	}

}
