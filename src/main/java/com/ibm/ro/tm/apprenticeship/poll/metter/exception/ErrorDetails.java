/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.exception;

import java.time.LocalDateTime;

/**
 * @author vlads
 *
 */


public class ErrorDetails {

	private LocalDateTime timeStamp;
		
	private String message;
	
	public ErrorDetails(LocalDateTime timeStamp, String message ) {
		this.timeStamp = timeStamp;		
		this.message = message;
	}

	/**
	 * @return the timeStamp
	 */
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
