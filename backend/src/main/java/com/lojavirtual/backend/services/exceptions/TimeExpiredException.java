package com.lojavirtual.backend.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TimeExpiredException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public TimeExpiredException(String message) {
		super(message);
	}

}
