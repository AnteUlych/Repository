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
	public List<Client> getListOfClients(){
		return em.createQuery("from Client").getResultList();
	}

}
