package app;

import java.util.Scanner;

import controller.BookingController;
import controller.FlightController;

public class App {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int choice = 0;
		while (choice != 3) {
			choice = menu();
			
			switch (choice) {
			case 1:
				FlightController.flightMenu();
				break;
			case 2:
				BookingController.bookingMenu();
				break;
			case 3:
				System.out.println("Have a good day!");
				break;
			default:
				choice = 0;
				break;
			}
		}
	}

	private static int menu() {
		System.out.println("Main menu (chose an option) : \n" + "1) Flight menu \n" + "2) Booking \n" + "3) Quit ");
		int choice = scanner.nextInt();
		return choice;
	}

}
