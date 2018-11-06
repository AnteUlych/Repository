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
	
	public List<Request> getAllRequestsByType(String type){
		return dao.getAllRequestsByType(type);
	}
}
