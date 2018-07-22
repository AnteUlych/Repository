package beagle.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import beagle.dao.BookingDAO;
import beagle.model.Booking;

@Service("BookingService")
@Transactional
public class BookingService {

	@Autowired
	private BookingDAO dao;

	public void addBooking(Booking booking) {
		dao.persist(booking);
	}

	public void editBooking(int id, Booking booking) {
		dao.editBooking(id, booking);
	}

	public void deleteBooking(int id) {
		dao.deleteBooking(id);
	}

	public List<Booking> getAllBookings() {
		return dao.getAllBookings();
	}

	public List<Booking> getAllBookingsByClient(String company) {
		return dao.getAllBookingsByClient(company);
	}

	public Booking getBookingByKey(String key) {
		return dao.getBookingByKey(key);
	}

}
