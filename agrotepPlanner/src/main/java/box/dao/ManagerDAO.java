package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
