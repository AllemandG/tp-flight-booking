package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Flight;

public class FlightDAO extends GenericDAO<Flight>{
	public FlightDAO () {
		super(Flight.class);
	}
	
	public List<Flight> findAll () {
		List<Flight> flights = new ArrayList<>();
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Flight> query = em.createQuery(
				"select f "
				+ "from Flight f "
				+ "left join fetch f.bookings bookings", Flight.class);
		flights = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return flights;
	}
	
	public List<Flight> findByCities (String takeoffCity, String landingCity) {
		List<Flight> flights = new ArrayList<>();
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Flight> query = em.createQuery(
				"select f "
				+ "from Flight f "
				+ "left join fetch f.bookings b "
				+ "where takeoffCity = :tc and landingCity = :lc", Flight.class);
		query.setParameter("tc", takeoffCity);
		query.setParameter("lc", landingCity);
		flights = query.getResultList();
		DatabaseHelper.commitTxAndClose(em);
		return flights;
	}
	
	public Flight findByFlightNumber (String flightNumber) {
		Flight flight;
		EntityManager em = DatabaseHelper.createEntityManager();
		DatabaseHelper.beginTx(em);
		TypedQuery<Flight> query = em.createQuery(
				"select f "
				+ "from Flight f "
				+ "left join fetch f.bookings b "
				+ "where f.flightNumber = :fn", Flight.class);
		query.setParameter("fn", flightNumber);
		flight = query.getSingleResult();
		DatabaseHelper.commitTxAndClose(em);
		return flight;
	}
}
