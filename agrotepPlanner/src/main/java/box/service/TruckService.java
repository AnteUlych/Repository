package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.TruckDAO;
import box.logic.Constants;
import box.model.Truck;



@Service("TruckService")
@Transactional
public class TruckService {
	
	@Autowired
	private TruckDAO dao;
	
	public List<Truck> getListOfTrucksSortedByManager() {
		return dao.getListOfTrucksSortedByManager();
	}
	
	public void editTruckPriorityToHighById(int id) {
		dao.editTruckPriorityById(id, Constants.TRUCK_PRIORITY_HIGH);
	}
	
	public void editTruckPriorityToRegularById(int id) {
		dao.editTruckPriorityById(id, Constants.TRUCK_PRIORITY_REGULAR);
	}
	
	public void editTruckCommentById(int id, String comment) {
		dao.editTruckCommentById(id, comment);
	}
	
	public Truck getTruckbyId(int id){
		return dao.getTruckbyId(id);
	}
}
