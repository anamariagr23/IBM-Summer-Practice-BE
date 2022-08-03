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
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.ErrorDetails;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.PollNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.AnswerService;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.PollService;

/**
 * @author vlads
 *
 */
@RestController
@RequestMapping("/poll")
public class PollController {

	@Autowired
	private PollService pollService;
	
	@Autowired
	private AnswerService answerService;
	
	
	
	public PollController(PollService pollService) {
		
		this.pollService = pollService;
	}

	@ExceptionHandler(value= {PollNotFoundException.class})
	public ResponseEntity<Object> handlePollNotFoundException (PollNotFoundException exception, WebRequest request){
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage());
		return new ResponseEntity<Object>(errorDetails, HttpStatus.NOT_FOUND);
		
	}


	@GetMapping("/")
	public ResponseEntity<List<Poll>> getAllPolls(){
		List<Poll> polls = pollService.findAll();
		return new ResponseEntity<>(polls, HttpStatus.OK);
	}
	
//	@GetMapping("/answers")                               //TODO !!!!!!!!!!!!!!!!!!!!!!!!!
//	public ResponseEntity<List<Answer>> getAllAnswers(@PathVariable("id") Long id){
//		List<Answer> answers = pollService.findAllAnswers(id);
//		return new ResponseEntity<>(answers, HttpStatus.OK);
//	}
	
	@GetMapping("/{Id}/answers")
	public ResponseEntity <List<Answer>> getAnswersByPollId(@PathVariable("id") Long id){
		List<Answer> answers = answerService.findAnswersByPoll(id);
		return new ResponseEntity<>(answers, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Poll> addPoll(@RequestBody Poll poll){
		Poll newPoll = pollService.add(poll);
		return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Poll> updatePoll(@RequestBody Poll poll){
		Poll updatePoll = pollService.updatePoll(poll);
		return new ResponseEntity<>(updatePoll, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Poll> deletePoll(@PathVariable("id") Long id){
		pollService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
		@GetMapping("/find/{topic}")
	public ResponseEntity<List<Poll>> getPollByTopic(@PathVariable("topic") String topic){
		List<Poll> polls = pollService.findByTopic(topic);
		return new ResponseEntity<>(polls, HttpStatus.OK);
	}
	
}

