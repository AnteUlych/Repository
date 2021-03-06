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
		// max result of requests 500
		int max = 500;
		return em.createQuery("from Request where type = '" + type + "' order by id desc").setMaxResults(max)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByManagerTypeResultsBetweenDates(String manager, String type, String result, String start, String ending) {
		return em.createQuery("from Request where creating >= '" + start+"' and creating <= '"+ ending+"' and result = '"+ result+"' and type = '"+ type+"' and manager = '"+ manager+"' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByManagerTypeBetweenDates(String manager, String type, String start, String ending) {
		return em.createQuery("from Request where creating >= '" + start+"' and creating <= '"+ ending+"'  and type = '"+ type+"' and manager = '"+ manager+"' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByTypeResultsBetweenDates(String type,
			String result, String start, String ending) {
		return em.createQuery("from Request where creating >= '" + start+"' and creating <= '"+ ending+"' and result = '"+ result+"' and type = '"+ type+"' order by id desc")
				.getResultList();
	}


	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByCompany(String company) {
		return em.createQuery("from Request where company = '" + company + "' order by id desc")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Request> getAllRequestsByCompanyBetweenDates(String company, String start, String ending) {
		return em.createQuery("from Request where company = '" + company + "' and creating >= '" + start+"' and creating <= '"+ ending+"'")
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
