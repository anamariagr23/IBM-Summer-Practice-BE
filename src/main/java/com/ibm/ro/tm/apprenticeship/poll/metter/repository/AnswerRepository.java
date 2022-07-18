/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;

/**
 * @author vlads
 *
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
