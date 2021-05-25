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
	public List<History> getListOfHistoryByActionAndManageridBetweenDates(String start, String finish, int managerid, int action) {
		return em.createQuery("from History where managerid='"+managerid+"' and action='"+action+"' and actionDate >='"+start+"' and actionDate <='"+finish+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<History> getListOfHistoryByManageridBetweenDates(String start, String finish, int managerid) {
		return em.createQuery("from History where managerid='"+managerid+"' and actionDate >='"+start+"' and actionDate <='"+finish+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<History> getListOfHistoryByManageridBetweenDatesReverse(String start, String finish, int managerid) {
		return em.createQuery("from History where managerid='"+managerid+"' and actionDate >='"+start+"' and actionDate <='"+finish+"'order by id desc").getResultList();
	}
	
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
	
	@Transactional
	public void deleteHistory(int id) {
		History history = (History) em.find(History.class, id);
		History transaction = em.merge(history);
		em.remove(transaction);
		em.close();
	}

}
