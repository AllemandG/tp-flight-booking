package service;

import java.util.List;

import dao.FlightDAO;
import entities.Flight;

public class FlightService {
	private FlightDAO dao = new FlightDAO();
	
	public void flightCreator (Flight flight) {
		dao.persist(flight);
	}
	
	public List<Flight> findAll() {
		return dao.findAll();
	}
	
	public List<Flight> findByCities (String takeoffCity, String landingCity) {
		return dao.findByCities(takeoffCity, landingCity);
	}
	
	public Flight findByFlightNumber (String flightNumber) {
		return dao.findByFlightNumber(flightNumber);
	}
	
}
