package com.rover.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_REQUIRED)
public class RoverAppException extends RuntimeException{

	
	private static final long serialVersionUID = 1L;

	public RoverAppException(String message) {
		super(message);
	}

	
}
