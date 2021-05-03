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
		
		 DataBaseController d = new DataBaseController();
       // String text = "1112";
		//System.out.println(d.isManagerExisByLoginPass(text));
		//System.out.println(d.getManagersByLoginPass(text).getName());

		 System.out.println(d.getLastRouteByTruckId(1, "2021-07-04").getToOblast());
		 System.out.println(d.getLastRouteByTruckId(2, "2021-07-04").getToOblast());
		 System.out.println(d.getLastRouteByTruckId(3, "2021-07-04").getToOblast());
		
		//System.out.println(now);
		//System.out.println(need);
		//boolean how = d.isListOfRoutesBetweenDatesByTruckIdExist(2,"2021-06-26", "2021-06-28");
		
		
		//System.out.println(how);
		
		
	}

}
