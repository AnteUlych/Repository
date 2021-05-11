package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Route;


@Repository
public class RouteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Route> getListOfRoutesBetweenDatesByTruckId(int truckid, String start, String finish) {
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate >='"+start+"' and fromDate <='"+finish+"'").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getLastRouteBetweenDatesByTruckId(int truckid, String start, String finish) {
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate >='"+start+"' and fromDate <='"+finish+"' order by id").setMaxResults(1).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getLastRouteByTruckId(int truckid, String finish){
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate <='"+finish+"' order by id").setMaxResults(1).getResultList();		
	}
	
	@Transactional
	public void persist(Route route) {
		Route transaction = em.merge(route);
		em.persist(transaction);
		em.close();
	}

}
