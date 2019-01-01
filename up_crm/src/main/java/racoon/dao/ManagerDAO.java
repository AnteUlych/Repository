package racoon.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import racoon.model.Manager;


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

	public Manager getManagersByCode(int code) {
		Query query = em
				.createQuery("from Manager where code = '" + code + "'");
		return (Manager) query.getSingleResult();
	}

	public Manager getManagersById(int id) {
		Query query = em.createQuery("from Manager where id = '" + id + "'");
		return (Manager) query.getSingleResult();
	}
	public Manager getManagersByName(String name) {
		Query query = em.createQuery("from Manager where name = '" + name + "'");
		return (Manager) query.getSingleResult();
	}
	@SuppressWarnings("unchecked")
	public List<Manager> getAllManagers() {
		return em
				.createQuery("from Manager")
				.getResultList();
	}
}
