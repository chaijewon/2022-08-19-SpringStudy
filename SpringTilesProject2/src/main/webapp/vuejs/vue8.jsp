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
  <center>
    <div id="app">
      <m-com></m-com>
      <m-com></m-com>
      <m-com></m-com>
      <m-com></m-com>
      <m-com></m-com>
      <template>
        <h1>Hello</h1>
      </template>
    </div>
  </center>
  <script>
    Vue.component('m-com',{
    	template:'<h1>Hello Component</h1>'
    })
    new Vue({
    	el:'#app'
    })
  </script>
</body>
</html>