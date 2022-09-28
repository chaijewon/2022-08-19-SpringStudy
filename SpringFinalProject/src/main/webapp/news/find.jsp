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
      <form method="post" action="../news/find.do">
        <input type=text name=ss size=20 class="input-sm">
        <input type="submit" value="검색" class="btn btn-sm btn-danger">
      </form>
    </div>
    <div style="height: 30px"></div>
    <div class="row">
      <table class="table">
       <tr>
         <td>
           <c:forEach var="vo" items="${list }">
             <table class="table">
               <tr>
                <td style="color:orange">${vo.title }</td>
               </tr>
               <tr>
                <td><a href="${vo.link }" target="_blank">${vo.description }</a></td>
               </tr>
             </table>
           </c:forEach>
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>