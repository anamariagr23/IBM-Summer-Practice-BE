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
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.PollService;

/**
 * @author vlads
 *
 */
@RestController
@RequestMapping("/polls")
public class PollController {
	
	private final PollService pollService;
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	AnswerRepository answerRepository;

		
	public PollController(PollService pollService) {
		this.pollService = pollService;
	}
	
	/**
	 * @return the pollService
	 */
	public PollService getPollService() {
		return pollService;
	}
	
	@GetMapping("/polls")
	public ResponseEntity<List<Poll>> getAllPolls(){
		List<Poll> polls = pollService.findAllPolls();
		return new ResponseEntity<>(polls, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<Poll> getPollById(@PathVariable("id") Long id){
		Poll poll = pollService.findById(id);
		return new ResponseEntity<>(poll, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Poll> addPoll(@RequestBody Poll poll){
		Poll newPoll = pollService.addPoll(poll);
		return new ResponseEntity<>(newPoll, HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Poll> updatePoll(@RequestBody Poll poll){
		Poll updatePoll = pollService.updatePoll(poll);
		return new ResponseEntity<>(updatePoll, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Poll> deletePoll(@PathVariable Long id){
		pollService.deletePoll(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/{userId}/answer/{answerId}")
	 Object votePoll(
			 @PathVariable Long pollId,
			 @PathVariable Long answerId
			 ) {
		 com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll poll = pollRepository.findById(pollId).get();
		 Answer answer = answerRepository.findById(answerId).get();
		 poll.addAnswer(answer);
		 return pollRepository.save(poll);
		 
	 }

	
}

