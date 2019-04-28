package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Company;

import org.springframework.stereotype.Repository;


@Repository
public class CompanyDAO {

	@PersistenceContext
	private EntityManager em;
	
	//test
	@SuppressWarnings("unchecked")
	public List<Company> getAllCompanies() {
		return em
				.createQuery("from Company")
				.getResultList();
	}
	//test
}
