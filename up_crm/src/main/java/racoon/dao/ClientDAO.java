package racoon.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Client;

@Repository
public class ClientDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
}
