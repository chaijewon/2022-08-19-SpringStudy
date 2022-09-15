<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.btns').click(function(){
		let type=$(this).attr("data-type");
		// ajax 
	})
})
</script>
</head>
<body>
   <div class="container">
     <div class="row">
       <div class="text-center">
         <input type=button value="날씨/계절" class="btn btn-lg btn-danger btns" data-type="1">
         <input type=button value="상황" class="btn btn-lg btn-warning btns" data-type="2">
         <input type=button value="감성" class="btn btn-lg btn-success btns" data-type="3">
         <input type=button value="스타일" class="btn btn-lg btn-info btns" data-type="4">
       </div>
     </div>
     <div style="height: 10px"></div>
     <div class="row">
      
     </div>
     <div style="height: 20px"></div>
     <div class="row">
     
     </div>
   </div>
</body>
</html>