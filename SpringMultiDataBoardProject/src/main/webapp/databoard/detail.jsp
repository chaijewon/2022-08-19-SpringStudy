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
   width: 700px;
}
h1 {
   text-align: center
}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Word', 'Count'],
         <c:forEach var="dvo" items="${list}">
          ['<c:out value="${dvo.word}"/>',     <c:out value="${dvo.count}"/>],
         </c:forEach>
        ]);

        var options = {
          title: '데이터분석',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>
</head>
<body>
   <div class="container">
     <h1>상세보기</h1>
     <div class="row">
      <table class="table">
        <tr>
         <th width=20% class="text-center warning">번호</th>
         <td width=30% class="text-center">${vo.no }</td>
         <th width=20% class="text-center warning">작성일</th>
         <td width=30% class="text-center">${vo.dbday }</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">이름</th>
         <td width=30% class="text-center">${vo.name }</td>
         <th width=20% class="text-center warning">조회수</th>
         <td width=30% class="text-center">${vo.hit }</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">제목</th>
         <td colspan="3">${vo.subject }</td>
        </tr>
        <c:if test="${vo.filecount!=0 }">
          <tr>
            <th width=20% class="text-center warning">첨부파일</th>
            <td colspan="3">
              <ul>
               <c:forEach var="fname" items="${fList }" varStatus="s">
                 <li><a href="download.do?fn=${fname }">${fname }</a>(${sList[s.index]}Bytes)</li>
               </c:forEach>
              </ul>
            </td>
          </tr>
        </c:if>
        <tr>
          <td colspan="4" class="text-left" valign="top" height="200">
           <pre style="white-space: pre-wrap;border:none;background-color: white;">${vo.content }</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a href="update.do?no=${vo.no }" class="btn btn-xs btn-info">수정</a>
            <a href="delete.do?no=${vo.no }" class="btn btn-xs btn-warning">삭제</a>
            <a href="list.do" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
      </table>
     </div>
     <div style="height: 20px"></div>
     <div class="row">
       <div class="text-center">
         <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
       </div>
     </div>
   </div>
</body>
</html>