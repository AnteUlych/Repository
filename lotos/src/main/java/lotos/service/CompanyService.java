package lotos.service;

import java.util.List;

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
	
	public void editCompany(int id, String manager, String mail, String phone, String mobile, String password, String webaddress) {
		dao.editCompany(id, manager, mail, phone, mobile, password, webaddress);
	}
	
	public List<Company> getAllCompanies() {
		return dao.getAllCompanies();
	}
	
	public void addCompany(String company, String code, String manager, String mail, String phone, String mobile, String password, String webaddress, String youcontrol, String registration) {
		
		Company client = new Company();
		
		client.setCompany(company);
		client.setCode(code);
		client.setManager(manager);
		client.setMail(mail);
		client.setPhone(phone);
		client.setMobile(mobile);
		client.setPassword(password);
		client.setWebaddress(webaddress);
		client.setYoucontrol(youcontrol);
		client.setRegistration(registration);
		
		dao.persist(client);
		
	}

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
