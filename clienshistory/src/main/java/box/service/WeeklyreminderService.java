package box.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.WeeklyreminderDAO;
import box.model.Weeklyreminder;



@Service("WeeklyreminderService")
@Transactional
public class WeeklyreminderService {
	
	@Autowired
	private WeeklyreminderDAO dao;
	
	public void addWeeklyReminder(Weeklyreminder weeklyreminder) {
		dao.persist(weeklyreminder);
	}
	
	public List<Weeklyreminder> getListOfWeeklyreminderByClientid(int clientid) {
		return dao.getListOfWeeklyreminderByClientid(clientid);
	}
	
	public List<Weeklyreminder> getListOfWeeklyreminderByManagerId(int managerid) {
		return dao.getListOfWeeklyreminderByManagerId(managerid);
	}
	
	public List<Weeklyreminder> getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(int managerid, int dayofweek) {
		return dao.getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(managerid, dayofweek);
	}
	
	public void editWeeklyreminderCheckById(int id, int isitnotchecked) {
		dao.editWeeklyreminderCheckById(id, isitnotchecked);
	}
	
	public void deleteWeeklyreminderById(int id) {
		dao.deleteWeeklyreminderById(id);
	}
	
	public void editWeeklyreminderById(int id, String color, int isitnotchecked, Date bobdate) {
		dao.editWeeklyreminderById(id, color, isitnotchecked, bobdate);
	}
	
	public int getNumberOfUncheckedWeeklyreminderByManagerIdAndDayofweek(int managerid, int dayofweek) {
		return dao.getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(managerid, dayofweek).size();
	}

}
