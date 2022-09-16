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
   width: 700px;
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
    <h1>수정하기</h1>
    <div class="row row1">
      <table class="table">
       <tr>
         <th width=20% class="text-right">이름</th>
         <td width=80%>
           <input type=text v-model="name" ref="name" size=20 class="input-sm" :value="vo.name">
           <%--
               v-bind:value=""
            --%>
           <input type=hidden name=no value="${vo.no }">
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">제목</th>
         <td width=80%>
           <input type=text v-model="subject" ref="subject" size=50 class="input-sm" :value="vo.subject">
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">내용</th>
         <td width=80%>
           <textarea rows="10" cols="50" v-model="content" ref="content">{{vo.content }}</textarea>
         </td>
       </tr>
       <tr>
         <th width=20% class="text-right">비밀번호</th>
         <td width=80%>
           <input type=password v-model="pwd" ref="pwd" size=15 class="input-sm">
         </td>
       </tr>
       <tr>
        <td colspan="2" class="text-center">
          <input type=button value="수정" class="btn btn-sm btn-warning" v-on:click="boardUpdate()">
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
		   name:'',
		   subject:'',
		   content:'',
		   pwd:'',
		   vo:{},
		   no:0,
		   res:''
	   },
	   mounted:function(){
		   
	   },
	   methods:{
		   boardUpdate:function(){
			   
		   }
	   }
   })
  </script>
</body>
</html>
