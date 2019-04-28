package lotos.service;

import java.util.List;

import lotos.dao.RequestDAO;
import lotos.model.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RequestService")
@Transactional
public class RequestService {

	@Autowired
	private RequestDAO dao;
	//test
	public List<Request> getAllRequests() {
		return dao.getAllRequests();
	}
	//test
}
