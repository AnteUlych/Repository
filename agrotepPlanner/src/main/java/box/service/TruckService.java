package box.service;

import java.util.ArrayList;
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
	
	public List<Truck> getListOfReadyTrucksByManagerId(int managerid) {
		return dao.getListOfReadyTrucksByManagerId(managerid);
	}
	
	public boolean isManagerHasReadyTruck(int managerid){
	List<Truck> trucks = dao.getListOfReadyTrucksSortedByManager();
		
		for(Truck t:trucks){
			if(t.getManagerid()==managerid){
				return true;
			}
		}
		return false;
	}
	
	public boolean isManagerHasTruck(int managerid){
		List<Truck> trucks = dao.getListOfTrucksSortedByManager();
		
		for(Truck t:trucks){
			if(t.getManagerid()==managerid){
				return true;
			}
		}
		return false;
	}
	
	public List<Truck> getListOfTrucksSortedByManager() {
		return dao.getListOfTrucksSortedByManager();
	}
	
	public void addTruck(Truck truck){
		dao.persist(truck);
	}
	
	public void editTruckById(int id, String driver, int managerid, int notReady, String phone, String tracktor, String trailer, String type, String managerName, String truckKey) {
		dao.editTruckById(id, driver, managerid, notReady, phone, tracktor, trailer, type, managerName, truckKey);
	}
	
	public List<Truck> getListOfReadyTrucksSortedByManager() {
		return dao.getListOfReadyTrucksSortedByManager();
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
	
	public Truck gettruckByTracktorAndTrailer(String tracktor, String trailer) {
		return dao.gettruckByTracktorAndTrailer(tracktor, trailer);
	}
	
	public void editTruckKmruptela0131tById(int id, int kmruptela0131, double uahkmruptela0131) {
		dao.editTruckKmruptela0131tById(id, kmruptela0131, uahkmruptela0131);
	}
	
	public void editTruckNoremontdaysById(int id, int noremontdays) {
		dao.editTruckNoremontdaysById(id, noremontdays);
	}
}
