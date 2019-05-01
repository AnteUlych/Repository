package lotos.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Request;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RequestDAO {

	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public void persist(Request company) {
		Request transaction = em.merge(company);
		em.persist(transaction);
		em.close();
	}
	
	public Request getRequestByMail(String mail) {
		Query query = em.createQuery("from Request where mail = '" + mail + "'");
		return (Request) query.getSingleResult();
	}
	public Request getRequestByCode(String code) {
		Query query = em.createQuery("from Request where code = '" + code + "'");
		return (Request) query.getSingleResult();
	}
}
