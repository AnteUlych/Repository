package box.service;

import java.util.List;

import javax.persistence.NoResultException;

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
	
	public boolean isManagerExisByCode(String code){
		
		try {
			dao.getManagersByCode(code);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public Manager getManagersByCode(String code) {
		Manager manager = dao.getManagersByCode(code);
		return manager;
	}
	
	public List<Manager> getListOfManagers() {
		return dao.getListOfManagers();
	}
	
	public List<Manager> getListOfNotAdminManagers() {
		return dao.getListOfNotAdminManagers();
	}

}
