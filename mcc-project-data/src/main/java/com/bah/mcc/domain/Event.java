package com.bah.mcc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "EVENTS")
public class Event {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
	
	@Column(name = "EVENT_CODE")
	private String code;

	private String title;
	private String description;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	public Event(Long id, String code, String title, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Event [id=" + id + ", code=" + code + ", title=" + title + ", description=" + description + "]";
	}
	
	
	

}
