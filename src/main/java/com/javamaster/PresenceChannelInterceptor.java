package com.javamaster;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import com.javamaster.domain.Message;

public class PresenceChannelInterceptor extends ChannelInterceptorAdapter {
 
    private final Log logger = LogFactory.getLog(PresenceChannelInterceptor.class);
 
    @Override
    public void postSend(org.springframework.messaging.Message<?> message, MessageChannel channel, boolean sent) {
 
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(message);
 
        // ignore non-STOMP messages like heartbeat messages
        if(sha.getCommand() == null) {
            return;
        }
 
        String sessionId = sha.getSessionId();
 
        switch(sha.getCommand()) {
            case CONNECT:
                logger.debug("STOMP Connect [sessionId: " + sessionId + "]");
                System.out.println("STOMP Connect [sessionId: " + sessionId + "]");
                break;
            case CONNECTED:
                logger.debug("STOMP Connected [sessionId: " + sessionId + "]");
                System.out.println("STOMP Connected [sessionId: " + sessionId + "]");
                break;
            case DISCONNECT:
                logger.debug("STOMP Disconnect [sessionId: " + sessionId + "]");
                System.out.println("STOMP Disconnect [sessionId: " + sessionId + "]");
                break;
            default:
                break;
 
        }
    }
}