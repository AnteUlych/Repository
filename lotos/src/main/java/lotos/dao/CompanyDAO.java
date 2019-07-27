package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Company;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public class CompanyDAO {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void editCompany(int id, String manager, String mail, String phone, String mobile, String password, String webaddress) {

		Company company = (Company) em.find(Company.class, id);

		company.setMail(mail);
		company.setManager(manager);
		company.setMobile(mobile);
		company.setPassword(password);
		company.setPhone(phone);
		company.setWebaddress(webaddress);

		Company transaction = em.merge(company);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editCompanyWithAllParameters(int id, String client, String code, String manager, String mail, String phone, String mobile, String password, String webaddress, String youcontrol) {

		Company company = (Company) em.find(Company.class, id);

		company.setCompany(client);
		company.setCode(code);
		company.setMail(mail);
		company.setManager(manager);
		company.setMobile(mobile);
		company.setPassword(password);
		company.setPhone(phone);
		company.setWebaddress(webaddress);
		company.setYoucontrol(youcontrol);

		Company transaction = em.merge(company);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void persist(Company company) {
		Company transaction = em.merge(company);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Company> getAllCompanies() {
		return em.createQuery("from Company").getResultList();
	}
	
	public Company getCompanyByLoginAndPassword(String mail, String password) {
		Query query = em.createQuery("from Company where mail = '" + mail + "' and password = '" + password + "'");
		return (Company) query.getSingleResult();
	}
	
	public Company getCompanyByMail(String mail) {
		Query query = em.createQuery("from Company where mail = '" + mail + "'");
		return (Company) query.getSingleResult();
	}
	public Company getCompanyByCode(String code) {
		Query query = em.createQuery("from Company where code = '" + code + "'");
		return (Company) query.getSingleResult();
	}
	
	public Company getCompanyById(int id) {
		Query query = em.createQuery("from Company where id = '" + id + "'");
		return (Company) query.getSingleResult();
	}
}
