package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

@Service
public class PollService {

	private final PollRepository pollRepository;
	
	private AnswerRepository answerRepository;
	
	
	public PollService(PollRepository pollRepository, AnswerRepository answerRepository) {
		this.pollRepository = pollRepository;
		this.answerRepository = answerRepository;
	}

	public List<Answer> findAllAnswers(){
		return answerRepository.findAll();
	}
	
	
//	/**
//	 * @return the pollRepository
//	 */
//	public PollRepository getPollRepository() {
//		return pollRepository;
//	}
//	
	public Poll add(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public List<Poll> findAll(){
		return pollRepository.findAll();
	}
	
	public Poll updatePoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public Poll findById(Long id) {
		return pollRepository.findById(id).orElseThrow();
	}
//	
////	public List<Poll> findByTopic(String topic) {
////		return pollRepository.findByName(topic);
////	}
//	
	public void delete(Long id) {
		pollRepository.deleteById(id);
	}
//	
		
}
