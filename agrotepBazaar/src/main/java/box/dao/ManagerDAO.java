package box.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import box.model.Manager;


@Repository
public class ManagerDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public Manager getManagersByCode(String code) {
		Query query = em
				.createQuery("from Manager where code = '" + code + "'");
		return (Manager) query.getSingleResult();
	}

}
