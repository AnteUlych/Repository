package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.logic.Constants;
import box.model.Truck;

@Repository
public class TruckDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Truck> getListOfTrucksSortedByManager() {
		return em.createQuery("from Truck order by managerName")
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Truck> getListOfReadyTrucksSortedByManager() {
		return em.createQuery("from Truck where notReady='"+0+"' order by managerName")
				.getResultList();
	}
	
	@Transactional
	public void persist(Truck truck) {
		Truck transaction = em.merge(truck);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editTruckById(int id, String driver, int managerid, int notReady, String phone, String tracktor, String trailer, String type, String managerName) {
		
		Truck truck = (Truck) em.find(Truck.class, id);	
		
		truck.setManagerName(managerName);
		truck.setDriver(driver);
		truck.setManagerid(managerid);
		truck.setNotReady(notReady);
		truck.setPhone(phone);
		truck.setTracktor(tracktor);
		truck.setTrailer(trailer);
		truck.setType(type);
		
		Truck transaction = em.merge(truck);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void editTruckPriorityById(int id, int priority) {

		Truck truck = (Truck) em.find(Truck.class, id);	
		truck.setPriority(priority);
		
		Truck transaction = em.merge(truck);
		em.persist(transaction);
		em.close();

	}
	
	@Transactional
	public void editTruckCommentById(int id, String comment) {
		
		Truck truck = (Truck) em.find(Truck.class, id);
		truck.setComment(comment);
		
		Truck transaction = em.merge(truck);
		em.persist(transaction);
		em.close();

	}
	
	public Truck getTruckbyId(int id) {
		return em.find(Truck.class, id);	

	}
	
	public Truck gettruckByTracktorAndTrailer(String tracktor, String trailer) {
		Query query = em
				.createQuery("from Truck where tracktor = '" + tracktor + "' and trailer='"+trailer+"'");
		return (Truck) query.getSingleResult();
	}

}
