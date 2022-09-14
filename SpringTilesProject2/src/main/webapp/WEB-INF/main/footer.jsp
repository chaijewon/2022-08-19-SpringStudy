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
      <div class="col-sm-4">
       <h3>인기 명소</h3>
       <hr>
       <ul>
         <c:forEach var="svo" items="${sList }">
           <li>${svo.title }(${svo.hit })</li>
         </c:forEach>
       </ul>
      </div>
      <div class="col-sm-4">
       <h3>인기 자연</h3>
       <hr>
       <ul>
         <c:forEach var="nvo" items="${nList }">
           <li>${nvo.title }(${nvo.hit })</li>
         </c:forEach>
       </ul>
      </div>
      <div class="col-sm-4">
       <h3>인기 뮤직</h3>
       <hr>
       <ul>
         <c:forEach var="mvo" items="${mList }">
           <li>${mvo.title }(${mvo.singer })</li>
         </c:forEach>
       </ul>
      </div>
    </div>
  </div>
</body>
</html>