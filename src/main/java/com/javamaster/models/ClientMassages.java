package com.javamaster.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
public class ClientMassages {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String clientName;
	private String clintType;
	private String clientSessionId;
	private String massage;
	@Temporal(TemporalType.DATE)
	private Date messageDate;
	private String messageTime;
	
	
	public ClientMassages() {
		
	}
	public ClientMassages(int id, String clientName, String clintType, String clientSessionId, String massage,
			Date messageDate, String messageTime) {
		super();
		this.id = id;
		this.clientName = clientName;
		this.clintType = clintType;
		this.clientSessionId = clientSessionId;
		this.massage = massage;
		this.messageDate = messageDate;
		this.messageTime = messageTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClintType() {
		return clintType;
	}
	public void setClintType(String clintType) {
		this.clintType = clintType;
	}
	public String getClientSessionId() {
		return clientSessionId;
	}
	public void setClientSessionId(String clientSessionId) {
		this.clientSessionId = clientSessionId;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getMessageTime() {
		return messageTime;
	}
	public void setMessageTime(String messageTime) {
		this.messageTime = messageTime;
	}
	
	
}
