package com.bah.mcc.domain;

public class Event {
	private Long id;
	private String code;
	private String title;
	private String description;
	
	
	public Event(Long id, String code, String title, String description) {
		super();
		this.id = id;
		this.code = code;
		this.title = title;
		this.description = description;
	}
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
