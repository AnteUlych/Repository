package racoon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import racoon.dao.ManagerDAO;
import racoon.model.Manager;

@Service("ManagerService")
@Transactional
public class ManagerService {
	
	@Autowired
	private ManagerDAO dao;
	
	public void addManager(Manager manager) {
		dao.persist(manager);
	}
}
