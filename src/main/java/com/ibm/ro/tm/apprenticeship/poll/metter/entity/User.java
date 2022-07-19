/**
 * 
 */
package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.io.Serializable;
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

/**
 * @author O09860826
 *
 */

@Entity
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8816369699035300946L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Role role;
	
	@ManyToMany
	@JoinTable(
			name="polls_voted",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="poll_id"))
	private Set<Poll> pollsVoted = new HashSet<>();
	
	
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
	
	public Set<Poll> getPollsVoted() {
		return pollsVoted;
	}
			
	
	//setters
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public void setRoles(Role newRole) {
		this.role = newRole;
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

	
	public void setPollsVoted(Set<Poll> pollsVoted) {
		this.pollsVoted = pollsVoted;
	}

	public void votePoll(Poll poll) {
		// TODO Auto-generated method stub
		pollsVoted.add(poll);
	}

	
	

}
