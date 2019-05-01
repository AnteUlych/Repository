package lotos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Company;

import org.springframework.stereotype.Repository;


@Repository
public class CompanyDAO {

	@PersistenceContext
	private EntityManager em;

	
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
}
