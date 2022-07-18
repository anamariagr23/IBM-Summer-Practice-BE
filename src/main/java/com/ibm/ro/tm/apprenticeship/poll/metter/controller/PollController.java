/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

/**
 * @author vlads
 *
 */
@RestController
@RequestMapping("/polls")
public class PollController {
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	AnswerRepository answerRepository;

		
	public PollController(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}
	
	@GetMapping("/polls")
	public List<com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll> getPolls() {
		return pollRepository.findAll();
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

