<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    </ul>
  </div>
</nav>
</body>
</html>