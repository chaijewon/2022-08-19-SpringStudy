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
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="../main/main.do">Spring-Basic</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a href="../goods/new.do">신상품</a></li>
      <li><a href="../goods/special.do">특가</a></li>
      <li><a href="../goods/best.do">베스트</a></li>
      <li><a href="../goods/find.do">검색</a></li>
      <c:if test="${sessionScope.id!=null }">
       <li><a href="../member/logout.do">로그아웃</a></li>
      </c:if>
    </ul>
  </div>
</nav>
</body>
</html>