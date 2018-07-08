package beagle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beagle.dao.ManagerDAO;
import beagle.model.Manager;

@Service("ManagerService")
public class ManagerService {

	@Autowired
	private ManagerDAO dao;
	
	public void addManager(Manager manager) {
		dao.persist(manager);
	}
	
	public List<String> getAllManagers() {

		List<Manager> managers = dao.getAllManagers();
		List<String> names = new ArrayList();

		for (Manager name : managers) {
			names.add(name.getName());
		}

		return names;
	}
	
	public List<Manager> getAllManagersInfo() {	
		return dao.getAllManagers();
	}
	
	public void deleteManager(int id) {
		dao.deleteManager(id);	
	}
	
	public void editManager(int id, String mail, String phone) {
		dao.editManager(id, mail, phone);
	}
	
	public Manager getManagerByName(String name) {
		return dao.getManagerByName(name);
	}
}
