<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <a href="output.do?no=1&name=홍길동&avg=10.5&isadmin=true">전송</a><%-- Get --%>
   <%--
        no=1  ========================= String , int
        name="홍길동" ================== String 
        =====> 모든 데이터는 String
        GET 
         <a> , location.href , sendRedirect() => @GetMapping
        POST
         <form> , ajax , axios => 선택 (post,get) => @PostMapping
         
        => bad request , get/post
    --%>
    <p>
    <form method=post action="output1.do">
      ID:<input type=text name=id size=20><br>
      PW:<input type=password name=pwd size=20><br>
      <button>전송</button>
    </form>
</body>
</html>







