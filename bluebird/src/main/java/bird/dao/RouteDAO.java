package bird.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bird.model.Route;

@Repository
public class RouteDAO {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	public List<Route> getAllRouteByCargoId(int cargoID) {

		return em
				.createQuery(
						"from Route where cargoId = '" + cargoID
								+ "' order by id desc").getResultList();
	}
	
	public Route getRouteBy(int id) {
		Query query = em.createQuery("from Route where id = '" + id + "'");
		return (Route) query.getSingleResult();
	}

	@Transactional
	public void persist(Route route) {
		Route transaction = em.merge(route);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void editRoute(int id, double longitude, double latitude,
			String status) {

		Route route = (Route) em.find(Route.class, id);

		route.setLatitude(latitude);
		route.setLongitude(longitude);
		route.setStatus(status);

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
}