package beagle.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import beagle.dao.ClientDAO;
import beagle.dao.ManagerDAO;
import beagle.model.Client;
import beagle.model.Manager;

@Service("ManagerService")
public class ManagerService {

	@Autowired
	private ManagerDAO dao;
	
	public List<String> getAllClients() {

		List<Manager> managers = dao.getAllManagers();
		List<String> names = new ArrayList();

		for (Manager name : managers) {
			names.add(name.getName());
		}

		return names;
	}
}
