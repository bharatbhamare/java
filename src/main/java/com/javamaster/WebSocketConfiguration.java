package com.javamaster;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration extends AbstractWebSocketMessageBrokerConfigurer  {
	
	public void configureMessageBroker(MessageBrokerRegistry confi) {
		confi.enableSimpleBroker("/chat");
		confi.setApplicationDestinationPrefixes("/app");
	}

	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/chat-messaging").withSockJS();
		
	}
	 @Bean
	    public PresenceChannelInterceptor presenceChannelInterceptor() {
	        return new PresenceChannelInterceptor();
	    }
	 
	    @Override
	    public void configureClientInboundChannel(ChannelRegistration registration) {
	        registration.setInterceptors(presenceChannelInterceptor());
	    }
	 
	    @Override
	    public void configureClientOutboundChannel(ChannelRegistration registration) {
	        registration.taskExecutor().corePoolSize(8);
	        registration.setInterceptors(presenceChannelInterceptor());
	    }
	 
}
