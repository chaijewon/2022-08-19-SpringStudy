<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script>
  $(function(){
	
    $('#postBtn').click(function(){
    	new daum.Postcode({
			oncomplete:function(data)
			{
				$('#post').val(data.zonecode)
				$('#addr1').val(data.address)
			}
		}).open()
    })
    
  });
  </script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">회원수정</h1>
    <div class="row">
     <form method="post" action="../member/join_update_ok.do">
      <table class="table">
        <tr>
          <th width=10% class="warning text-right">ID</th>
          <td width=90%>
            <input type=text class="input-sm" size=20 name="id" readonly="readonly" id="myid" value="${vo.id }">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">이름</th>
          <td width=90%>
            <input type=text class="input-sm" size=20 name="name" value="${vo.name }">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">성별</th>
          <td width=90%>
            <input type=radio name="sex" value="남자" ${vo.sex=='남자'?"checked":"" }>남자
            <input type=radio name="sex" value="여자" ${vo.sex=='여자'?"checked":"" }>여자
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">이메일</th>
          <td width=90%>
            <input type=text name="email" size=70 class="input-sm" value="${vo.email }">
            
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">우편번호</th>
          <td width=90%>
            <input type=text name="post" size=10 readonly="readonly" class="input-sm" id="post" value="${vo.post }">
            <input type=button class="btn btn-sm btn-danger" value="우편번호검색" id="postBtn">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">주소</th>
          <td width=90%>
            <input type=text name="addr1" size=70 class="input-sm" id="addr1" value="${vo.addr1 }">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">상세주소</th>
          <td width=90%>
            <input type=text name="addr2" size=70 class="input-sm" value="${vo.addr2 }">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">전화번호</th>
          <td width=90%>
            <input type=text name="tel1" size=15 class="input-sm" value="010" readonly="readonly">-
            <input type=text name="tel2" size=15 class="input-sm" value="${fn:substring(vo.tel,4,13) }">
            <%--
                  010-1111-1111
                  ====
             --%>
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">소개</th>
          <td width=90%>
            <textarea rows="7" cols="70" name="content">${vo.content }</textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="회원수정" class="btn btn-sm btn-primary">
            <input type=button value="취소" class="btn btn-sm btn-primary"
              onclick="javascript:history.back()"
            >
          </td>
        </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>