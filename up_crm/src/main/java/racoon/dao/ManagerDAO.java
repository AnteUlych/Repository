package racoon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Manager;

@Repository
public class ManagerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Manager manager) {
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
}
