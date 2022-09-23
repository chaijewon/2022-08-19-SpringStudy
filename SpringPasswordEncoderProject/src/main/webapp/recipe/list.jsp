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
      <div class="text-center">
       <form method="post" action="../recipe/list.do">
        <input type=text size=30 class="input-sm" name="type">
        <input type=submit value="검색" class="btn btn-sm btn-primary">
       </form>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../recipe/detail.do?no=${vo.no }">
		        <img src="${vo.poster }" style="width:100%">
		        <div class="caption">
		          <p style="font-size:8px">${vo.title }</p>
		          <p style="font-size:8px">By ${vo.chef }</p>
		        </div>
		      </a>
		    </div>
		 </div>
     </c:forEach>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
     <div class="text-center">
	      <ul class="pagination pagination-lg">
	         <c:if test="${startPage>1 }">
			   <li><a href="../recipe/list.do?page=${startPage-1 }&type=${type}">&lt;</a></li>
			 </c:if>
			 <c:forEach var="i" begin="${startPage }" end="${endPage}">
			  <c:if test="${curpage==i }">
			    <c:set var="style" value="class=active"/>
			  </c:if>
			  <c:if test="${curpage!=i }">
			    <c:set var="style" value=""/>
			  </c:if>
			  <li ${style}><a href="../recipe/list.do?page=${i }&type=${type}">${i }</a></li>
			 </c:forEach>
			  <c:if test="${endPage<totalpage }">
			   <li><a href="../recipe/list.do?page=${endPage+1 }&type=${type}">&gt;</a></li>
			  </c:if>
			</ul>
	  </div>
    </div>
  </div>
</body>
</html>





