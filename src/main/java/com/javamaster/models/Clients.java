package com.javamaster.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity

public class Clients {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String sessionid;
	private String clientname;
	private String clientid;
	private String clientemailid;
	private String clientaddress;
	private String clienthost;
	private String clientport;
	private String clienttype;
	private String clietlocation;
	private String status;
	
	
	
	
	
	public Clients() {
		
	}





	public Clients(int id, String sessionid, String clientname, String clientid, String clientemailid,
			String clientaddress, String clienthost, String clientport, String clienttype, String clietlocation,
			String status) {
		super();
		this.id = id;
		this.sessionid = sessionid;
		this.clientname = clientname;
		this.clientid = clientid;
		this.clientemailid = clientemailid;
		this.clientaddress = clientaddress;
		this.clienthost = clienthost;
		this.clientport = clientport;
		this.clienttype = clienttype;
		this.clietlocation = clietlocation;
		this.status = status;
	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getSessionid() {
		return sessionid;
	}





	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}





	public String getClientname() {
		return clientname;
	}





	public void setClientname(String clientname) {
		this.clientname = clientname;
	}





	public String getClientid() {
		return clientid;
	}





	public void setClientid(String clientid) {
		this.clientid = clientid;
	}





	public String getClientemailid() {
		return clientemailid;
	}





	public void setClientemailid(String clientemailid) {
		this.clientemailid = clientemailid;
	}





	public String getClientaddress() {
		return clientaddress;
	}





	public void setClientaddress(String clientaddress) {
		this.clientaddress = clientaddress;
	}





	public String getClienthost() {
		return clienthost;
	}





	public void setClienthost(String clienthost) {
		this.clienthost = clienthost;
	}





	public String getClientport() {
		return clientport;
	}





	public void setClientport(String clientport) {
		this.clientport = clientport;
	}





	public String getClienttype() {
		return clienttype;
	}





	public void setClienttype(String clienttype) {
		this.clienttype = clienttype;
	}





	public String getClietlocation() {
		return clietlocation;
	}





	public void setClietlocation(String clietlocation) {
		this.clietlocation = clietlocation;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
