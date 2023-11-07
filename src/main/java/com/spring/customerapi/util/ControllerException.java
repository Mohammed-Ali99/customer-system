package com.spring.customerapi.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.customerapi.exception.CustomerException;
import com.spring.customerapi.model.CustomerError;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler
	public ResponseEntity<CustomerError> getException(CustomerException ce) {
		CustomerError error = new CustomerError();
		error.setMessage(ce.getMessage());
		error.setStatusCode(HttpStatus.NOT_FOUND.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerError> (error , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<CustomerError> getException(Exception e) {
		CustomerError error = new CustomerError();
		error.setMessage(e.getMessage());
		error.setStatusCode(HttpStatus.BAD_REQUEST.value());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<CustomerError> (error , HttpStatus.BAD_REQUEST);
	}
	
}
