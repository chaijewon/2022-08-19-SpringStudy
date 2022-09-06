<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 420px;
}
</style>
</head>
<body>
   <div class="container">
    <h1 class="text-center">로그인</h1>
    <div class="row">
     <form method=post action="../member/login_ok.do">
	      <table class="table">
	        <tr>
	          <th width=30% class="text-right">ID</th>
	          <td width=70%>
	           <input type=text name=id id=id class="input-sm" size=15>
	          </td>
	        </tr>
	        <tr>
	          <th width=30% class="text-right">PWD</th>
	          <td width=70%>
	           <input type=password name=pwd id=pwd class="input-sm" size=15>
	          </td>
	        </tr>
	        <tr>
	          <td colspan="2" class="text-center">
	            <input type="submit" value="로그인" class="btn btn-sm btn-danger">
	          </td>
	        </tr>
	      </table>
      </form>
    </div>
   </div>
</body>
</html>









