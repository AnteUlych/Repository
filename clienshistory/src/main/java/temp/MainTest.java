package temp;

import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Calculates;

public class MainTest {

	public static void main(String[] args) {
		
		DataBaseController base = new DataBaseController();
		
			System.out.println(base.getCalculatesById(2).getCompany());
		
	}

}
