package racoon.service;

import java.util.ArrayList;
import java.util.List;

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

	public void firedManager(int id, String firedManager) {
		dao.firedManager(id, firedManager);
	}
	
	public void addManager(Manager manager) {
		dao.persist(manager);
	}

	public Manager getManagersByCode(int code) {
		return dao.getManagersByCode(code);
	}

	public int getManagersPasswordByCode(int id) {
		return dao.getManagersById(id).getCode();
	}

	public String getManagersNameById(int id) {
		return dao.getManagersById(id).getName();
	}
	public String getManagersMailById(int id) {
		return dao.getManagersById(id).getMail();
	}
	public String getManagersMailByName(String name) {
		return dao.getManagersByName(name).getMail();
	}
	public int getManagerIdByName(String name) {
		return dao.getManagersByName(name).getId();
	}
	public List<Manager> getAllManagers() {
		return dao.getAllManagers();
	}
}
