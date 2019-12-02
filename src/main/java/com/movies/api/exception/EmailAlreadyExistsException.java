package com.movies.api.exception;

public class EmailAlreadyExistsException extends RuntimeException {
	private static final long serialVersionUID = 3743503472907415585L;

	public EmailAlreadyExistsException(String message) {
		super(message);
	}

}
