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
//쿠키가져오기
Cookie[] cookies = request.getCookies();
if(cookies != null){
    for(Cookie tempCookie : cookies){
        if(tempCookie.getName().equals("id")){
            //실행흐름이 서버에 있을때 서버코드로써 강제이동한다.
            //특정 page로 이동하라는 정보만 준다.
            response.sendRedirect("session_Main.jsp");
        }
    }
}
%>
    <h1>로그인</h1>
    <form action = "session_LoginPro.jsp" method="post">
        아이디 : <input type="text" name="id"><br>
        패스워드 : <input type="password" name = "passwd"><br>
        <input type = "checkbox" name="loginChk" value = "true">로그인 상태유지<br>
        <input type = "submit" value="로그인">
    </form>
</body>
</html>
