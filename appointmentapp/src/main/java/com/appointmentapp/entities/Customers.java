package com.appointmentapp.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CustomersProf")
public class Customers {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int CustID;
	@Column(name = "Customeremail")
	private String CustEmail;
	private String CustFullName;
	private String CustPass;
	private String CustContacts;
	private String Gender;

	// relationship
	@OneToMany(mappedBy = "CustomersProf", cascade = CascadeType.ALL)
	private Set<Appointmentbooking> Cust_to_Appointment = new HashSet<Appointmentbooking>();

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)//
	@JoinColumn(name = "wardid")
	private Wards ward;

	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(int custID, String custEmail, String custFullName, String custPass, String custContacts,
			String gender, Set<Appointmentbooking> cust_to_Appointment, Wards ward) {
		super();
		CustID = custID;
		CustEmail = custEmail;
		CustFullName = custFullName;
		CustPass = custPass;
		CustContacts = custContacts;
		Gender = gender;
		Cust_to_Appointment = cust_to_Appointment;
		this.ward = ward;
	}








	public Wards getWard() {
		return ward;
	}





	public void setWard(Wards ward) {
		this.ward = ward;
	}





	public int getCustID() {
		return CustID;
	}

	public void setCustID(int custID) {
		CustID = custID;
	}

	public Set<Appointmentbooking> getCust_to_Appointment() {
		return Cust_to_Appointment;
	}

	public void setCust_to_Appointment(Set<Appointmentbooking> cust_to_Appointment) {
		Cust_to_Appointment = cust_to_Appointment;
	}

	public String getCustEmail() {
		return CustEmail;
	}

	public void setCustEmail(String custEmail) {
		CustEmail = custEmail;
	}

	public String getCustFullName() {
		return CustFullName;
	}

	public void setCustFullName(String custFullName) {
		CustFullName = custFullName;
	}

	public String getCustPass() {
		return CustPass;
	}

	public void setCustPass(String custPass) {
		CustPass = custPass;
	}

	public String getCustContacts() {
		return CustContacts;
	}

	public void setCustContacts(String custContacts) {
		CustContacts = custContacts;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

}
