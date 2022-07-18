package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String topic;
    
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Timestamp startingDate;
    
    @Column(nullable = false)
    private Timestamp closingDate;
    
    
   
    
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
    
    


    //delete Poll method
    public int deletePoll(int deleteId){
        return 1;
    }

	public void addAnswer(Answer answer) {
		// TODO Auto-generated method stub
		answers.add(answer);
	}
}
