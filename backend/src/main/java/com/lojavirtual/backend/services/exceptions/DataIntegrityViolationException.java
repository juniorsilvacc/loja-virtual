package com.lojavirtual.backend.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DataIntegrityViolationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public DataIntegrityViolationException(String message) {
		super(message);
	}

}
