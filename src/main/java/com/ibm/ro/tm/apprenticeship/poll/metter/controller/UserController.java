/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * @author O09860826
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}
	

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.findAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	/*
	@GetMapping("/users/{id}")
	public User findById(Long id) {
		return repository.findById(id);
	}
	*/
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		User updateUser = userService.updateUser(user);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") Long id){
		userService.deleteUser(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	 
}
