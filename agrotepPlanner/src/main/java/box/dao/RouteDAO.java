package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import box.model.Route;


@Repository
public class RouteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Route> getListOfRoutesBetweenDatesByTruckId(int truckid, String start, String finish) {
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate >='"+start+"' and fromDate <='"+finish+"'").getResultList();
	}

}
