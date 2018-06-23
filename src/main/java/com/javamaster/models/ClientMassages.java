package com.javamaster.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="clientmassages")
public class ClientMassages {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String clientname;
	private String clinttype;
	private String clientsessionid;
	private String massage;
	@Temporal(TemporalType.DATE)
	private Date messageDate;
	private String messageTime;
	
	
	public ClientMassages() {
		
	}


	public ClientMassages(int id, String clientname, String clinttype, String clientsessionid, String massage,
			Date messageDate, String messageTime) {
		super();
		this.id = id;
		this.clientname = clientname;
		this.clinttype = clinttype;
		this.clientsessionid = clientsessionid;
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


	public String getClientname() {
		return clientname;
	}


	public void setClientname(String clientname) {
		this.clientname = clientname;
	}


	public String getClinttype() {
		return clinttype;
	}


	public void setClinttype(String clinttype) {
		this.clinttype = clinttype;
	}


	public String getClientsessionid() {
		return clientsessionid;
	}


	public void setClientsessionid(String clientsessionid) {
		this.clientsessionid = clientsessionid;
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
