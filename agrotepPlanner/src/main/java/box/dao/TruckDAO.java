package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import box.model.Truck;


@Repository
public class TruckDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Truck> getListOfTrucks() {
		return em.createQuery("from Truck").getResultList();
	}

}
