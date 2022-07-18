/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import org.apache.tomcat.jni.Poll;

/**
 * @author O09860826
 *
 */

@Entity
public class User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Role role;
	
	@ManyToMany
    @JoinTable(
    		name="poll_chosed",
    		joinColumns =@JoinColumn(name="user_id"),
    		inverseJoinColumns = @JoinColumn(name="poll_id")
    		)
    private Set<Poll> pollsChosed = new HashSet<>() ;


	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="answer_id", referencedColumnName = "id")
	private Answer answer;
	
	
	protected User() {

	}

	public User(String name, Role role) {

		this.name = name;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the roles
	 */
	public Role getRoles() {
		return role;
	}
	
		
	public Set<Poll> getChosePoll() {
		return pollsChosed;
	}

	//setters
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setRoles(Role newRole) {
		this.role = newRole;
	}
	
	public void setChosePoll(Set<Poll> chosePoll) {
		this.pollsChosed = chosePoll;
	}


	public void chosePoll(Poll poll) {
		// TODO Auto-generated method stub
		pollsChosed.add(poll);
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public void votePoll(Answer answer2) {
		// TODO Auto-generated method stub
		this.answer = answer2;
	}

	
	

}
