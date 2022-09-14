<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div id="app">
    <ul>
     <li v-for="name in names" v-if="name!=='홍길동'">{{name}}</li>
    </ul>
  </div>
  <script>
  new Vue({
	  el:'#app',
	  data:{
		  names:['홍길동','심청이','박문수','이순신','강감찬']
	  }
  })
  </script>
</body>
</html>





