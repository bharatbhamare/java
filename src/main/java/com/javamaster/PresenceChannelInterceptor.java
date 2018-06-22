package com.javamaster;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import com.javamaster.connection.DbConnection;
import com.javamaster.domain.Message;
import com.mysql.jdbc.PreparedStatement;

public class PresenceChannelInterceptor extends ChannelInterceptorAdapter {
 
    private final Log logger = LogFactory.getLog(PresenceChannelInterceptor.class);
    Connection conn=DbConnection.getConnection();
    
    @Override
    public void postSend(org.springframework.messaging.Message<?> message, MessageChannel channel, boolean sent) {
 
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
        int id=0;
       // ignore non-STOMP messages like heartbeat messages
        if(sha.getCommand() == null) {
            return;
        }
        if(conn==null)
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
        Statement stmt= conn.createStatement();
        String sql= "select count(*) from users";
        ResultSet rs= stmt.executeQuery(sql);
        if(rs.next())
        {
        	id=rs.getInt(1);
        }
        
        java.sql.PreparedStatement pstmt= conn.prepareStatement("insert into users value(?,?,?)");
              System.out.println("we prepare");
                pstmt.setInt(1, id);
              pstmt.setString(2, sessionId);
              pstmt.setString(3, sha.getMessage());
              int n=pstmt.executeUpdate();
              System.out.println("we completed");
                System.out.println("update: "+n);
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
                java.sql.PreparedStatement pstmt= conn.prepareStatement("insert into users value(?,?,?)");
              System.out.println("we prepare");
                pstmt.setInt(1, sha.getContentLength());
              pstmt.setString(2, sessionId);
              pstmt.setString(3, sha.getMessage());
              int n=pstmt.executeUpdate();
              System.out.println("we completed");
                System.out.println("update: "+n);
                }catch (Exception e) {
                e.printStackTrace();
                }
                break;
            default:
                break;
 
        }
    }
}