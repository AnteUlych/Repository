package beagle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beagle.model.Client;


@Repository
public class ClientDAO {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
		return em.createQuery("from Client").getResultList();
	}
	
	public Client getClientByCompany(String company) {
		Query query = em.createQuery("from Client where company = '" + company + "'");
		return (Client) query.getSingleResult();
	}

	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
}
