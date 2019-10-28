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
