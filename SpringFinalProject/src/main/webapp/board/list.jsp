<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
   text-align: center
}
</style>
</head>
<body>
   <div class="container">
     <h1>게시판 목록</h1>
     <div class="row" style="height: 650px">
       <table class="table">
         <tr>
           <td>
             <a href="../board/insert.do" class="btn btn-sm btn-primary">새글</a>
           </td>
         </tr>
       </table>
       <table class="table">
         <tr class="success">
           <th class="text-center" width=10%>번호</th>
           <th class="text-center" width=45%>제목</th>
           <th class="text-center" width=15%>이름</th>
           <th class="text-center" width=20%>작성일</th>
           <th class="text-center" width=10%>조회수</th>
         </tr>
         <c:forEach var="vo" items="${list }">
             <tr>
	           <td class="text-center" width=10%>${vo.no }</th>
	           <td width=45%><a href="detail.do?no=${vo.no }">${vo.subject }</a></th>
	           <td class="text-center" width=15%>${vo.name }</th>
	           <td class="text-center" width=20%>${vo.dbday }</th>
	           <td class="text-center" width=10%>${vo.hit }</th>
	         </tr>
         </c:forEach>
       </table>
       <table class="table">
         <tr>
           <td class="text-left">
            <form method=post action="find.do">
	            <input type="checkbox" name=fd value="N">이름
	            <input type="checkbox" name=fd value="S">제목
	            <input type="checkbox" name=fd value="C">내용
	            <input type=text name=ss size=20 class="input-sm">
	            <button class="btn btn-sm btn-success">검색</button>
            </form>
           </td>
           <td class="text-right">
            <a href="../board/list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-danger">이전</a>
            ${curpage } page / ${totalpage } pages
            <a href="../board/list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-primary">다음</a>
           </td>
         </tr>
       </table>
     </div>
   </div>
</body>
</html>








