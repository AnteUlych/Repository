package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.History;


@Repository
public class HistoryDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<History> getListOfHistory() {
		return em.createQuery("from History").getResultList();
	}
	
	@Transactional
	public void persist(History history) {
		History transaction = em.merge(history);
		em.persist(transaction);
		em.close();
	}

}
