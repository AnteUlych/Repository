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
	
	public void addManager(Manager manager){
		dao.persist(manager);
	}
	
	public List<Manager> getListOfManagers() {
		return dao.getListOfManagers();
	}
	
	public void editManager(int id, String name, String mail, String rank, String code) {
		dao.editManager(id, name, mail, rank, code);
	}
	
	public Manager getManagerById(int id) {
		return dao.getManagerById(id);
	}
	
	public Manager getManagersByCode(String code) {
		return dao.getManagersByCode(code);
	}
	
	public boolean isCodeOfManagerExist(String code){
		
		try {
			Manager manager = dao.getManagersByCode(code);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

}
