package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.logic.Constants;
import box.model.Manager;

@Repository
public class ManagerDAO {

	Constants constant = new Constants();

	@PersistenceContext
	private EntityManager em;

	public Manager getManagersByCode(String code) {
		Query query = em
				.createQuery("from Manager where code = '" + code + "'");
		return (Manager) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<Manager> getListOfManagers() {
		return em.createQuery("from Manager").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Manager> getListOfNotAdminManagers() {
		return em.createQuery(
				"from Manager where rank != '" + constant.MANAGER_RANK_ADMIN
						+ "' and rank != '" + constant.MANAGER_RANK_FIRED+"'").getResultList();
	}
	
	public Manager getManagerById(int id){
		Manager manager = (Manager) em.find(Manager.class, id);
		return manager;
	}
	
	public void firedManagerById(int id){
		
		Manager manager = (Manager) em.find(Manager.class, id);
		manager.setName(manager.getName()+" (םו ןנאצ‏÷)");
		manager.setRank(constant.MANAGER_RANK_FIRED);
		
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
	public void persist(Manager manager) {
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editManagerById(int id, String name, String mail, String code, int rank) {
		Manager manager = (Manager) em.find(Manager.class, id);
		
		manager.setCode(code);
		manager.setMail(mail);
		manager.setName(name);
		manager.setRank(rank);
		
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
		
	}
	

}
