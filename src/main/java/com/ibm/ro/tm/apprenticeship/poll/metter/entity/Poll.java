package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poll implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1195877116290672016L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String topic;
    
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp startingDate;
    
    @Column(nullable = false)
    private Timestamp closingDate;
    
    @ManyToMany(mappedBy = "pollsVoted")    
    Set<User> users = new HashSet<>();
    
    @OneToMany(mappedBy = "poll")
    private Set<Answer> answers = new HashSet<>();

    protected Poll(){}

    public Poll(String topic, Timestamp closingDate){
        this.topic = topic;
        this.closingDate = closingDate;
    }

    //getters
    
    public Long getId(){
        return id;
    }

    public String getTopic(){
        return topic;
    }

    public Timestamp getStartingDate(){
        return startingDate;
    }

    public Timestamp getClosingDate(){
        return closingDate;
    }
    
    public Set<Answer> getAnswers() {
		return answers;
	}
    
    public Set<User> getUsers(){
    	return users;
    }
       
    //setters
    
       
    public void setTopic(String newTopic) {
    	this.topic = newTopic;
    }
    
    public void setStartingDate(Timestamp newStartingDate) {
    	this.startingDate = newStartingDate;
    }
    
    public void setClosingDate(Timestamp newClosingDate) {
    	this.closingDate = newClosingDate;
    }
    
    public void setUsers(Set<User> users) {
    	this.users = users;
    }
    	
}
