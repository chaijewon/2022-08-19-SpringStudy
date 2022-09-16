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
      <a class="navbar-brand" href="../main/main.do">TilesExample</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">서울 여행
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../seoul/list.do?tab=1">명소</a></li>
          <li><a href="../seoul/list.do?tab=2">자연</a></li>
          <li><a href="../seoul/list.do?tab=3">쇼핑</a></li>
        </ul>
      </li>
      <li><a href="../recipe/list.do">레시피</a></li>
      <li><a href="../chat/chat.do">채팅</a></li>
      <li><a href="../food/food_find.do">맛집 검색(일반)</a></li>
      <li><a href="../food/food_find_vue.do">맛집 검색(Vue)</a></li>
      <li><a href="../recommand/recommand.do">맛집 추천(Ajax)</a></li>
      <li><a href="../recommand/recommand_vue.do">맛집 추천(Vue)</a></li>
      <li><a href="../board/list.do">게시판(Vue)</a></li>
      <c:if test="${sessionScope.id!=null }">
        <li><a href="../member/logout.do">로그아웃</a></li>
      </c:if>
      <c:if test="${sessionScope.id==null }">
        <li><a href="../member/login.do">로그인</a></li>
      </c:if>
    </ul>
  </div>
</nav>
</body>
</html>