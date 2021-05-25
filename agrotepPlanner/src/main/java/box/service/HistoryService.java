package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.HistoryDAO;
import box.model.History;


@Service("HistoryService")
@Transactional
public class HistoryService {

	@Autowired
	private HistoryDAO dao;
	
	public List<History> getListOfHistory() {
		return dao.getListOfHistory();
	}
	
	public void addHistory(History history) {
		dao.persist(history);
	}
	
	public List<History> getListOfHistoryByManageridBetweenDatesReverse(String start, String finish, int managerid) {
		return dao.getListOfHistoryByManageridBetweenDatesReverse(start, finish, managerid);
	}
	public List<History> getListOfHistoryByActionAndManageridBetweenDates(String start, String finish, int managerid, int action) {
		return dao.getListOfHistoryByActionAndManageridBetweenDates(start, finish, managerid, action);
	}
	
	public List<History> getListOfHistoryByManageridBetweenDates(String start, String finish, int managerid) {
	return dao.getListOfHistoryByManageridBetweenDates(start, finish, managerid);	
	}
}
