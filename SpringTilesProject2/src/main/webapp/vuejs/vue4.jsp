<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 30px;
}
.row {
   margin: 0px auto;
   width:100%
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <!-- {{$data}} -->
     <img :src="image" style="width: 100%" :title="title+'('+singer+')'">
     <%--  속성값을 변수를 이용해서 출력할때  :속성    v-bind:  => :
           Vue => data를 연결해서 사용 
      --%>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		image:'https://image.genie.co.kr/Y/IMAGE/IMG_ALBUM/082/912/984/82912984_1661135567760_1_140x140.JPG/dims/resize/Q_80,0',
    		title:'After LIKE',
    		singer:'IVE (아이브)'
    	   
    	}
    })
  </script>
</body>
</html>






