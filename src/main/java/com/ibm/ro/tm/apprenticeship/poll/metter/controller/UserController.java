/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

/**
 * @author O09860826
 *
 */
@RestController
public class UserController {

	private final UserRepository repository;

	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/users")
	public List<User> all() {
		return repository.findAll();
	}
	/*
	@GetMapping("/users/{id}")
	public User findById(Long id) {
		return repository.findById(id);
	}
	*/

}
