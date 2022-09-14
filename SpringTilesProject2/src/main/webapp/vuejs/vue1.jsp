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
    <div>{{message}}</div>
  </div>
  <div id="app2">
    <div>{{message2}}</div>
  </div>
  <script>
    new Vue({
    	el:'#app',
    	data:{
    		message:'Hello Vue!!'
    	}
    })
    new Vue({
    	el:'#app2',
    	data:{
    		message2:'Vue JS~~'
    	}
    })
  </script>
</body>
</html>