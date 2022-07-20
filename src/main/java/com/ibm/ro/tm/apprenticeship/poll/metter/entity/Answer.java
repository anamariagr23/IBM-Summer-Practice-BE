package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Answer implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5720254597469710394L;


	@Id
    private Long id;

    
    @OneToMany(mappedBy="answer") 
    private Set<User> users = new HashSet<>();
    
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="poll_id", referencedColumnName = "id")
	private Poll poll;
    
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp vottingDate;

    @Column(nullable = false)
    private int vottingDetails;
    
    @Column(nullable = false)
    private String comment;


    protected Answer(){}

    public Answer(int vottingDetails, String comment){
        this.vottingDetails = vottingDetails;
        this.comment = comment;
    }

    //getters
    
    public Long getId(){
        return id;
    }

    public String getComment(){
        return comment;
    }

    public int getVottingDetails(){
        return vottingDetails;
    }
    
    public Set<User> getUsers() {
		return users;
	}
    
    public Poll getPoll() {
    	return poll;
    }
    
    //setters
    
    public void setId(Long newId) {
    	this.id = newId;
    }
    
    public void setVottingDetails(int newVottingDetails) {
    	this.vottingDetails = newVottingDetails;
    }
    
    public void setComment(String newComment) {
    	this.comment = newComment;
    }
    
    public void setPoll(Poll newPoll) {
    	this.poll = newPoll;
    }
}
