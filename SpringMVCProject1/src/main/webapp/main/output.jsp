<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${name }<br>
성별:${sex }<br>
지역:${loc}<br>
소개:${content }<br>
<c:if test="${hobby!=null }">
  <ul>
  <c:forEach var="hobby" items="${hobby }">
    <li>${hobby }</li>
  </c:forEach>
  </ul>
</c:if>
<c:if test="${hobby==null }">
   취미가 없습니다
</c:if>
</body>
</html>