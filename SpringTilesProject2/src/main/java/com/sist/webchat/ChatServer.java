package com.sist.webchat;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import java.util.*;
@ServerEndpoint("/site/chat/chat-ws")
public class ChatServer {
	private static Set<Session> users = Collections
			.synchronizedSet(new HashSet<Session>());
   @OnOpen
   public void onOpen(Session session)
   {  
	    users.add(session);
	    System.out.println("클라이언트 입장...:"+session.getId());
   }
   @OnClose
   public void onClose(Session session)
   {
	   users.remove(session);
	   System.out.println("클라인언트 퇴장..:"+session.getId());
   }
   @OnMessage
   public void onMessage(String message,Session session) throws Exception
   {
	   // 동기화 
	   synchronized (users) {
		 for(Session client:users)
		 {
			 client.getBasicRemote().sendText(message);
		 }
	   }
   }
}