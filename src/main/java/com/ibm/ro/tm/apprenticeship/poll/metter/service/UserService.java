/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.UserNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

/**
 * @author vlads
 *
 */
@Service
public class UserService {

	
	private final UserRepository userRepository;
//	
//	@Autowired
//	PollRepository pollRepository;
//	
//	@Autowired
//	AnswerRepository answerRepository;
//	
//	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> getAll(){
		return userRepository.findAll();
	}
	
	public User add(User user) {
	return userRepository.save(user);
    }
	
	public User findById(Long id) {
	return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user id not found"+id));
	}
//
//	/**
//	 * @return the userRepository
//	 */
//	public UserRepository getUserRepository() {
//		return userRepository;
//	}
//	
//	@PutMapping("/{userId}/polls/{userId}")
//	User userVotesAtPoll(
//			@PathVariable Long userId,
//			@PathVariable Long pollId) {
//		User user = userRepository.getById(userId);
//		Poll poll = pollRepository.getById(pollId);
//		user.votePoll(poll);
//		return userRepository.save(user);
//	}
//	
//	 @PutMapping("/{userId}/answer/{answerId}")
//	 User votePoll(
//			 @PathVariable Long userId,
//			 @PathVariable Long answerId
//			 ) {
//		 User user = userRepository.findById(userId).get();
//		 Answer answer = answerRepository.findById(answerId).get();
//		 user.votePoll(answer);
//		 return userRepository.save(user);
//		 
//	 }
//	
//	public User addUser(User user) {
//		return userRepository.save(user);
//	}
//	
//	public List<User> findAllUsers(){
//		return userRepository.findAll();
//	}
//	
//	public User updateUser(User user) {
//		return userRepository.save(user);
//	}
//	
//	public void deleteUser(Long id) {
//		userRepository.deleteById(id);
//	}
//	
//	public User findById(Long id) {
//		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
//	}
}
