package controller;

import java.util.List;
import java.util.Scanner;

import entities.Booking;
import entities.Flight;
import service.BookingService;
import service.FlightService;

public class BookingController {
	private static Scanner scanner = new Scanner(System.in);

	private static BookingService service = new BookingService();
	private static FlightService flightService = new FlightService();

	private BookingController() {
	}

	public static void bookingMenu() {
		System.out.println("Booking menu (chose an option) : \n" + "1) Booking creation \n" + "2) Booking list \n"
				+ "3) Booking search by flight number \n" + "4) Booking search by name \n" + "5) Booking deleting by id");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1:
			bookingCreator();
			break;
		case 2:
			bookingList();
			break;
		case 3:
			bookingSearchByFlightNumber();
			break;
		case 4:
			bookingSearchByName();
			break;
		case 5:
			bookingDelete();
			break;
		default:
			System.out.println("Non-valid choice, try again later.");
			break;
		}
	}

	public static void bookingCreator() {
		String lastname;
		String firstname;
		Integer age;
		String flightNumber;
		
		System.out.println("Please enter the lastname : ");
		lastname = scanner.next();
		
		System.out.println("Please enter the firstname : ");
		firstname = scanner.next();
		
		System.out.println("Please enter the age : ");
		age = scanner.nextInt();
		
		System.out.println("Please type in the flight number on an XXXX number format :");
		flightNumber = scanner.next();
		
		Booking booking = new Booking(lastname, firstname, age);
		Flight flight = flightService.findByFlightNumber(flightNumber);
		
		booking.setFlight(flight);
		
		service.bookingCreator(booking);
	}

	public static void bookingList() {
		List<Booking> bookings = service.findAll();
		System.out.println("Booking list :");
		for (Booking b : bookings) {
			System.out.println(b);
		}
	}

	public static void bookingSearchByFlightNumber() {
		String flightNumber;
		
		System.out.println("Please type in the flight number on an XXXX number format :");
		flightNumber = scanner.next();
		
		List<Booking> bookings = service.findByFlightNumber(flightNumber);
		System.out.println("Booking list :");
		for (Booking b : bookings) {
			System.out.println(b);
		}
	}

	public static void bookingSearchByName() {
		String lastname;
		String firstname;
		
		System.out.println("Please enter the lastname : ");
		lastname = scanner.next();
		
		System.out.println("Please enter the firstname : ");
		firstname = scanner.next();
		
		List<Booking> bookings = service.findByName(lastname, firstname);
		System.out.println("Booking list :");
		for (Booking b : bookings) {
			System.out.println(b);
		}
	}

	public static void bookingDelete() {
		Integer id;
		
		System.out.println("Please enter the id of the booking to be deleted : ");
		id = scanner.nextInt();
		
		service.delete(service.find(id));
	}
}
