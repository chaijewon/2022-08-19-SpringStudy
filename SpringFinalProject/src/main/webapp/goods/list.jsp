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
    <h1 class="text-center">${title }</h1>
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-4">
	    <div class="thumbnail">
	      <a href="../goods/detail.do?no=${vo.no }&type=${type}">
	        <img src="${vo.goods_poster }" style="width:100%">
	        <div class="caption">
	          <p>${vo.goods_name }</p>
	          <sub>${vo.goods_price }</sub>
	        </div>
	      </a>
	    </div>
	  </div>
     </c:forEach>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
       <ul class="pager">
		  <li><a href="../goods/list.do?type=${type }&page=${curpage>1?curpage-1:curpage}">이전</a></li>
		  ${curpage } page / ${totalpage } pages
		  <li><a href="../goods/list.do?type=${type }&page=${curpage<totalpage?curpage+1:curpage}">다음</a></li>
		</ul>
      </div>
    </div>
  </div>
</body>
</html>





