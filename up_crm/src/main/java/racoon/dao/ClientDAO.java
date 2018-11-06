package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	@SuppressWarnings("unchecked")
	public List<Client> getAllClientsByManager(String manager) {
		return em.createQuery("from Client where manager = '" + manager
				+ "' order by nextcall").getResultList();
	}
	
	public Client getClientById(int id) {
		Query query = em.createQuery("from Client where id = '" + id + "'");
		return (Client) query.getSingleResult();
	}
}
