package models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Entity
@Table(name = "Passenger")
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="passenger_id")
	private int pId;
	
	@Column(name="passenger_fname")
	private String fname;
	
	@Column(name="passenger_lname")
	private String lname;
	
	@Column(name="passenger_age")
	private int age;
	
	@Column(name="passenger_mob")
	private long contact;
	
	@Column(name="passenger_email")
	private String email;

	@ManyToMany(mappedBy = "passenger")//, cascade = CascadeType.MERGE)
	private List<Flight> flight = new ArrayList<Flight>();
	
	public Passenger() {
	}

	public Passenger(int pId, String fname, String lname, int age, long contact, String email) {
		super();
		this.pId = pId;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.contact = contact;
		this.email = email;
	}

	
	public Passenger(String fname, String lname, int age, long contact, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.contact = contact;
		this.email = email;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Flight> getFlight() {
		return flight;
	}

	public void setFlight(List<Flight> flight) {
		this.flight = flight;
	}
	
}
