package racoon.dao;

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

}
