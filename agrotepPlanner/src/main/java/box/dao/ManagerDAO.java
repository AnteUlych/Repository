package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Manager;

@Repository
public class ManagerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Manager> getListOfManagers(){
		return em.createQuery("from Manager").getResultList();
	}
	
	public Manager getManagersByLoginPass(String loginPass) {
		Query query = em
				.createQuery("from Manager where loginPass = '" + loginPass + "'");
		return (Manager) query.getSingleResult();
	}
	
	public Manager getManagersByName(String name) {
		Query query = em
				.createQuery("from Manager where name = '" + name + "'");
		return (Manager) query.getSingleResult();
	}
	
	public Manager getManagerById(int id){
		Manager manager = (Manager) em.find(Manager.class, id);
		return manager;
	}
	
	@Transactional
	public void persist(Manager manager) {
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteManagerById(int managerid) {
		Manager manager = (Manager) em.find(Manager.class, managerid);
		Manager transaction = em.merge(manager);
		em.remove(transaction);
		em.close();
	}
	
	@Transactional
	public void editCodeManagerById(int id, String code) {

		Manager manager = (Manager) em.find(Manager.class, id);	
		
		manager.setLoginPass(code);
		
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();

	}
}
