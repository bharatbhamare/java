package com.javamaster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import com.javamaster.connection.DbConnection;
import com.javamaster.domain.Message;
import com.javamaster.models.Clients;
import com.mysql.jdbc.PreparedStatement;

public class PresenceChannelInterceptor extends ChannelInterceptorAdapter {
 
    private final Log logger = LogFactory.getLog(PresenceChannelInterceptor.class);
    Session session=DbConnection.getSession();
    
    @Override
    public void postSend(org.springframework.messaging.Message<?> message, MessageChannel channel, boolean sent) {
 
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        int id=0;
       // ignore non-STOMP messages like heartbeat messages
        if(sha.getCommand() == null) {
            return;
        }
        if(session==null)
        {
         System.out.println("connection is null");
        }else {
        	System.out.println("got conn");
        }
        String sessionId = sha.getSessionId();
 
        switch(sha.getCommand()) {
            case CONNECT:
                logger.debug("STOMP Connect [sessionId: " + sessionId + "]");
                System.out.println("STOMP Connect [sessionId: " + sessionId + "]");
               System.out.println("jdbc connectioin");
                try {
                Clients client= new Clients();
                client.setClientaddress(sha.getHost());
                client.setClientemailid("");
                client.setClienthost(sha.getHost());
                client.setClientid(sha.getReceiptId());
                client.setClientname(sha.getNack());
                client.setClientport(sha.getPasscode());
                client.setClienttype(sha.getReceipt());
                client.setSessionid(sessionId);
                client.setClietlocation(sha.getSubscriptionId());
                client.setStatus("active");
               session.beginTransaction();
                session.save(client);
                session.getTransaction().commit();
                
                System.out.println("we completed");
                }catch (Exception e) {
                e.printStackTrace();
                }
               
                break;
            case CONNECTED:
                logger.debug("STOMP Connected [sessionId: " + sessionId + "]");
                System.out.println("STOMP Connected [sessionId: " + sessionId + "]");
                break;
            case DISCONNECT:
                logger.debug("STOMP Disconnect [sessionId: " + sessionId + "]");
                System.out.println("STOMP Disconnect [sessionId: " + sessionId + "]");
                
                System.out.println("jdbc connectioin");
                try {
                   
                    session.beginTransaction();
                    Criteria cr= session.createCriteria(Clients.class);
                    cr.add(Restrictions.eq("sessionId", sessionId));
                    Clients cli= (Clients)cr.uniqueResult();
                    cli.setStatus("unactive");
                    session.update(cli);
                    session.getTransaction().commit();
                    
                    System.out.println("we completed");
                    }catch (Exception e) {
                    e.printStackTrace();
                    }
                   
                break;
            default:
                break;
 
        }
    }
}