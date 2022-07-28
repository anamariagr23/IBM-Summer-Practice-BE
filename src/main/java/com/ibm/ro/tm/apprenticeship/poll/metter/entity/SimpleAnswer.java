package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@Entity(name = "answer")
public class SimpleAnswer implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -5169938428479639599L;

	/**
	 * 
	 */

	@Id
	private Long id;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "poll_id")
	private Long pollId;

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Timestamp vottingDate;

	@Column(nullable = false)
	private int vottingDetails;

	@Column(nullable = false)
	private String comment;
	
	protected SimpleAnswer () {}
	
	public SimpleAnswer (int vottingDetails, String comment) {
		this.vottingDetails = vottingDetails;
		this.comment = comment;
	}
	
	//getters
	
	public Long id() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}
	
	public Long getPollId() {
		return pollId;
	}
	
	public int getVottingDetails() {
		return vottingDetails;
	}
	
	public String comment() {
		return comment;
	}
	
	//setters
	
	public void setId(Long newId) {
		this.id = newId;
	}
	
	public void setUserId(Long newUserId) {
		this.userId = newUserId;
	}
	
	public void setPollId(Long newPollId) {
		this.pollId = newPollId;
	}
	
	public void setVottingDetails(int newVottingDetails) {
		this.vottingDetails = newVottingDetails;
	}
	
	public void setComment(String newComment) {
		this.comment = newComment;
	}
	
	
}
