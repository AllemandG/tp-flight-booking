package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.UniqueElements;

@Entity
@SequenceGenerator(name = "seq_flight", sequenceName = "seq_flight", initialValue = 1, allocationSize = 1)
public class Flight {
	@Id
	@GeneratedValue(generator = "seq_flight")
	private Long id;

	@Column
	@NotBlank
	@UniqueElements
	@Pattern(regexp = "[0-9]4")
	private String flightNumber;

	@Column
	@Enumerated(EnumType.STRING)
	@NotBlank
	private Plane planeType;

	@Column
	@NotNull
	private Integer seatsNumber;

	@Column
	@NotBlank
	private String takeoffCity;

	@Column
	@NotBlank
	private String landingCity;

	@Column
	@NotNull
	private LocalDate departureDate;

	@OneToMany(mappedBy = "flight")
	private List<Booking> bookings = new ArrayList<>();

	// CONSTRUCTOR

	public Flight() {
	}

	public Flight(String flightNumber, Plane planeType, Integer seatsNumber, String takeoffCity, String landingCity,
			LocalDate departureDate) {
		this.id = null;
		this.flightNumber = flightNumber;
		this.planeType = planeType;
		this.seatsNumber = seatsNumber;
		this.takeoffCity = takeoffCity;
		this.landingCity = landingCity;
		this.departureDate = departureDate;
	}

	// GETTERS AND SETTERS

	@Override
	public String toString() {
		return flightNumber + " | " + getPlaneType() + " | " + bookings.size() + "/" + seatsNumber + " | " + takeoffCity + " | "
				+ landingCity + " | " + departureDate.getDayOfMonth() + "/" + departureDate.getMonth() + "/"
				+ departureDate.getYear();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Plane getPlaneType() {
		return planeType;
	}

	public void setPlaneType(Plane planeType) {
		this.planeType = planeType;
	}

	public Integer getSeatsNumber() {
		return seatsNumber;
	}

	public void setSeatsNumber(Integer seatsNumber) {
		this.seatsNumber = seatsNumber;
	}

	public String getTakeoffCity() {
		return takeoffCity;
	}

	public void setTakeoffCity(String takeoffCity) {
		this.takeoffCity = takeoffCity;
	}

	public String getLandingCity() {
		return landingCity;
	}

	public void setLandingCity(String landingCity) {
		this.landingCity = landingCity;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
