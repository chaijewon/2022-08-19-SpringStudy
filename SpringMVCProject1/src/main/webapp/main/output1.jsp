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
이름:${vo.name }<br>
성별:${vo.sex }<br>
지역:${vo.loc}<br>
소개:${vo.content }<br>
<c:if test="${vo.hobby!=null }">
  <ul>
  <c:forEach var="hobby" items="${vo.hobby }">
    <li>${hobby }</li>
  </c:forEach>
  </ul>
</c:if>
<c:if test="${vo.hobby==null }">
   취미가 없습니다
</c:if>
</body>
</html>