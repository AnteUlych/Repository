package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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
}
