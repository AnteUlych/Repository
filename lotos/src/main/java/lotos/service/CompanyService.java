package lotos.service;

import lotos.dao.CompanyDAO;
import lotos.model.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CompanyService")
@Transactional
public class CompanyService {

	@Autowired
	private CompanyDAO dao;

	public int getIdByLoginAndPassword(String mail, String password) {
		try {
			return dao.getCompanyByLoginAndPassword(mail, password).getId();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public Company getCompanyById(int id) {
		return dao.getCompanyById(id);
	}

	public boolean isMailExist(String mail) {
		try {
			dao.getCompanyByMail(mail);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isCodeExist(String code) {
		try {
			dao.getCompanyByCode(code);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
