package lotos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import lotos.model.Deal;

import org.springframework.stereotype.Repository;

@Repository
public class DealDAO {

	@PersistenceContext
	private EntityManager em;
	
	//test
	@SuppressWarnings("unchecked")
	public List<Deal> getAllDeals() {
		return em
				.createQuery("from Deal")
				.getResultList();
	}
	//test
}
