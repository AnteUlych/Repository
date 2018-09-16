package racoon.service;

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
}
