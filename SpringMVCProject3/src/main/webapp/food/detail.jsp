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
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
       <tr>
         <c:forTokens items="${vo.poster }" delims="^" var="img">
           <td class="text-center">
             <img src="${img }" style="width: 100%">
           </td>
         </c:forTokens>
       </tr>
     </table>
    </div>
    <div style="height: 30px"></div>
     <div class="row">
       <table class="table">
         <tr>
           <td colspan="2">
            <h3>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h3>
           </td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>주소</th>
          <td width=75%>${vo.address }</td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>전화</th>
          <td width=75%>${vo.tel }</td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>음식종류</th>
          <td width=75%>${vo.type }</td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>가격대</th>
          <td width=75%>${vo.price }</td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>주차</th>
          <td width=75%>${vo.parking }</td>
         </tr>
         <tr>
          <th style="color:gray" width=25%>메뉴</th>
          <td width=75%>${vo.menu }</td>
         </tr>
         <tr>
           <td colspan="2" class="text-right">
             <a href="list.do" class="btn btn-sm btn-danger">목록</a>
           </td>
         </tr>
       </table>
     </div>
  </div>
</body>
</html>