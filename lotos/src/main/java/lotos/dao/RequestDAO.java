package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lotos.model.Proposition;
import lotos.model.Request;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RequestDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequests() {
		return em.createQuery("from Request").getResultList();
	}
	
	public Request getRequestByRequestId(int id) {
		Query query = em.createQuery("from Request where id = '" + id + "'");
		return (Request) query.getSingleResult();
	}
	
	@Transactional
	public void deleteRequest(int requestId) {
		Request request = (Request) em.find(Request.class, requestId);
		Request transaction = em.merge(request);
		em.remove(transaction);
		em.close();
	}

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
