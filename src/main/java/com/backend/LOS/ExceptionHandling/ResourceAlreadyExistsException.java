package com.backend.LOS.ExceptionHandling;

public class ResourceAlreadyExistsException extends RuntimeException {
	
	public ResourceAlreadyExistsException(String message) {
		super(message);
	}

}
