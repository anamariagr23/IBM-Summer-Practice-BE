/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
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
	
	
	
	public PollController(PollService pollService) {
		
		this.pollService = pollService;
	}



	@GetMapping("/")
	public ResponseEntity<List<Poll>> getAllPolls(){
		List<Poll> polls = pollService.findAll();
		return new ResponseEntity<>(polls, HttpStatus.OK);
	}
	
	@GetMapping("/answers")                               //TODO !!!!!!!!!!!!!!!!!!!!!!!!!
	public ResponseEntity<List<Answer>> getAllAnswers(){
		List<Answer> answers = pollService.findAllAnswers();
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

//	
//	/**
//	 * @return the pollService
//	 */
//	public PollService getPollService() {
//		return pollService;
//	}
//	
//	@GetMapping("/polls")
//	public ResponseEntity<List<Poll>> getAllPolls(){
//		List<Poll> polls = pollService.findAllPolls();
//		return new ResponseEntity<>(polls, HttpStatus.OK);
//	}
//	
//	@GetMapping("/find/{id}")
//	public ResponseEntity<Poll> getPollById(@PathVariable("id") Long id){
//		Poll poll = pollService.findById(id);
//		return new ResponseEntity<>(poll, HttpStatus.OK);
//	}
//	
//	@PostMapping("/add")
//	public ResponseEntity<Poll> addPoll(@RequestBody Poll poll){
//		Poll newPoll = pollService.addPoll(poll);
//		return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
//	}
//	
//	@PutMapping("/update")
//	public ResponseEntity<Poll> updatePoll(@RequestBody Poll poll){
//		Poll updatePoll = pollService.updatePoll(poll);
//		return new ResponseEntity<>(updatePoll, HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<Poll> deletePoll(@PathVariable Long id){
//		pollService.deletePoll(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
//	
	
	
}

