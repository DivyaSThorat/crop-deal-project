package com.cg.cropdeal.authentication.exception;

public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException () {
	}

	public InvalidPasswordException (String message) {
		super(message);
	}
}
