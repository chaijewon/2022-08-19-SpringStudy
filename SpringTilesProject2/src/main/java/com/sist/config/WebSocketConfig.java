package com.sist.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.sist.webchat.WebSocketChatHandler;

//@Configuration
//@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer{

	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// TODO Auto-generated method stub
		// 서버 등록 => URL주소가 넘겨올때  => /chat-ws
		System.out.println("1. registerWebSocketHandlers() Call...");
		registry.addHandler(chatHandler(), "/site/chat/chat-ws");
	}
	
	@Bean
	public WebSocketChatHandler chatHandler()
	{
		System.out.println("2. chatHandler()");
		return new WebSocketChatHandler();
	}

}