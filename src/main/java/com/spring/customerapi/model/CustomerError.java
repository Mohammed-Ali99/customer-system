package com.spring.customerapi.model;

public class CustomerError {

	private int statusCode;
	
	private String message;
	
	private long timeStamp;
	
	
	public CustomerError() {}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public long getTimeStamp() {
		return timeStamp;
	}


	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	
}
