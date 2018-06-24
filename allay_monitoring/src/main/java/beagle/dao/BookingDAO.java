package beagle.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import beagle.model.Booking;


@Repository
public class BookingDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void persist(Booking booking) {
		Booking transaction = em.merge(booking);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void editBooking(int id, Booking adjustment) {

		Booking booking = (Booking) em.find(Booking.class, id);
		
		booking.setDelivery(adjustment.getDelivery());
		booking.setLatitude(adjustment.getLatitude());
		booking.setLongitude(adjustment.getLongitude());
		booking.setStatus(adjustment.getStatus());
		booking.setUpdate(adjustment.getUpdate());

		Booking transaction = em.merge(booking);
		em.persist(transaction);
		em.close();
	}
	
	@Transactional
	public void deleteBooking(int id) {
		Booking booking = (Booking) em.find(Booking.class, id);
		Booking transaction = em.merge(booking);
		em.remove(transaction);
		em.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookings() {
		return em.createQuery("from Booking").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Booking> getAllBookingsByClient(String client) {
		return em.createQuery("from Booking  where company = '" + client
								+ "'").getResultList();
	}
	public Booking getBookingByKey(String key) {
		Query query = em.createQuery("from Booking where key = '" + key + "'");
		return (Booking) query.getSingleResult();
	}
}
