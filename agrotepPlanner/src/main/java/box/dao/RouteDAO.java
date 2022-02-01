package box.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.logic.Constants;
import box.model.Route;


@Repository
public class RouteDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Route> getListOfRoutesBetweenDatesByTruckIdForHistory(int truckid, String start, String finish) {
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate >='"+start+"' and routeStatus <>'2' and fromDate <='"+finish+"'").getResultList();
	}
	
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
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate <='"+finish+"' order by fromDate desc").setMaxResults(1).getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getLastTenRoutesByTruckId(int truckid, String finish){
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate <='"+finish+"' order by fromDate desc").setMaxResults(10).getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getListOfRoutesByRouteStatusBetweenDates(int routeStatus, String start, String finish){
		return em.createQuery("from Route where routeStatus='"+routeStatus+"' and fromDate <='"+finish+"' and fromDate >='"+start+"'").getResultList();		
	}
	
	@Transactional
	public void persist(Route route) {
		Route transaction = em.merge(route);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteRoute(int id) {
		Route route = (Route) em.find(Route.class, id);
		Route transaction = em.merge(route);
		em.remove(transaction);
		em.close();
	}
	
	public Route getRouteById(int id){
		Route route = (Route) em.find(Route.class, id);
		return route;
	}
	
	@SuppressWarnings("unchecked")
	public List<Route> getLastRemontRouteByTruckId(int truckid, String finish){
		return em.createQuery("from Route where truckid='"+truckid+"' and fromDate <='"+finish+"' and routeStatus ='"+Constants.TRUCK_REMOMT+"' order by fromDate desc").setMaxResults(1).getResultList();		
	}
	

}
