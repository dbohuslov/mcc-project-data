package com.bah.mcc.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name="REGISTRATIONS")
public class Registration {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	@Column(name = "REGISTRATION_DATE")
	private Date registration_date;
	private String notes;
	@Column(name = "EVENT_ID")
	private String event_name;
	@Column(name="CUSTOMER_ID")
	private String customer_name;
	
	
	public Registration(Long id, Date registration_date, String notes, String event_name, String customer_name) {
		super();
		this.id = id;
		this.registration_date = registration_date;
		this.notes = notes;
		this.event_name = event_name;
		this.customer_name = customer_name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getRegistration_date() {
		return registration_date;
	}
	public void setRegistration_date(Date registration_date) {
		this.registration_date = registration_date;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", registration_date=" + registration_date + ", notes=" + notes
				+ ", event_name=" + event_name + ", customer_name=" + customer_name + "]";
	}
	
	
}
	