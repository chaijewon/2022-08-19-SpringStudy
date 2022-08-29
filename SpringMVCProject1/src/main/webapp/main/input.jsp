<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       JSP는 변경사항이 없다 
       EL / JSTL 
 --%>
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
.row{
  margin: 0px auto;
  width:500px;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
      <h1 class="text-center">회원 정보</h1>
      <form method=post action="output2.do">
      <table class="table">
        <tr>
          <td class="text-right" width=20%>이름</td>
          <td width=80%>
            <input type=text name=name size=20 class="input-sm">
          </td>
        </tr>
        <tr>
          <td class="text-right" width=20%>성별</td>
          <td width=80%>
            <input type="radio" name="sex" value="남자" checked>남자
            <input type="radio" name="sex" value="여자" checked>여자
          </td>
        </tr>
        <tr>
          <td class="text-right" width=20%>지역</td>
          <td width=80%>
            <select name="loc">
              <option>서울</option>
              <option>경기</option>
              <option>인천</option>
              <option>제주</option>
              <option>부산</option>
            </select>
          </td>
        </tr>
        <tr>
          <td class="text-right" width=20%>소개</td>
          <td width=80%>
            <textarea rows="10" cols="50" name="content"></textarea>
          </td>
        </tr>
        <tr>
          <td class="text-right" width=20%>취미</td>
          <td width=80%>
            <input type="checkbox" name=hobby value="운동">운동
            <input type="checkbox" name=hobby value="등산">등산
            <input type="checkbox" name=hobby value="여행">여행
            <input type="checkbox" name=hobby value="게임">게임
            <input type="checkbox" name=hobby value="낚시">낚시
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=submit value="전송" class="btn btn-sm btn-danger">
          </td>
        </tr>
      </table>
      </form>
     </div>
   </div>
</body>
</html>








