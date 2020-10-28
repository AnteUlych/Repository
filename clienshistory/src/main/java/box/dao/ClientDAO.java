package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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

}
