/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;

/**
 * @author vlads
 *
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	@Query(value = "select a from Answer a where a.poll =:poll")
	public List<Answer> getAnswersByPoll (@Param( "poll") Poll poll);

	@Query(value = "select a from Answer a where a.user =:user")
	public List<Answer> getAnswersByUser(@Param( "user")User user);
	
	@Query(value="select a.vottingDetails from Answer a")
	List<Integer> getAllVotes();
}
