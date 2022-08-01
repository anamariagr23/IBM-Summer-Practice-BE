/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author vlads
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException (UserNotFoundException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value=PollNotFoundException.class)
	public ResponseEntity<Object> handleException (PollNotFoundException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}

}
