/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

/**
 * @author vlads
 *
 */
@Service
public class AnswerService {

	private final AnswerRepository answerRepository;
	
	@Autowired
	PollRepository pollRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

//	/**
//	 * @return the answerRepositoy
//	 */
//	public AnswerRepository getAnswerRepositoy() {
//		return answerRepository;
//	}
//	
	public Answer add(Answer answer) {
		return answerRepository.save(answer);
	}
//	
	public List<Answer> findAllAnswers(){
		return answerRepository.findAll();
	}
//	
//	public Answer findById(Long id) {
//		return answerRepository.findById(id).orElseThrow(()-> new AnswerNotFoundException("Answer not found"));
//	}
//	
	public Answer update(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public void delete(Long id) {
		answerRepository.deleteById(id);
	}
	

	 public List<Answer> findAnswersByPoll (Long pollId){
		 Poll poll = pollRepository.findPollById(pollId).get();
		 List<Answer> answers = answerRepository.getAnswersByPoll(poll);
		 return answers;		 
	 }	
//	

	public List<Answer> findAnswersByUser(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).get();
		List<Answer> answers = answerRepository.getAnswersByUser(user);
		return answers;
		
	}
	
//	/*
//	@PutMapping("/{answerId}/users/{pollId}")
//	 Object votePoll(
//			 @PathVariable Long pollId,
//			 @PathVariable Long answerId
//			 ) {
//		 Poll poll = pollRepository.findById(pollId).get();
//		 Answer answer = answerRepository2.findById(answerId).get();
//		 answer.assignAnswersToPoll(poll);
//		 return answerRepository2.save(answer);
//		 
//	 }	*/
//	
}
