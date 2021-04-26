package com.practice.restwebservice.users;

import java.util.Date;

public class ExceptionResponse {
	
	private Date date;
	private String message;
	private String details;
	
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.date = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return date;
	}
	public void setTimestamp(Date timestamp) {
		this.date = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	

}
