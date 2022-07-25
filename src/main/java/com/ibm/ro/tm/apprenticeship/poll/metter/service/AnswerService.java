/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

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
	AnswerRepository answerRepository2;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	/**
	 * @return the answerRepositoy
	 */
	public AnswerRepository getAnswerRepositoy() {
		return answerRepository;
	}
	
	public Answer addAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public List<Answer> findAllAnswers(){
		return answerRepository.findAll();
	}
	
	public Answer findById(Long id) {
		return answerRepository.getById(id);
	}
	
	public Answer updateAnswer(Answer answer) {
		return answerRepository.save(answer);
	}
	
	public void deleteAnswer(Long id) {
		answerRepository.deleteById(id);
	}
	
	@PutMapping("/{answerId}/users/{pollId}")
	 Object votePoll(
			 @PathVariable Long pollId,
			 @PathVariable Long answerId
			 ) {
		 Poll poll = pollRepository.findById(pollId).get();
		 Answer answer = answerRepository2.findById(answerId).get();
		 answer.assignAnswersToPoll(poll);
		 return answerRepository2.save(answer);
		 
	 }	
	
}
