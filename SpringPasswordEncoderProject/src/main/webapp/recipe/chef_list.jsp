<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
   margin: 0px auto;
   width: 700px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row row1">
      <table class="table">
       <tr>
         <td>
           <c:forEach var="vo" items="${list }">
             <table class="table">
              <tr>
                <td width=30% class="text-center" rowspan="2">
                  <a href="../recipe/chef_detail.do?no=${vo.no }">
                  <img src="${vo.poster }" style="width: 150px;height: 120px" class="img-circle"></a>
                </td>
                <td width=70% colspan="4"><h3><a href="../recipe/chef_detail.do?no=${vo.no }">${vo.chef }</a></h3></td>
              </tr>
              <tr>
                <td class="text-center"><img src="../recipe/mc1.png">&nbsp;${vo.mem_cont1 }</td>
                <td class="text-center"><img src="../recipe/mc2.png">&nbsp;${vo.mem_cont2 }</td>
                <td class="text-center"><img src="../recipe/mc7.png">&nbsp;${vo.mem_cont7 }</td>
                <td class="text-center"><img src="../recipe/mc3.png">&nbsp;${vo.mem_cont3 }</td>
              </tr>
             </table>
           </c:forEach>
         </td>
       </tr>
      </table>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <div class="text-center">
        <a href="../recipe/chef_list.do?page=${curpage>1?curpage-1:curpage }" class="btn btn-sm btn-warning">이전</a>
        ${curpage} page / ${totalpage } pages
        <a href="../recipe/chef_list.do?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-sm btn-info">다음</a>
      </div>
    </div>
  </div>
</body>
</html>





