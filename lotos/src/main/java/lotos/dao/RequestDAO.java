package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Request;

import org.springframework.stereotype.Repository;

@Repository
public class RequestDAO {

	@PersistenceContext
	private EntityManager em;
	
	//test
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequests() {
		return em
				.createQuery("from Request")
				.getResultList();
	}
	//test
}
