package com.sist.chat;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import java.util.*;
@ServerEndpoint("/site/chat/chat-ws")
public class ChatServer {
    private static List<Session> users=new ArrayList<Session>();
    //  접속자의 중복을 허용하지 않는다 ===========> 저장시에는 동기화 
    //  NodeJS ==> VUE,React
	@OnOpen
	public void onOpen(Session session)
	{
		users.add(session);
		System.out.println("클라이언트 접속...:"+session.getId());
	}
	@OnClose
	public void onClose(Session session)
	{
		users.remove(session);
		System.out.println("클라이언트 퇴장...:"+session.getId());
	}
	@OnMessage
	public void onMessage(String message,Session session) throws Exception
	{
		 System.out.println("수신 된메시지 : " + message);

		
	    //세션리스트에게 데이터를 보낸다.
	    Iterator<Session> iterator = users.iterator();
	    System.out.println("현재명:"+users.size());
	    while(iterator.hasNext()){
	    	//해당 데이터를 다른 세션들에게 뿌린다.
	  	  iterator.next().getBasicRemote().sendText(message);
	  	  System.out.println(session.getId()+"전송");
	    }
        
	}
}








