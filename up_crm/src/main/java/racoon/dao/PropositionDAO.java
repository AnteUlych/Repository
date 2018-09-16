package racoon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Proposition;

@Repository
public class PropositionDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Proposition proposition) {
		Proposition transaction = em.merge(proposition);
		em.persist(transaction);
		em.close();
	}

}
