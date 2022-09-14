package com.sist.webchat;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
// 처리 (채팅)
import java.util.*;
import java.util.concurrent.*;
public class WebSocketChatHandler extends TextWebSocketHandler{
   // 접속한 사람 저장 : ID가 한개만 설정
    private Map<String,WebSocketSession> users=new HashMap<String,WebSocketSession>();

    // 클라이언트가 접속했을 때 자동으로 호출되는 메소드 => 클라이언트 정보 저장 (WebSocketSession=>ip정보 , sessionId)
    /*
        일반 웹사이트 : http,https
        웹소켓 : ws
         => DispatcherServlet : 메세지훅 
        채팅 서버 별도 : NodeJS => VueJS,ReactJS 
     */
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getId()+"님이 입장하셨습니다!!");
		users.put(session.getId(), session); // 접속자 정보를 저장 
		
	}
	
	// 클라이언트 채팅 문자열을 전송 => 접속된 모든 클라이언트에 전송된 문자열 전달 
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		for(WebSocketSession ws:users.values())
		{
			ws.sendMessage(message);
		}
	}
	
	//log파일로 출력 => 클라이언트에 대한 에러 출력 
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		super.handleTransportError(session, exception);
	}
	// 클라이언트가 퇴장을 했을 경우 처리 => Map에서 제거 
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(session.getId()+"님이 퇴장하셨습니다!!");
		users.remove(session.getId());
	}
   
}