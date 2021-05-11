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
}
