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
  width: 800px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let u=0;
$(function(){
	$('.up').click(function(){
		$('.updates').hide();
		let no=$(this).attr("data-no");
		if(u==0)
		{
			$('#u'+no).show();
			$(this).text("취소");
			u=1;
		}
		else
		{
			$('#u'+no).hide();
			$(this).text("수정");
			u=0;
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td>
           <img src="${vo.poster }" style="width: 800px;height: 350px">
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.title }</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.msg }</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.address }</h3>
          </td>
        </tr>
        <tr>
          <td class="text-right">
            <a href="../seoul/list.do?tab=${tab }" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div style="height: 20px"></div>
    <div class="row row1">
      <table class="table">
        <tr>
          <td>
           <c:forEach var="rvo" items="${list }">
             <table class="table">
               <tr>
                 <td class="text-left">
                                        ◑<span style="color:orange">${rvo.name }</span>&nbsp;(${rvo.dbday })
                 </td>
                 <td class="text-right">
                   <c:if test="${sessionScope.id==rvo.id }">
                     <span class="btn btn-xs btn-info up" data-no="${rvo.no }">수정</span>
                     <a href="../reply/delete.do?no=${rvo.no }&type=${tab}&cno=${vo.no}" class="btn btn-xs btn-success">삭제</a>
                   </c:if>
                 </td>
               </tr>
               <tr>
                 <td colspan="2" valign="top">
                  <pre style="white-space: pre-wrap;background-color: white;border:none">${rvo.msg }</pre>
                 </td>
               </tr>
               <tr style="display:none" id="u${rvo.no }" class="updates">
		          <td>
		           <form method="post" action="../reply/update.do">
		            <textarea rows="5" cols="80" style="float: left" name="msg">${rvo.msg }</textarea>
		            <input type=hidden name="no" value="${rvo.no }">
		            <input type="hidden" name="cno" value="${vo.no }">
		            <input type="hidden" name="type" value="${tab }">
		            <input type=submit value="댓글수정" class="btn btn-sm btn-danger" style="height: 105px;float: left">
		           </form>
		          </td>
		        </tr>
             </table>
           </c:forEach>
          </td>
        </tr>
      </table>
      <c:if test="${sessionScope.id!=null }"><%--로그인시에만  --%>
	      <table class="table">
	        <tr>
	          <td>
	           <form method="post" action="../reply/insert.do">
	            <textarea rows="5" cols="93" style="float: left" name="msg"></textarea>
	            <input type="hidden" name="cno" value="${vo.no }">
	            <input type="hidden" name="type" value="${tab }">
	            <input type=submit value="댓글쓰기" class="btn btn-sm btn-danger" style="height: 105px;float: left">
	           </form>
	          </td>
	        </tr>
	      </table>
      </c:if>
    </div>
  </div>
</body>
</html>






