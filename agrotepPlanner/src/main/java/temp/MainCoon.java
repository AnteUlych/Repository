package temp;

import java.util.List;

import box.logic.DataBaseController;
import box.model.Direction;
import box.model.History;
import box.model.Manager;
import box.model.Route;


public class MainCoon {

	public static void main(String[] args) {
		
		DataBaseController d = new DataBaseController();
		List<Manager> ts = d.getListOfManagers();
		
		for(Manager t:ts){
			System.out.println(t.getId()+" "+t.getName());
		}
	}

}
