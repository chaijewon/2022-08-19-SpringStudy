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
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
    <h1 class="text-center">로그인</h1>
    <div class="row">
	      <table class="table">
	        <tr>
	          <th width=30% class="text-right">ID</th>
	          <td width=70%>
	           <input type=text class="input-sm" size=15 v-model="id">
	          </td>
	        </tr>
	        <tr>
	          <th width=30% class="text-right">PWD</th>
	          <td width=70%>
	           <input type=password  class="input-sm" size=15 v-model="pwd">
	          </td>
	        </tr>
	        <tr>
	          <td colspan="2" class="text-center">
	            <input type="button" value="로그인" class="btn btn-sm btn-danger" v-on:click="login()">
	          </td>
	        </tr>
	      </table>
    </div>
   </div>
   <script>
    new Vue({
    	el:'.container',
    	data:{
    		id:'',
    		pwd:'',
    		result:{}
    	},
    	methods:{
    		login:function(){
    			if(this.id=="")
    			{
    				alert("아이디를 입력하세요!");
    				return;
    			}
    			if(this.pwd=="")
    			{
    				alert("비밀번호 입력");
    				return;
    			}
    			
    			axios.get("http://localhost:8080/web/member/vue_login_ok.do",{
    				params:{
    					id:this.id,
    					pwd:this.pwd
    				}
    			}).then(result=>{
    				// 결과값을 받는다 
    				//console.log(result);
    				console.log(result.data);
    				this.result=result.data;
    				if(this.result.msg=="NOID")
    				{
    					alert("아이디가 존재하지 않습니다!!");
    					this.id="";
    					this.pwd="";
    				}
    				else if(this.result.msg=="NOPWD")
    				{
    					alert("비밀번호가 틀립니다!!")
    					this.pwd="";
    				}
    				else
    				{
    					alert(this.result.name+"님 로그인되었습니다")
    					location.href="../main/main.do";
    				}
    			})
    		}
    	}
    })
   </script>
</body>
</html>












