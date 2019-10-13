package box.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import box.model.Transport;



@Repository
public class TransportDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void persist(Transport transport) {
		Transport transaction = em.merge(transport);
		em.persist(transaction);
		em.close();
	}
	
	public Transport getTransportById(int id) {
		Transport transport = (Transport) em.find(Transport.class, id);
		return transport;
	}
	
	@SuppressWarnings("unchecked")
	public List<Transport> getAllTransportByDirection(String direction) {
		return em.createQuery("from Transport where direction = '" + direction + "' order by id desc")
				.getResultList();
	}
	
	@Transactional
	public void setTransportStatus(int id, String status) {

		Transport transport = (Transport) em.find(Transport.class, id);
		transport.setStatus(status);
		Transport transaction = em.merge(transport);
		em.persist(transaction);
		em.close();
	}

	@Transactional
	public void setTransportTruckdriver(int id, String truckdriver) {

		Transport transport = (Transport) em.find(Transport.class, id);
		transport.setTruckdriver(truckdriver);
		Transport transaction = em.merge(transport);
		em.persist(transaction);
		em.close();
	}
}
