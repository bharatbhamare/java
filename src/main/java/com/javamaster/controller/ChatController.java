package com.javamaster.controller;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.javamaster.connection.DbConnection;
import com.javamaster.domain.Message;
import com.javamaster.models.ClientMassages;
import com.mysql.fabric.xmlrpc.base.Data;

@Controller
public class ChatController {

	
	@Autowired
	ClientMassages ms;
	@Autowired
	DbConnection conn;
	static int n=0;
	@MessageMapping("/message")
	@SendTo("/chat/messages")
	public Message getMessages(Message message) {
		
		System.out.println(message);
		ms.setClientname(" ");
		ms.setClientsessionid(" ");
		ms.setClinttype(String.valueOf(++n));
		
		ms.setMassage(message.getMessage());
		ms.setMessageDate(new Date());
		ms.setMessageTime(new Data().toString());
		
		Session session=DbConnection.getSession();
		session.beginTransaction();
		//session.save(ms);
		session.persist(ms);
		session.getTransaction().commit();
		return message;
	}
	
}
