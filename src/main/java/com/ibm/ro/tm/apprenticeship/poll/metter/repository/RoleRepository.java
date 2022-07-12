/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Role;
import org.springframework.stereotype.Repository;

/**
 * @author O09860826
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
