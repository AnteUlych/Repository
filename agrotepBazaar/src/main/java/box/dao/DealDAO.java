package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Deal;


@Repository
public class DealDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Deal deal) {
		Deal transaction = em.merge(deal);
		em.persist(transaction);
		em.close();
	}

}
