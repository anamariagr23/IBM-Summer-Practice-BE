package com.ibm.ro.tm.apprenticeship.poll.metter.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.PollNotFoundException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;

@Service
public class PollService {

	private final PollRepository pollRepository;
	
	
	public PollService(PollRepository pollRepository) {
		this.pollRepository = pollRepository;
	}

	/**
	 * @return the pollRepository
	 */
	public PollRepository getPollRepository() {
		return pollRepository;
	}
	
	public Poll addPoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public List<Poll> findAllPolls(){
		return pollRepository.findAll();
	}
	
	public Poll updatePoll(Poll poll) {
		return pollRepository.save(poll);
	}
	
	public Poll findById(Long id) {
		return pollRepository.findById(id).orElseThrow(() -> new PollNotFoundException("poll not found"));
	}
	
	public List<Poll> findByTopic(String topic) {
		return pollRepository.findByName(topic);
	}
	
	public void deletePoll(Long id) {
		pollRepository.deleteById(id);
	}
	
		
}
