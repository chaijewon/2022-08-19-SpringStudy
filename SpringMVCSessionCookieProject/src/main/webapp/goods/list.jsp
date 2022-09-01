<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 100%
}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $(function(){
    $('#cookieView').on("click",function(){
    	$('#dialog').dialog({
    		title:'쿠키 전체 보기',
    		width:960,
    	    height:600,
    	    modal:true,
    	    autoOpen:false
    	}).dialog("open");
    })
  });
</script>
</head>
<body>
 <div class="container">
     <div class="row">
       <c:forEach var="vo" items="${list }">
         <div class="col-md-4">
		      <div class="thumbnail">
		        <a href="detail_before.do?no=${vo.no }">
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
     <div style="height: 20px"></div>
     <div class="row">
       <div class="text-center">
         <a href="list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-primary">이전</a>
          ${curpage } page / ${totalpage } pages
         <a href="list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
       </div>
     </div>
     <div style="height: 50px"></div>
     <div class="row">
      <h3>최근 방문 상품</h3>
      <a href="cookie_all_delete.do" class="btn btn-xs btn-danger">쿠키전체삭제</a>
      <span class="btn btn-xs btn-danger" id="cookieView">쿠키전체보기</span>
      <hr>
      <c:if test="${size<1 }">
        <span style="color:orange">방문 기록이 없습니다</span>
      </c:if>
      <c:if test="${size>0 }">
       <c:forEach var="vo" items="${cList }" varStatus="s">
         <c:if test="${s.index<6 }">
         <div class="col-md-2">
		      <div class="thumbnail">
		        <a href="#">
		          <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
		          <div class="caption">
		            <p><a href="cookie_delete.do?no=${vo.no }" class="btn btn-xs btn-danger">삭제</a></p>
		          </div>
		        </a>
		      </div>
		   </div>
		  </c:if>
       </c:forEach>
      </c:if>
     </div>
  </div>
  <div id="dialog" title="Basic dialog" style="display:none">
      <c:if test="${size<1 }">
        <span style="color:orange">방문 기록이 없습니다</span>
      </c:if>
      <c:if test="${size>0 }">
       <c:forEach var="vo" items="${cList }" varStatus="s">
         <div class="col-md-2">
		      <div class="thumbnail">
		        <a href="#">
		          <img src="${vo.goods_poster }" alt="Lights" style="width:100%">
		          <div class="caption">
		            
		          </div>
		        </a>
		      </div>
		   </div>
       </c:forEach>
      </c:if>
  </div>
</body>
</html>







