package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Client;

@Repository
public class ClientDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsByManagerIdSortedByNexcall(int managerid) {
		return em.createQuery(
				"from Client where managerid = '" + managerid + "' order by nextcall")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getClientsSortedByNextcall() {
		return em.createQuery(
				"from Client order by nextcall")
				.getResultList();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getListOfClients(){
		return em.createQuery("from Client").getResultList();
	}
	
	@Transactional
	public void persist(Client client) {
		Client transaction = em.merge(client);
		em.persist(transaction);
		em.close();
	}
	
	public Client getClientByERDPO(String edrpo) {
		Query query = em
				.createQuery("from Client where edrpo = '" + edrpo + "'");
		return (Client) query.getSingleResult();
	}
	
	public Client getClientById(int id){
		Client client = (Client) em.find(Client.class, id);
		return client;
	}

}
