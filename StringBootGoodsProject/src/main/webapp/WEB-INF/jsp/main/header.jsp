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
      <a class="navbar-brand" href="#">FinalProject</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="../main/main">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">상품<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="../goods/list?type=1">전체 상품</a></li>
          <li><a href="../goods/list?type=4">베스트 상품</a></li>
          <li><a href="../goods/list?type=3">특가 상품</a></li>
          <li><a href="../goods/list?type=2">신상품</a></li>
        </ul>
      </li>
      <li><a href="#">뉴스</a></li>
      <li><a href="#">커뮤니티</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
    </ul>
  </div>
</nav>
</body>
</html>