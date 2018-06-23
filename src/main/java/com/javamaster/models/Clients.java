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
	private String sessionId;
	private String clientName;
	private String clientId;
	private String clientEmailId;
	private String clientAddress;
	private String clientHost;
	private String clientPort;
	private String clientType;
	private String clietLocation;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Clients() {
	
	}
	public Clients(int id, String sessionId, String clientName, String clientId, String clientEmailId,
			String clientAddress, String clientHost, String clientPort, String clientType, String clietLocation) {
		super();
		this.id = id;
		this.sessionId = sessionId;
		this.clientName = clientName;
		this.clientId = clientId;
		this.clientEmailId = clientEmailId;
		this.clientAddress = clientAddress;
		this.clientHost = clientHost;
		this.clientPort = clientPort;
		this.clientType = clientType;
		this.clietLocation = clietLocation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientEmailId() {
		return clientEmailId;
	}
	public void setClientEmailId(String clientEmailId) {
		this.clientEmailId = clientEmailId;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientHost() {
		return clientHost;
	}
	public void setClientHost(String clientHost) {
		this.clientHost = clientHost;
	}
	public String getClientPort() {
		return clientPort;
	}
	public void setClientPort(String clientPort) {
		this.clientPort = clientPort;
	}
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getClietLocation() {
		return clietLocation;
	}
	public void setClietLocation(String clietLocation) {
		this.clietLocation = clietLocation;
	}
	
	
	
}
