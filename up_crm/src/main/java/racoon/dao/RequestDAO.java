package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Request;



@Repository
public class RequestDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Request request) {
		Request transaction = em.merge(request);
		em.persist(transaction);
		em.close();
	}
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByType(String type) {
		return em.createQuery("from Request where type = '" + type + "'")
				.getResultList();
	}

}
