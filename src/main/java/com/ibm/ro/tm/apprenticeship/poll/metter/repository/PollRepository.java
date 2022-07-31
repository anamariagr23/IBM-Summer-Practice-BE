/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;

/**
 * @author vlads
 *
 */
public interface PollRepository extends JpaRepository<Poll, Long>{
//
//	User save(org.apache.tomcat.jni.Poll poll);
////
	Optional<Poll> findPollById(Long id);
	
	@Query(value = "SELECT * FROM poll where topic = ?", nativeQuery = true)
	List<Poll> findByTopic(String topic);

}
