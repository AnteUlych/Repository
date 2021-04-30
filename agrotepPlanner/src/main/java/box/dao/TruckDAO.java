package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
