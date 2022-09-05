<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let fileIndex=0; // 전역변수
$(function(){
	$('#writeBtn').on('click',function(){
		let name=$('#name').val();
		if(name.trim()=="")
		{
			$('#name').focus();
			return;
		}
		
		let subject=$('#subject').val();
		if(subject.trim()=="")
		{
			$('#subject').focus();
			return;
		}
		
		let content=$('#content').val();
		if(content.trim()=="")
		{
			$('#content').focus();
			return;
		}
		
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		
		$('#frm').submit();
	})
	
	
	// 추가 
	$('#addBtn').click(function(){
		$('#user-table > tbody').append(
		   '<tr id="m'+(fileIndex)+'">'
		  +'<td width=20%>파일 '+(fileIndex+1)+'</td>'
		  +'<td width=80%><input type=file name=files["'+(fileIndex)+'"]></td>'
		  +'</tr>'
		)
		fileIndex=fileIndex+1;
	})
	// 취소
	$('#removeBtn').click(function(){
		if(fileIndex>0)
		{
		    $('#m'+(fileIndex-1)).remove();
		    fileIndex=fileIndex-1;
		}
	})
})
</script>
</head>
<body>
  <div class="container">
    <h1>글쓰기</h1>
    <div class="row">
      <%--  enctype="multipart/form-data" 파일업로드 프로토콜 (생략이 되면 파일업로드를 할 수 없다 )--%>
      <form method=post action="insert_ok.do" id="frm" enctype="multipart/form-data">
      <table class="table">
       <tr>
         <th width=20% class="text-right">이름</th>
         <td width=80%>
           <input type=text name=name id=name size=20 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">제목</th>
         <td width=80%>
           <input type=text name=subject id=subject size=50 class="input-sm">
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">내용</th>
         <td width=80%>
           <textarea rows="10" cols="50" name=content id=content></textarea>
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">첨부파일</th>
         <td width=80%>
           <table class="table">
             <tr>
               <td class="text-right">
                 <input type=button value="추가" class="btn btn-xs btn-danger" id="addBtn">
                 <input type=button value="취소" class="btn btn-xs btn-primary" id="removeBtn">
               </td>
             </tr>
           </table>
           <table class="table" id="user-table">
             <tbody>
               
             </tbody>
           </table>
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">비밀번호</th>
         <td width=80%>
           <input type=password name=pwd id=pwd size=15 class="input-sm">
         </td>
       </tr>
       <tr>
        <td colspan="2" class="text-center">
          <input type=button value="글쓰기" class="btn btn-sm btn-warning" id="writeBtn">
          <input type=button value="취소" class="btn btn-sm btn-info"
            onclick="javascript:history.back()">
        </td>
       </tr>
      </table>
      </form>
    </div>
  </div>
</body>
</html>