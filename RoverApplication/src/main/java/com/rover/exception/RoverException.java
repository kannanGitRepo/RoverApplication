package com.rover.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.rover.beans.ErrorResponse;


@ControllerAdvice
public class RoverException {

	@ExceptionHandler(RoverAppException.class)
	public ResponseEntity<Object> handleRoverMove(RoverAppException ex){
		ErrorResponse error = new ErrorResponse(ex.getMessage());	
		return new ResponseEntity(error,HttpStatus.PRECONDITION_REQUIRED);	
	}
}
