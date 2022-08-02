package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	User getById(Long userId);

}
