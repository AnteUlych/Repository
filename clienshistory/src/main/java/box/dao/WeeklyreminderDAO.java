package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.logic.Constants;

import box.model.Weeklyreminder;


@Repository
public class WeeklyreminderDAO {
	
	Constants constant = new Constants();
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Weeklyreminder weeklyreminder) {
		Weeklyreminder transaction = em.merge(weeklyreminder);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editWeeklyreminderCheckById(int id, int isitnotchecked) {
		Weeklyreminder weeklyreminder = (Weeklyreminder) em.find(Weeklyreminder.class, id);
		
		weeklyreminder.setIsitnotchecked(isitnotchecked);
		
		Weeklyreminder transaction = em.merge(weeklyreminder);
		em.persist(transaction);
		em.close();	
	}
	
	
	
	@Transactional
	public void editWeeklyreminderById(int id, String color, int isitnotchecked, Date bobdate) {
		Weeklyreminder weeklyreminder = (Weeklyreminder) em.find(Weeklyreminder.class, id);
		
		weeklyreminder.setColor(color);
		weeklyreminder.setIsitnotchecked(isitnotchecked);
		weeklyreminder.setBobdate(bobdate);
		
		Weeklyreminder transaction = em.merge(weeklyreminder);
		em.persist(transaction);
		em.close();	
	}
	
	@SuppressWarnings("unchecked")
	public List<Weeklyreminder> getListOfWeeklyreminderByManagerId(int managerid) {
		return em.createQuery("from Weeklyreminder where managerid='"+managerid+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Weeklyreminder> getListOfUncheckedWeeklyreminderByManagerIdAndDayofweek(int managerid, int dayofweek) {
		return em.createQuery("from Weeklyreminder where managerid='"+managerid+"' and dayofweek='"+dayofweek+"' and isitnotchecked='"+constant.UNCHECKED_WEEKLYREMINDER+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Weeklyreminder> getListOfWeeklyreminderByClientid(int clientid) {
		return em.createQuery("from Weeklyreminder where clientid='"+clientid+"'").getResultList();
	}
	
	@Transactional
	public void deleteWeeklyreminderById(int id) {
		Weeklyreminder weeklyreminder = (Weeklyreminder)em.find(Weeklyreminder.class, id);
		Weeklyreminder transaction = em.merge(weeklyreminder);
		em.remove(transaction);
		em.close();
	}
	

}
