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
    <h1 class="text-center">상품 검색</h1>
    <div class="row">
      <form method="post" action="../goods/find.do">
	      <select name="fs" class="input-sm">
	        <option value="goods_all">전체</option>
	        <option value="goods_special">특가</option>
	        <option value="goods_best">베스트</option>
	        <option value="goods_new">신상품</option>
	      </select>
	      <input type=text name="ss" size=20 class="input-sm">
	      <input type=submit value="검색" class="btn btn-sm btn-danger">
      </form>
    </div>
    
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../goods/all_detail.do?no=${vo.no }">
		        <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>${vo.goods_name }</p>
		          <p>${vo.goods_price }</p>
		        </div>
		      </a>
		    </div>
		  </div>
     </c:forEach>
    </div>
  </div>
</body>
</html>