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
      <form method="post" action="../recipe/chef_detail.do">
       <input type=hidden name=no value="${no }">
       <input type=text size=30 name=ss class="input-sm" value="${ss==null?'':ss }">
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
        <a href="../recipe/chef_detail.do?page=${curpage>1?curpage-1:curpage }&no=${no}&ss=${ss}" class="btn btn-sm btn-warning">이전</a>
        ${curpage} page / ${totalpage } pages
        <a href="../recipe/chef_detail.do?page=${curpage<totalpage?curpage+1:curpage }&no=${no}&ss=${ss}" class="btn btn-sm btn-info">다음</a>
      </div>
   </div>
  </div>
</body>
</html>