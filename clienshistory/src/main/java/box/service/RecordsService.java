package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.RecordsDAO;
import box.model.Records;

@Service("RecordsService")
@Transactional
public class RecordsService {

	@Autowired
	private RecordsDAO dao;
	
	public void addRecords(Records records) {
		dao.persist(records);
	}

	public List<Records> getListOfRecordsByClientId(int clientid) {
		return dao.getListOfRecordsByClientId(clientid);
	}
	
	public List<Records> getListOfRecordsByManagerIdIdAndStatusBetweenDates(int managerid, int recordstatus, String start, String finish) {
		return dao.getListOfRecordsByManagerIdIdAndStatusBetweenDates(managerid, recordstatus, start, finish);
	}
	
	public List<Records> getListOfRecordsByManagerIdsBetweenDates(int managerid, String start, String finish) {
		return dao.getListOfRecordsByManagerIdsBetweenDates(managerid, start, finish);
	}
}
