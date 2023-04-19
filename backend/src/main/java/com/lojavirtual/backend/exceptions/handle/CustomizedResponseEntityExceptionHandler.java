package com.lojavirtual.backend.exceptions.handle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.lojavirtual.backend.exceptions.StandardError;
import com.lojavirtual.backend.services.exceptions.DataIntegrityViolationException;
import com.lojavirtual.backend.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler {
  
  @ExceptionHandler(Exception.class)
	public final ResponseEntity<StandardError> handleAllExceptions(
			Exception ex, HttpServletRequest  request) {
		
		StandardError exceptionResponse = new StandardError(System.currentTimeMillis(), HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Internal Server Error", ex.getMessage(), request.getRequestURI());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

  @ExceptionHandler(ObjectNotFoundException.class)
	public final ResponseEntity<StandardError> objectNotFoundException(
			Exception ex, HttpServletRequest request) {
		
		StandardError exceptionResponse = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Object Not Found", ex.getMessage(), request.getRequestURI());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

  @ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<StandardError> dataIntegrityViolationException(
			Exception ex, HttpServletRequest request) {
		
		StandardError exceptionResponse = new StandardError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
				"Data Integrity Violation", ex.getMessage(), request.getRequestURI());
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}
