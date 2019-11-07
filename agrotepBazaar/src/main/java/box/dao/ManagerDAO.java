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
	
	@Transactional
	public void persist(Manager manager) {
		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Manager> getListOfManagers() {
		return em.createQuery(
				"from Manager").getResultList();
	}
	
	public Manager getManagersByCode(String code) {
		Query query = em
				.createQuery("from Manager where code = '" + code + "'");
		return (Manager) query.getSingleResult();
	}
	
	@Transactional
	public void editManager(int id, String name, String mail, String rank, String code) {

		Manager manager = (Manager) em.find(Manager.class, id);

		manager.setMail(mail);
		manager.setName(name);
		manager.setRank(rank);
		manager.setCode(code);

		Manager transaction = em.merge(manager);
		em.persist(transaction);
		em.close();

	}
	
	public Manager getManagerById(int id) {

		Manager manager = (Manager) em.find(Manager.class, id);
		return manager;

	}

}
