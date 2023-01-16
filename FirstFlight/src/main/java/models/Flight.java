package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "Flight")
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	private int flightId;

	@Column(name = "flight_number")
	private int flightNumber;

	@Column(name = "flight_name")
	private String airline;

	@Column(name = "Source")
	private String origin;

	@Column(name = "Destination")
	private String target;

	@Column(name = "Boarding_Date")
	private String dob;
	
	@Column(name = "Ticket_price")
	private float price;

	public Flight() {
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "flight_passenger", 
		joinColumns = {
				@JoinColumn(name = "flight_id")
		},
		inverseJoinColumns = {
				@JoinColumn(name = "passenger_id")
		}
	)
	List<Passenger> passenger = new ArrayList<Passenger>();
	

	public Flight(int flightId, int flightNumber, String airline, String origin, String target, String dob, float price) {
		super();
		this.flightId = flightId;
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.origin = origin;
		this.target = target;
		this.dob = dob;
		this.price = price;
	}

	public Flight(int flightNumber, String airline, String origin, String target, String dob, float price) {
		super();
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.origin = origin;
		this.target = target;
		this.dob = dob;
		this.price = price;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

}
