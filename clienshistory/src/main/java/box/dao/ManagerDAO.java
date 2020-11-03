package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

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

}
