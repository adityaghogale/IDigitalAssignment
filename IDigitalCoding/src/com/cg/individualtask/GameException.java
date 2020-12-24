package com.cg.individualtask;

/**
 * 
 * @author Aditya Ghogale
 *
 *         Game Exception class to create/throw user define exceptions
 */

public class GameException extends Exception {

	// Message variable to store message for each exception thrown
	String message;

	// parameterized Constructor
	public GameException(String message) {
		super();
		this.message = message;
	}

	// To display message in user defined form
	@Override
	public String toString() {
		return "GameException [message=" + message + "]";
	}

}
