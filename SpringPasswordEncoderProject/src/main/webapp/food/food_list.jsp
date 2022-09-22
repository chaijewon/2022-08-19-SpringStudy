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
   margin: 0px auto;
   width:850px;
}
.types:hover{
   cursor: pointer;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
  $( function() {
	$('.types').click(function(){
		let type=$(this).text();
		$.ajax({
			type:'post',
			url:'../food/recipe_list.do',
			data:{"type":type},
			success:function(result)
			{
				let json=JSON.parse(result);
				console.log(json);
				let html=json.map((poster)=>(
					'<div class="col-md-3">'
					    +'<div class="thumbnail">'
					        +'<img src="'+poster+'" style="width:100%">'
					    +'</div>'
					  +'</div>'
				));
				$('#print').html(html);
				
				$('#dialog').dialog({
					autoOpen:false,
					width:800,
					height:600,
					modal:true
				}).dialog("open")
			}
		})
	})
  });
</script>
</head>
<%--
   ROLE_ADMIN , ROLE_USER , ROLE_MANAGER , ROLE_GUEST => 접근 제어
      비밀번호 암호화 , 아이디 저장 (Cookie) 
 --%>
<body>
   <div class="container">
     <div class="jumbotron">
       <h3 class="text-center">${cvo.title }</h3>
       <h4 class="text-center">${cvo.subject }</h4>
     </div>
     <div class="row row1">
       <table class="table">
        <tr>
         <td>
           <c:forEach var="vo" items="${list }">
             <table class="table">
               <tr>
                 <td width=30% rowspan="4" class="text-center">
                   <a href="../food/detail.do?fno=${vo.fno }">
                   <img src="${vo.poster }" style="width: 250px;height: 180px"></a>
                 </td>
                 <td width=70%><h3><a href="../food/detail.do?fno=${vo.fno }">${vo.name }</a>&nbsp;<span style="color:orange">${vo.score }</span></h3></td>
               </tr>
               <tr>
                 <td width=70%>${vo.address }</td>
               </tr>
               <tr>
                 <td width=70%>${vo.tel }</td>
               </tr>
               <tr>
                 <td width=70%><span class="types">${vo.type }</span></td>
               </tr>
             </table> 
           </c:forEach>
         </td>
        </tr>
       </table>
     </div>
      <div id="dialog" title="레시피" style="display:none">
        <div id="print" class="row"></div>
      </div>
   </div>
</body>
</html>



