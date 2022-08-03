/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.AnswerNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.ErrorDetails;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.PollNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.UserNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.AnswerService;

import dto.AnswerDto;

/**
 * @author vlads
 *
 */
@RestController
@RequestMapping("/answers")
public class AnswerController {

	private AnswerService answerService;
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public AnswerController(AnswerService answerService) {
		this.answerService = answerService;
	}
	
	@ExceptionHandler(value= {UserNotFoundException.class})
	public ResponseEntity<Object> handleUserNotFoundException (UserNotFoundException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value= {PollNotFoundException.class})
	public ResponseEntity<Object> handlePollNotFoundException (RuntimeException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(value= {AnswerNotFoundException.class})
	public ResponseEntity<Object> handleAnswerNotFoundException (AnswerNotFoundException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<AnswerDto>> getAllAnswers(){
		List<AnswerDto> answers = answerService.findAllAnswers();
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Answer> deleteAnswer(@PathVariable Long id){
		answerService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Answer> addAnswer(@RequestBody AnswerDto answer){
		Answer newAnswer = answerService.add(answer);
		return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Answer> updateAnswer(@RequestBody AnswerDto answer){
		Answer updateAnswer = answerService.update(answer);
		return new ResponseEntity<>(updateAnswer, HttpStatus.OK);
	}
	
	@GetMapping("/{pollId}/answersByPoll")
	public ResponseEntity <List<Answer>> getAnswersByPollId(@PathVariable Long pollId){
		List<Answer> answers = answerService.findAnswersByPoll(pollId);
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@GetMapping("/{userId}/answersByUser")
	public ResponseEntity <List<Answer>> getAnswersByUserId(@PathVariable Long userId){
		List<Answer> answers = answerService.findAnswersByUser(userId);
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<AnswerDto> getAnswerById(@PathVariable("id") Long id){
		AnswerDto answer = answerService.findById(id);
		return new ResponseEntity<>(answer, HttpStatus.OK);
	}

	@GetMapping("/find/poll/{pollId}/user/{userId}")
	public ResponseEntity<AnswerDto> findAnswerByUserIdAndPollId(@PathVariable("pollId")Long pollId, @PathVariable("userId") Long userId){
		AnswerDto answerDto = answerService.findAnswerByUserIdAndPollId(pollId, userId);
		return new ResponseEntity<>(answerDto, HttpStatus.OK);
	}
		
}
