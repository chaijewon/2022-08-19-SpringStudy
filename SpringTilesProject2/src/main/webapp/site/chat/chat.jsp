<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row2{
  margin: 0px auto;
  width:450px;
  height: 800px;
}
h1 {
  text-align: center;
}
#chatArea{
  height: 150px;
  overflow-y:auto;
  border:1px solid black;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
 var websocket;
 function connection()
 {
	 // websocket 등록 
	 websocket=new WebSocket("ws://localhost:8080/web/site/chat/chat-ws");
	 websocket.onopen=onOpen;
	 websocket.onmessage=onMessage;
	 websocket.onclose=onClose;
	 
 }
 function onOpen(event)
 {
	 // 서버 연결
	 alert("채팅 서버와 연결되었습니다!!");
 }
 function onMessage(event)
 {
	 // 서버에 값을 전송
	 var data=event.data;
	 if(data.substring(0,4)=="msg:")
	 {
	     // 100 LOGIN , 200 방만들기 
	     appendMessage(data.substring(4));
	 }
 }
 function onClose(event)
 {
	 // 종료
	 alert("채팅서버와 연결 종료되었습니다!!");
 }
 function disconnection()
 {
	 // 서버연결 해제
	 websocket.close();
 }
 function send()
 {
	 // 전송 
	 var name=$('#name').val();
	 if(name.trim()=="")
	 {
		 $('#name').focus();
		 return;
	 }
	 var msg=$('#sendMsg').val();
	 if(msg.trim()=="")
	 {
		 $('#sendMsg').focus();
		 return;
	 }
	 websocket.send("msg:["+name+"]"+msg);
	 $('#sendMsg').val("");
	 $('#sendMsg').focus();
	 
 }
 function appendMessage(msg)
 {
	 // 채팅문자열을 결합 
	 $('#recvMsg').append(msg+"<br>");
	 var ch=$('#chatArea').height();
	 var m=$('#recvMsg').height()-ch;
	 $('#chatArea').scrollTop(m);
 }
 
 $(function(){
	 $('#startBtn').click(function(){
		 connection();
	 });
	 $('#endBtn').click(function(){
		 disconnection();
	 });
	 $('#sendBtn').click(function(){
		 send();
	 })
 })
</script>
</head>
<body>
  <div style="height: 50px"></div>
  <div class="container">
   <h1>WebSocket 채팅 프로그램</h1>
   <div class="row row2">
     <table class="table">
      <tr>
        <td>
         이름:<input type=text id="name" class="input-sm">
         <input type="button" id="startBtn" value="입장" class="btn btn-sm btn-primary">
         <input type="button" id="endBtn" value="퇴장" class="btn btn-sm btn-danger">
        </td>
      </tr>
      <tr>
        <td>
         <div id="chatArea">
           <div id="recvMsg"></div>
         </div>
        </td>
      </tr>
      <tr>
        <td>
         <input type=text id="sendMsg" size=50 class="input-sm">
         <input type=button id="sendBtn" value="전송" class="btn btn-sm btn-success">
        </td>
      </tr>
     </table>
   </div>
  </div>
</body>
</html>