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
	
	public Manager getManagerById(int id){
		return dao.getManagerById(id);
	}
	
	public void firedManagerById(int id){
		dao.firedManagerById(id);
	}
	
	public void deleteManager(int id) {
		dao.deleteManager(id);
	}
	
	public void addManager(Manager manager){
		dao.persist(manager);
	}
	
	public void editManagerById(int id, String name, String mail, String code, int rank) {
		dao.editManagerById(id, name, mail, code, rank);
	}

}
