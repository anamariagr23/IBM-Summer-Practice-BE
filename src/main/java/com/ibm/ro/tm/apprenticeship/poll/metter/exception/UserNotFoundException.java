/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author vlads
 *
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3463071921741730653L;
	
	public UserNotFoundException(String message) {
		super(message);
	}
}
