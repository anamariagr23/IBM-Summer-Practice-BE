package com.ibm.ro.tm.apprenticeship.poll.metter.entity;

import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;

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
    @ApiModelProperty(value = "description", name = "notificationExpiryDate",
            dataType = "String", example = "2022-01-16T08:42:37.484Z")
    private Timestamp startingDate;
    
    @Column(nullable = false)
    @ApiModelProperty(value = "description", name = "notificationExpiryDate",
            dataType = "String", example = "2022-01-16T08:42:37.484Z")
    private Timestamp closingDate;
    
   
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
    
       	
}
