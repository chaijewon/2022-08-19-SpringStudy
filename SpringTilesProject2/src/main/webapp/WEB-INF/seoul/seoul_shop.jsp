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
       <c:forEach var="vo" items="${list }">
         <div class="col-md-4">
		    <div class="thumbnail">
		      <a href="../seoul/detail.do?tab=3&no=${vo.no }">
		        <img src="${vo.poster }" alt="Lights" style="width:350px;height: 200px">
		        <div class="caption">
		          <p>${vo.title }</p>
		        </div>
		      </a>
		    </div>
		  </div>
       </c:forEach>
     </div>
     <div style="height: 20px"></div>
     <div class="row">
      <div class="text-center">
        <a href="../seoul/list.do?tab=3&page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
        ${curpage } page / ${totalpage } pages
        <a href="../seoul/list.do?tab=3&page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-danger">다음</a>
      </div>
     </div>
   </div>

</body>
</html>