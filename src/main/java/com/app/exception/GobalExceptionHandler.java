package com.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
//@ResponseStatus
public class GobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(DepartmentNotFoundException.class)
	public ResponseEntity<Error> handleDepartmentNotFoundException(DepartmentNotFoundException ex, WebRequest request) {
		Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

	}

	@ExceptionHandler(EmptyInputException.class)
	public ResponseEntity<String> handleEmptyInputException(EmptyInputException ex) {
		//Error error = new Error(HttpStatus.NOT_FOUND, ex.getMessage());
		return new ResponseEntity<String>("feilds are empty please look into",HttpStatus.NOT_FOUND);

	}

}
