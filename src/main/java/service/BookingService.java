package service;

import java.util.List;

import dao.BookingDAO;
import entities.Booking;

public class BookingService {
	private BookingDAO dao = new BookingDAO();
	
	public void bookingCreator (Booking booking) {
		String bookingNumber;
		dao.persist(booking);
		bookingNumber = booking.getFlight().getFlightNumber() + "-" + booking.getId();
		booking.setBookingNumber(bookingNumber);
		dao.update(booking);
	}
	
	public Booking find (Integer id) {
		return dao.find(id.longValue());
	}
	
	public List<Booking> findAll() {
		return dao.findAll();
	}
	
	public List<Booking> findByName (String lastname, String firstname) {
		return dao.findByName(lastname, firstname);
	}
	
	public List<Booking> findByFlightNumber (String flightNumber) {
		return dao.findByFlightNumber(flightNumber);
	}
	
	public void delete (Booking booking) {
		dao.delete(booking);
	}
	
}
