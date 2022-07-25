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
public class AnswerNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 853012206421733413L;

	public AnswerNotFoundException (String message) {
		super(message);
	}
}
