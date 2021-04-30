package temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import box.logic.CalendarLogic;
import box.logic.DataBaseController;
import box.model.Direction;
import box.model.History;
import box.model.Manager;
import box.model.Route;
import box.model.Truck;


public class MainCoon {

	public static void main(String[] args) {
		
		// DataBaseController d = new DataBaseController();
       // String text = "1112";
		//System.out.println(d.isManagerExisByLoginPass(text));
		//System.out.println(d.getManagersByLoginPass(text).getName());
		
		CalendarLogic c = new CalendarLogic();
		//System.out.println(c.isDayTheWeekend("2021-05-03"));
		System.out.println(c.getHeaderDate("2021-05-03"));
		
		
		//System.out.println(now);
		//System.out.println(need);
		//boolean how = d.isListOfRoutesBetweenDatesByTruckIdExist(2,"2021-06-26", "2021-06-28");
		
		
		//System.out.println(how);
		
		
	}

}
