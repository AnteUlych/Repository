package box.service;

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
	
	public boolean isManagerExisByLoginPass(String loginPass){
		
		try {
			dao.getManagersByLoginPass(loginPass);
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}
	
	public Manager getManagersByLoginPass(String loginPass) {
		Manager manager = dao.getManagersByLoginPass(loginPass);
		return manager;
	}
	
}
