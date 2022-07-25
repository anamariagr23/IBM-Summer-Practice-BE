/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;

/**
 * @author vlads
 *
 */
public interface PollRepository extends JpaRepository<Poll, Long>{

	User save(org.apache.tomcat.jni.Poll poll);

	List<Poll> findByName(String name);

}
