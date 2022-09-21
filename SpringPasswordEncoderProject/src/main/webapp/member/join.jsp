<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery.js"></script>
  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
  <script>
  $(function(){
    //$( "#dialog" ).dialog();
    $('#idcheck').click(function(){
    	$( "#dialog" ).dialog();
    })
  });
  </script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">회원가입</h1>
    <div class="row">
     <form method="post" action="../member/join_ok.do">
      <table class="table">
        <tr>
          <th width=10% class="warning text-right">ID</th>
          <td width=90%>
            <input type=text class="input-sm" size=20 name="id" readonly="readonly">
            <input type=button class="btn btn-sm btn-danger" value="아이디중복체크" id="idcheck">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">Password</th>
          <td width=90%>
            <input type=password class="input-sm" size=20 name="pwd">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">이름</th>
          <td width=90%>
            <input type=text class="input-sm" size=20 name="name">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">성별</th>
          <td width=90%>
            <input type=radio name="sex" value="남자" checked="checked">남자
            <input type=radio name="sex" value="여자">여자
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">생년월일</th>
          <td width=90%>
            <input type=date name="birthday" size=20>
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">이메일</th>
          <td width=90%>
            <input type=text name="email" size=70 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">우편번호</th>
          <td width=90%>
            <input type=text name="post" size=10 readonly="readonly" class="input-sm">
            <input type=button class="btn btn-sm btn-danger" value="우편번호검색">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">주소</th>
          <td width=90%>
            <input type=text name="addr1" size=70 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">상세주소</th>
          <td width=90%>
            <input type=text name="addr2" size=70 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">전화번호</th>
          <td width=90%>
            <input type=text name="tel1" size=15 class="input-sm" value="010" readonly="readonly">-
            <input type=text name="tel2" size=15 class="input-sm">
          </td>
        </tr>
        <tr>
          <th width=10% class="warning text-right">소개</th>
          <td width=90%>
            <textarea rows="7" cols="70" name="content"></textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="회원가입" class="btn btn-sm btn-primary">
            <input type=button value="취소" class="btn btn-sm btn-primary"
              onclick="javascript:history.back()"
            >
          </td>
        </tr>
      </table>
      </form>
    </div>
    <div id="dialog" title="Basic dialog" style="display:none">
     <p>This is the default dialog which is useful for displaying information. The dialog window can be moved, resized and closed with the &apos;x&apos; icon.</p>
    </div>
  </div>
</body>
</html>