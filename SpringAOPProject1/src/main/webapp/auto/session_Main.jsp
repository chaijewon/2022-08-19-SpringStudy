<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if(cookies !=null){
        for(Cookie tempCookie : cookies){
            if(tempCookie.getName().equals("id")){
                //쿠키값으로 대신 로그인 처리함
                session.setAttribute("id", tempCookie.getValue());
            }
        }
    }
%>
 
    <%
        //세션값 가져오기, Object형으로 저장되기에 다운케스팅이 필요하다.
        String id =(String)session.getAttribute("id");
        
    %>
    <h1>고객페이지</h1>
    <b><%=id %> 님이 로그인 했습니다.</b>
    <input type="button" value="로그아웃" onclick="location.href='session_Logout.jsp'">
</body>
</html>
