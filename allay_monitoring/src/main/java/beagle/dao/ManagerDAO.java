package beagle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beagle.model.Booking;
import beagle.model.Manager;

@Repository
public class ManagerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers() {
		return em.createQuery("from Manager").getResultList();
	}
	
	@Transactional
	public void persist(Manager manager) {
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteManager(int id) {
		Manager manager = (Manager) em.find(Manager.class, id);
		Manager transaction = em.merge(manager);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void editManager(int id, String mail, String phone) {

		Manager manager = (Manager) em.find(Manager.class, id);
		
		manager.setMail(mail);
		manager.setPhone(phone);

		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
	
	public Manager getManagerByName(String name) {
		Query query = em.createQuery("from Manager where name = '" + name + "'");
		return (Manager) query.getSingleResult();
	}
}
