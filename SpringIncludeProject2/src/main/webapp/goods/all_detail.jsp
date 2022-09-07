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
     <table class="table">
       <tr>
         <td width=30% class="text-center" rowspan="4">
           <img src="${vo.goods_poster }" style="width: 100%">
         </td>
         <td width=70%><h3>${vo.goods_name }</h3>
           <sub style="color:gray">${vo.goods_sub }</sub>
         </td>
       </tr>
       <tr>
         <td width=70%><span style="color:orange">${vo.goods_discount }%</span>&nbsp;${vo.goods_price }</td>
       </tr>
       <tr>
         <td width=70% style="color:green">첫구매할인가 &nbsp;${vo.goods_first_price }</td>
       </tr>
       <tr>
         <td width=70%>배송:${vo.goods_delivery }</td>
       </tr>
       <tr>
         <td colspan="2" class="text-right">
          <input type=button value="목록" class="btn btn-sm btn-primary"
            onclick="javascript:history.back()"
          >
         </td>
       </tr>
     </table>
    </div>
    <div style="height: 20px"></div>
    <hr>
    <div class="col-sm-8">
      <table class="table">
        <tr>
          <td>
            <c:forEach var="rvo" items="${rList }">
              <table class="table">
                <tr>
                 <td class="text-left">
                   <c:if test="${rvo.group_tab>0 }">
                    <c:forEach var="i" begin="1" end="${rvo.group_tab }">
                      &nbsp;&nbsp;
                    </c:forEach>
                      <img src="../goods/re_icon.png">
                   </c:if>
                                         ◎<span style="color:orange">${rvo.name }</span>&nbsp;(${rvo.dbday })
                 </td>
                 <td class="text-right">
                   <c:if test="${sessionScope.id!=null }">
                     <c:if test="${sessionScope.id==rvo.id }">
                       <a href="#" class="btn btn-xs btn-danger">수정</a>
                       <a href="#" class="btn btn-xs btn-primary">삭제</a>
                     </c:if>
                     <a href="#" class="btn btn-xs btn-info">댓글</a>
                   </c:if>
                 </td>
                </tr>
                <tr>
                  <td colspan="2">
                   <c:if test="${rvo.group_tab>0 }">
                    <c:forEach var="i" begin="1" end="${rvo.group_tab }">
                      &nbsp;&nbsp;
                    </c:forEach>
                   </c:if>
                   <pre style="white-space: pre-wrap;border: none;background-color: white;">${rvo.msg }</pre>
                  </td>
                </tr>
              </table>
            </c:forEach>
          </td>
        </tr>
      </table>
      <c:if test="${sessionScope.id!=null }">
	      <table class="table">
	        <tr>
	          <td>
	           <form method="post" action="">
	            <textarea rows="5" cols="85" name="msg" style="float: left"></textarea>
	            <input type=button value="댓글쓰기" style="height:103px;float: left" class="btn btn-sm btn-danger">
	           </form>
	          </td>
	        </tr>
	      </table>
      </c:if>
    </div>
    <div class="col-sm-4">
      
    </div>
  </div>
</body>
</html>







