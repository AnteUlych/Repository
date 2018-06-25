package beagle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import beagle.model.Client;
import beagle.model.Manager;

@Repository
public class ManagerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers() {
		return em.createQuery("from Manager").getResultList();
	}
}
