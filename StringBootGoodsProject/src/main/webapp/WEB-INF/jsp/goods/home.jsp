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
<div class="container">
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active">
        <img src="/images/main1.jpg"  style="width:100%;">
      </div>

      <div class="item">
        <img src="/images/main2.jpg"  style="width:100%;">
      </div>
    
      <div class="item">
        <img src="/images/main3.png"  style="width:100%;">
      </div>
      
      <div class="item">
        <img src="/images/main4.jpg"  style="width:100%;">
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <div style="height: 20px"></div>
  <div class="row">
    <h3 class="text-center">NOW 특가상품</h3>
    <c:forEach var="vo" items="${sList }">
      <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.goods_name }</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </c:forEach>
  </div>
  
  <div style="height: 20px"></div>
  <div class="row">
    <h3 class="text-center">베스트 상품</h3>
    <c:forEach var="vo" items="${bList }">
      <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.goods_name }</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </c:forEach>
  </div>
  
  <div style="height: 20px"></div>
  <div class="row">
    <h3 class="text-center">따끈따끈한 신상</h3>
    <c:forEach var="vo" items="${nList }">
      <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="#">
	        <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
	        <div class="caption">
	          <p>${vo.goods_name }</p>
	        </div>
	      </a>
	    </div>
	  </div>
    </c:forEach>
  </div>
</div>

</body>
</html>






