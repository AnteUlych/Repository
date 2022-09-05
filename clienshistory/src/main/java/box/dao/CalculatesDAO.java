package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import box.model.Calculates;

public class CalculatesDAO {
	
	@PersistenceContext
	private EntityManager em;
	//test
	@SuppressWarnings("unchecked")
	public List<Calculates> getListOfCalculates(){
		return em.createQuery("from Calculates").getResultList();
	}

}
