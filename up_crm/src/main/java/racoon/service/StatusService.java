package racoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import racoon.dao.StatusDAO;
import racoon.model.Status;


@Service("StatusService")
@Transactional
public class StatusService {

	@Autowired
	private StatusDAO dao;
	
	public void addStatus(Status status) {
		dao.persist(status);
	}
}
