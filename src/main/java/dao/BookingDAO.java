package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Booking;

public class BookingDAO extends GenericDAO<Booking>{
	public BookingDAO () {
		super(Booking.class);
	}
	
	
	public List<Booking> findAll() {
		List<Booking> bookings = new ArrayList<>();
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Booking> query = em.createQuery(
				"select b "
				+ "from Booking b ", Booking.class);
		bookings = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return bookings;
	}
	
	public List<Booking> findByName (String lastname, String firstName) {
		List<Booking> bookings = new ArrayList<>();
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Booking> query = em.createQuery(
				"select b "
				+ "from Booking b "
				+ "where b.lastname = :ln and b.firstname = :fn", Booking.class);
		query.setParameter("ln", lastname);
		query.setParameter("fn", firstName);
		bookings = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return bookings;
	}
	
	public List<Booking> findByFlightNumber (String flightNumber) {
		List<Booking> bookings = new ArrayList<>();
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Booking> query = em.createQuery(
				"select b "
				+ "from Booking b "
				+ "left join b.flight f "
				+ "where f.flightNumber = :fn", Booking.class);
		query.setParameter("fn", flightNumber);
		bookings = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return bookings;
	}
	
	public void delete (Booking b) {
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		Booking temp = em.find(Booking.class, b.getId());
		em.remove(temp);
		DatabaseHelper.commitTxAndClose(em);
	}
	
}
