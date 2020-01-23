package com.galel.ne;


public class Event implements IEvent {

	private String type;
	
	public Event(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
}