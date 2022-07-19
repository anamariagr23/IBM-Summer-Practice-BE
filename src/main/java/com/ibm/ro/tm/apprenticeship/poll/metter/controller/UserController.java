/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * @author O09860826
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	AnswerRepository answerRepository;
	
	

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	} 
	/*
	@GetMapping("/users/{id}")
	public User findById(Long id) {
		return repository.findById(id);
	}
	*/
	
	@PostMapping
	User createUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PutMapping("/{userId}/polls/{userId}")
	User userVotesAtPoll(
			@PathVariable Long userId,
			@PathVariable Long pollId) {
		User user = userRepository.getById(userId);
		Poll poll = pollRepository.getById(pollId);
		user.votePoll(poll);
		return userRepository.save(user);
	}
	
	 	 
	 @PutMapping("/{userId}/answer/{answerId}")
	 User votePoll(
			 @PathVariable Long userId,
			 @PathVariable Long answerId
			 ) {
		 User user = userRepository.findById(userId).get();
		 Answer answer = answerRepository.findById(answerId).get();
		 user.votePoll(answer);
		 return userRepository.save(user);
		 
	 }
	 

}
