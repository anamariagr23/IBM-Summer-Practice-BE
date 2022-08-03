/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

/**
 * @author O09860826
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

		
	private UserRepository userRepository;
	
	
	private final UserService userService;
	
	
	public UserController(UserRepository userRepository, UserService userService) {		
		this.setUserRepository(userRepository);
		this.userService = userService;
	}



	@GetMapping("/")
	public ResponseEntity<List<User>> getAllUsers(){
		if(userService == null)		{
			System.out.println("nu avem");
		}
		else
		{
			System.out.println("avem");
		}
		List<User> users = userService.getAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) throws ServerException{
		User newUser = userService.add(user);
		if(newUser == null) {
			throw new ServerException(null);
		}
			
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
		User user = userService.findById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	/**
	 * @return the userRepository
	 */
	public UserRepository getUserRepository() {
		return userRepository;
	}

	/**
	 * @param userRepository the userRepository to set
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
