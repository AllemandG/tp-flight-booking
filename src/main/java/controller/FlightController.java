package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import entities.Flight;
import entities.Plane;
import service.FlightService;

public class FlightController {
	private static Scanner scanner = new Scanner(System.in);
	
	private static FlightService service = new FlightService();

	private FlightController() {
	}

	public static void flightMenu() {
		System.out.println("Flghts menu (chose an option) : \n" + "1) Flight creation \n" + "2) Flights list \n"
				+ "3) Flight search by flight number \n" + "4) Flight search by departure and arrival cities");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			flightCreator();
			break;
		case 2:
			flightList();
			break;
		case 3:
			flightSearchByFlightNumber();
			break;
		case 4:
			flightSearchByCities();
			break;
		default:
			System.out.println("Non-valid choice, try again later.");
			break;
		}
	}

	public static void flightCreator() {
		String flightNumber;
		Plane planeType;
		Integer seatsNumber;
		String takeoffCity;
		String landingCity;
		LocalDate departureDate;
		
		System.out.println("Please type in the flight number on an XXXX number format :");
		flightNumber = scanner.next();
		
		System.out.println("Please type in the plane type (A330, A340, A380, B747) :");
		planeType = Plane.valueOf(scanner.next());
		
		System.out.println("Plese enter the number of seats : ");
		seatsNumber = scanner.nextInt();
		
		System.out.println("Please enter the take-off city :");
		takeoffCity = scanner.next();
		
		System.out.println("Please enter the landing city :");
		landingCity = scanner.next();
		
		System.out.println("Please enter the departure date on a yyyymmdd format :");
		departureDate = LocalDate.parse(scanner.next(), DateTimeFormatter.BASIC_ISO_DATE);
		
		Flight flight = new Flight(flightNumber, planeType, seatsNumber, takeoffCity, landingCity, departureDate);
		
		service.flightCreator(flight);
	}

	public static void flightList() {
		List<Flight> flights = service.findAll();
		System.out.println("Flights list :");
		for (Flight f : flights) {
			System.out.println(f);
		}
	}

	public static void flightSearchByFlightNumber() {
		String flightNumber;
		
		System.out.println("Please type in the flight number on an XXXX number format :");
		flightNumber = scanner.next();
		
		Flight flight = service.findByFlightNumber(flightNumber);
		System.out.println(flight);
	}

	public static void flightSearchByCities() {
		String takeoffCity;
		String landingCity;
		
		System.out.println("Please enter the take-off city :");
		takeoffCity = scanner.next();
		
		System.out.println("Please enter the landing city :");
		landingCity = scanner.next();
		
		List<Flight> flights = service.findByCities(takeoffCity, landingCity);
		System.out.println("Flights list :");
		for (Flight f : flights) {
			System.out.println(f);
		}
	}
}
