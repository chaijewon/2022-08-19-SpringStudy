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
  <button-counter><button-counter/>
</div>
<script>
    Vue.component('button-counter', {
	  data: function () {
	    return {
	      count: 0
	    }
	  },
	  template: '<button @click="count++">You clicked me {{ count }} times.</button>'
	});

	new Vue({
	  el: '#app'
	});	
</script>
</body>
</html>