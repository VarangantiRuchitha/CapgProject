package com.cg.bookmydoctor.dto;

public class ErrorMessage{
	
	private String message;
	private String httpStatus;
	
	
	public ErrorMessage(String message, String httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	public ErrorMessage() {
		super();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(String httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}

