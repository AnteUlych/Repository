package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import box.model.History;


@Repository
public class HistoryDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<History> getListOfHistory() {
		return em.createQuery("from History").getResultList();
	}

}
