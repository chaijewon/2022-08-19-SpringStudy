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
    //session 초기화
    session.invalidate();
    
    //로그인 관련 쿠키 삭제
    /*Cookie[] cookies = request.getCookies();
    if(cookies!=null){
        for(Cookie tempCookie : cookies){
            if(tempCookie.getName().equals("id")){
                tempCookie.setMaxAge(0);
                tempCookie.setPath("/");
                response.addCookie(tempCookie);
                
            }
        }
    }*/
%>
    <script>
        alert('로그아웃 됨');
        location.href = 'session_Login.jsp';
    </script>
</body>
</html>
