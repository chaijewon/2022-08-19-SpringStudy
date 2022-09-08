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
    <div class="jumbotron">
      <h1 class="text-center">${cvo.title }</h1>
      <h4 class="text-center">${cvo.subject }</h4>
    </div>
    <%--
       JSP (Link) ==> @Controller(Model)처리 
                            |
                                              필요한 데이터 (DAO) === session
                            |
                                                  화면지정(return) ==> Model(전송객체)  
                       => 추천 
                       프로그램 (Back,Front) => 데이터 관리                                        
     --%>
    <div class="row">
      <table class="table">
        <tr>
          <td>
            <c:forEach var="vo" items="${list }">
              <table class="table">
                <tr>
                  <td width=30% rowspan="4">
                   <a href="../food/food_detail.do?fno=${vo.fno }">
                   <img src="${vo.poster }" style="width:300px;height: 200px" class="img-rounded"></a>
                  </td>
                  <td width=70%><h3><a href="../food/food_detail.do?fno=${vo.fno }">${vo.name }</a>&nbsp;<span style="color:orange">${vo.score }</span></h3></td>
                </tr>
                <tr>
                  <td>${vo.address }</td>
                </tr>
                <tr>
                  <td>${vo.tel }</td>
                </tr>
                <tr>
                  <td>${vo.type }</td>
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