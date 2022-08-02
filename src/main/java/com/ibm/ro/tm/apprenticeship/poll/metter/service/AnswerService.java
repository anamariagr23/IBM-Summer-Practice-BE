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
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.AnswerNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.PollNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.UserNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;

import dto.AnswerDto;

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
	public Answer add(AnswerDto answerDto) {
		Answer newAnswer = null;
		newAnswer = new Answer(answerDto.getContent());
		User user = userRepository.findById(answerDto.getUserId()).orElseThrow(() -> new UserNotFoundException("user id not found "+answerDto.getUserId()));
		 Poll poll = pollRepository.findById(answerDto.getPollId()).orElseThrow(() -> new PollNotFoundException("poll id not found "+answerDto.getPollId()));
		newAnswer.setUser(user);
		newAnswer.setPoll(poll);
		newAnswer.setVottingDetails(answerDto.getVottingDetail());		
		return newAnswer;
		
	}
//	
	public List<Answer> findAllAnswers(){
		return answerRepository.findAll();
	}
	
	public Answer findById(Long id) {
		return answerRepository.findById(id).orElseThrow(()-> new AnswerNotFoundException("Answer not found"));
	}
	
	public Answer update(AnswerDto answerDto) {
		
		if(userRepository.findById(answerDto.getUserId()).isPresent() && pollRepository.findById(answerDto.getPollId()).isPresent()) {
			Answer updateAnswer = null;
			updateAnswer = new Answer(answerDto.getContent());
			User user = userRepository.findById(answerDto.getUserId()).get();
			Poll poll = pollRepository.findById(answerDto.getPollId()).get();
			updateAnswer.setUser(user);
			updateAnswer.setPoll(poll);
			updateAnswer.setVottingDetails(answerDto.getVottingDetail());
			return updateAnswer;			
		} else {
			throw new AnswerNotFoundException("No answer existent");
		}	

	}
	
	public void delete(Long id) {
		if(answerRepository.findById(id).isPresent()) {
		answerRepository.deleteById(id);
		} else {
			throw new AnswerNotFoundException("Answer id "+id+" doesn`t exist!");
		}
	}
	

	 public List<Answer> findAnswersByPoll (Long pollId){
		 Poll poll = pollRepository.findById(pollId).orElseThrow(() -> new PollNotFoundException("poll id not found"+pollId));
		 List<Answer> answers = answerRepository.getAnswersByPoll(poll);
		 return answers;		 
	 }	
//	

	public List<Answer> findAnswersByUser(Long userId) {
		// TODO Auto-generated method stub
		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("user id not found"+userId));
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
