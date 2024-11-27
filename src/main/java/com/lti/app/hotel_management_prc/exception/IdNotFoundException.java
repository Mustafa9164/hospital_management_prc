package com.lti.app.hotel_management_prc.exception;

public class IdNotFoundException extends RuntimeException {
	
	private String message = "Given Id is not Found";

	public IdNotFoundException() {

	}

	public IdNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
