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
    <div class="row">
      <%-- VueJS --%>
      <div class="text-center">
        <a href="../main/main.do?no=1" class="btn btn-lg btn-info">믿고 보는 맛집 리스트</a>
        <a href="../main/main.do?no=2" class="btn btn-lg btn-warning">지역별 인기 맛집</a>
        <a href="../main/main.do?no=3" class="btn btn-lg btn-success">인기 메뉴별 맛집</a>
      </div>
    </div>
    <div style="height: 30px"></div>
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../food/food_list.do?cno=${vo.cno }">
		        <img src="${vo.poster }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
     </c:forEach>
    </div>
  </div>
</body>
</html>






