package temp;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import box.logic.DataBaseController;
import box.model.Weeklyreminder;

public class MainTest {

	public static void main(String[] args)  {

		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		int todayDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(todayDayOfWeek);
		
	}
}
