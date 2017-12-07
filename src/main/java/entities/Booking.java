package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@SequenceGenerator(name = "seq_booking", sequenceName = "seq_booking", initialValue = 1, allocationSize = 1)
public class Booking {
	@Id
	@GeneratedValue(generator = "seq_booking")
	private Long id;

	@Column
	@UniqueElements
	@Pattern(regexp = "[0-9]4[-][0-9]+")
	private String bookingNumber;

	@Column
	@NotBlank
	private String lastname;

	@Column
	@NotBlank
	private String firstname;

	@Column
	@NotNull
	private Integer age;

	@ManyToOne
	private Flight flight;

	// CONSTRUCTORS

	public Booking(String bookingNumber, Flight flight, String lastname, String firstname, Integer age) {
		this.id = null;
		this.bookingNumber = bookingNumber;
		this.flight = flight;
		this.lastname = lastname;
		this.firstname = firstname;
		this.age = age;
	}

	public Booking(String bookingNumber, String lastname, String firstname, Integer age) {
		this(bookingNumber, null, lastname, firstname, age);
	}
	
	public Booking(String lastname, String firstname, Integer age) {
		this(null, null, lastname, firstname, age);
	}

	public Booking() {
	}

	public String toString() {
		return bookingNumber + " | " + lastname + " | " + firstname + " | " + age + " | " + flight.getFlightNumber()
				+ " | " + flight.getDepartureDate().getDayOfMonth() + "/" + flight.getDepartureDate().getMonth() + "/"
				+ flight.getDepartureDate().getYear();
	}

	// GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(String bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
