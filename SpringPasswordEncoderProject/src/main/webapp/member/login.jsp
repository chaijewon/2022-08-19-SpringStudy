<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
   margin: 0px auto;
   width: 350px
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){
		let id=$('#id').val();
		if(id.trim()==="")
		{
			$('#id').focus();
			return;
		}
		let pwd=$('#pwd').val();
		if(pwd.trim()==="")
		{
			$('#pwd').focus();
			return;
		}
		let ck=$("#ck").is(":checked");
		$.ajax({
			type:'post',
			url:'../member/login_ok.do',
			data:{"id":id,"pwd":pwd,"ck":ck},
			success:function(result)
			{
				let res=result.trim();
				if(res==='NOID')
				{
					alert("아이디 존재하지 않습니다!!");
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
				}
				else if(res==='NOPWD')
				{
					alert("비밀번호가 틀립니다!!");
					$('#pwd').val("");
					$('#pwd').focus();
				}
				else
				{
					location.href="../main/main.do";
				}
			}
		})
	})
})
</script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">Login</h1>
    <div class="row row1">
      <table class="table">
        <tr>
          <th width=35% class="text-right">ID</th>
          <td width=65%>
            <input type=text id="id" size=15 class="input-sm" value="${id }">
          </td>
        </tr>
        <tr>
          <th width=35% class="text-right">Password</th>
          <td width=65%>
            <input type=password id="pwd" size=15 class="input-sm">
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type=checkbox id="ck"> 아이디저장
          </td>
        </tr>
        <tr>
          <td class="text-center" colspan="2">
            <input type=button value="로그인" class="btn btn-sm btn-danger" id="logBtn">
            <input type=button value="취소" class="btn btn-sm btn-warining" onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>


