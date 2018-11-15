package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Proposition;
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
		// max result of requests 250
		int max = 250;
		return em.createQuery("from Request where type = '" + type + "' order by id desc").setMaxResults(max)
				.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByCompany(String company) {
		return em.createQuery("from Request where company = '" + company + "' order by id desc")
				.getResultList();
	}

	public Request getRequestById(int id) {
		Query query = em.createQuery("from Request where id = '" + id + "'");
		return (Request) query.getSingleResult();
	}

	@Transactional
	public void setResultRequest(int id, String result) {

		Request request = (Request) em.find(Request.class, id);

		request.setResult(result);

		Request transaction = em.merge(request);
		em.persist(transaction);
		em.close();
	}

}
