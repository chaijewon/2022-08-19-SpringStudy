<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 30px;
}
.row {
   margin: 0px auto;
   width:700px
}

</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <div class="row" id="seoul_detail">
       <table class="table">
         <tr>
           <td class="text-center">
            <img :src="seoul_detail.poster" style="width: 700px;height: 250px">
           </td>
         </tr>
         <tr>
           <td><h3>{{seoul_detail.title}}</h3></td>
         </tr>
         <tr>
           <td><h5>{{seoul_detail.msg}}</h5></td>
         </tr>
         <tr>
           <td><h4>{{seoul_detail.address}}</h4></td>
         </tr>
         <tr>
           <td class="text-right">
             <input type=button class="btn btn-xs btn-primary" value="목록"
              @click="javascript:history.back()"
             >
           </td>
         </tr>
       </table>
     </div>
     <div style="height: 20px"></div>
     <div class="row" id="seoul_reply">
     
     </div>
   </div>
   <script>
    new Vue({
    	el:'#seoul_detail',
    	data:{
    		no:${no},
    		type:${type},
    		seoul_detail:{}
    	},
    	mounted:function(){
    		let _this=this;
    		axios.get("http://localhost:8080/web/seoul/detail_vue.do",{
    			params:{
    				no:_this.no,
        			type:_this.type
    			}
    		}).then(function(result){
    			_this.seoul_detail=result.data
    		})
    	}
    })
   </script>
</body>
</html>










