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
		$.ajax({
			type:'get',
			url:'../recommand/recommand_sub.do',
			data:{"type":type},
			success:function(result)
			{
				//alert(result);
				let res=JSON.parse(result);
				let data="";
				for(let i=0;i<res.length;i++)
				{
				   data+='<span class="btn btn-sm btn-info" onclick="recommandData(\''+res[i]+'\')">'+res[i]+'</span>&nbsp;&nbsp;';	
				}
				
				$('#sub').html(data);
			}
			
		})
	})
})
function recommandData(res)
{
	
	$.ajax({
	    type:'post',
	    url:'../recommand/recommand_data.do',
	    data:{"fd":res},
	    success:function(result)
	    {
	    	let res=JSON.parse(result);
	    	let data="";
	    	
	    }
	})
}
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
       <div class="text-center" id="sub">
       
       </div>
     </div>
     <div style="height: 20px"></div>
     <div class="row">
       <div class="text-center" id="recom">
        
       </div>
     </div>
   </div>
</body>
</html>