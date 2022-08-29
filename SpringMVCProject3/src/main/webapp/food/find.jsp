<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="http://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 100%
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <input type=text size=20 class="input-sm" v-model="loc">
       <input type=button value="검색" class="btn btn-sm btn-primary" v-on:click="find()">
     </div>
     <div style="height: 20px"></div>
     <div class="row">
       <div class="col-md-4" v-for="vo in list">
		      <div class="thumbnail">
		        <a href="#">
		          <img :src="vo.poster" alt="Lights" style="width:100%">
		          <div class="caption">
		            <p>{{vo.name }}</p>
		          </div>
		        </a>
		      </div>
	   </div>
     </div>
     <script>
      new Vue({
    	  el:'.container',
    	  data:{
    		  loc:'강남',
    		  list:[],
    		  curpage:1,
    		  totalpage:0
    	  },
    	  mounted:function(){ //$(function())
    		  axios.get('http://localhost:8080/web/food/food_find_vue.do',{
    			  params:{
    				  page:this.curpage,
    				  loc:this.loc
    			  }
    		  }).then(res=>{
    			  this.list=res.data
    		  })
    	  },
    	  methods:{
    		  find:function(){
    			  axios.get('http://localhost:8080/web/food/food_find_vue.do',{
        			  params:{
        				  page:this.curpage,
        				  loc:this.loc
        			  }
        		  }).then(res=>{
        			  this.list=res.data
        		  })
    		  }
    	  }
      })
     </script>
   </div>
</body>
</html>










