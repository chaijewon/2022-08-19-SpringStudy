<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1 {
   margin: 0px auto;
   width: 450px;
}
h1 {
   text-align: center
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <h1>삭제하기</h1>
     <div class="row row1">
      <table class="table">
       <tr>
         <th width=20% class="text-right">비밀번호</th>
         <td width=80%>
           <%--
              $('#pwd') == ref="pwd"
              Jquery , Ajax , Vue ===== DOMScript (DOM:태그) 태그를 제어하는 프로그램
            --%>
           <input type=password v-model="pwd" ref="pwd" size=15 class="input-sm">
         </td>
       </tr>
       <tr>
        <td colspan="2" class="text-center">
          <input type=submit value="삭제" class="btn btn-sm btn-warning" v-on:click="boardDelete()">
          <input type=button value="취소" class="btn btn-sm btn-info"
            onclick="javascript:history.back()">
        </td>
       </tr>
      </table>
     </div>
   </div>
   <script>
     new Vue({
    	 el:'.container',
    	 data:{
    		 no:${no},
    		 pwd:'',
    		 res:''
    	 },
    	 methods:{
    		 boardDelete:function(){
    			 let _this=this;
    			 axios.get("http://52.78.101.41/board/delete_vue.do",{
    				 params:{
    					 no:_this.no,
    					 pwd:_this.pwd
    				 }
    			 }).then(function(result){
    				 _this.res=result.data
    				 
    				 if(_this.res=='yes')
    				 {
    					 location.href="../board/list.do"
    				 }
    				 else
    				 {
    					 alert("비밀번로가 틀립니다!!")
    					 _this.pwd="";
    					 _this.$refs.pwd.focus()
    				 }
    			 })
    		 }
    	 }
     })
   </script>
</body>
</html>




