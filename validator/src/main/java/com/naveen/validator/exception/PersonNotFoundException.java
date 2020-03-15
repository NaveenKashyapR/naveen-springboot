package com.naveen.validator.exception;

public class PersonNotFoundException extends RuntimeException{

	public PersonNotFoundException(String emailId) {
		super("Person not found for emailId : " + emailId);
	}
}
