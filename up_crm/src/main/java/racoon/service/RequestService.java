package racoon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import racoon.dao.RequestDAO;
import racoon.model.Request;

@Service("RequestService")
@Transactional
public class RequestService {

	@Autowired
	private RequestDAO dao;

	public void addRequest(Request request) {
		dao.persist(request);
	}

	public Request getRequestById(int id) {
		return dao.getRequestById(id);
	}

	public List<Request> getAllRequestsByType(String type) {
		return dao.getAllRequestsByType(type);
	}
	
	public List<Request> getAllRequestsByCompanyBetweenDates(String company, String start, String ending) {
		return dao.getAllRequestsByCompanyBetweenDates(company, start, ending);
	}
	
	public List<Request> getAllRequestsByManagerTypeResultsBetweenDates(String manager, String type, String result, String start, String ending) {
		return dao.getAllRequestsByManagerTypeResultsBetweenDates(manager, type, result, start, ending);
	}

	public List<Request> getAllRequestsByCompany(String company) {
		return dao.getAllRequestsByCompany(company);
	}

	public void setResultRequest(int id, String result) {
		dao.setResultRequest(id, result);
	}

	public List<Request> getAllRequestsByTypeResultsBetweenDates(String type,
			String result, String start, String ending) {
		// TODO Auto-generated method stub
		return dao.getAllRequestsByTypeResultsBetweenDates(type,
				result, start, ending);
	}
}
