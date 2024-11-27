package com.lti.app.hotel_management_prc.util;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	
	private T data;
	private String message;
	private int statusCode;

}
