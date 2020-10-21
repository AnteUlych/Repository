package box.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import box.dao.ManagerDAO;
import box.model.Manager;

@Service("ManagerService")
@Transactional
public class ManagerService {
	
	@Autowired
	private ManagerDAO dao;
	
	public List<Manager> getListOfManagers() {
		return dao.getListOfManagers();
	}

}
