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
  <div class="container">
     <div class="row row1">
        Search:<input type=text size=20 class="input-sm" :value="ss" ref="ss" v-model="ss">
        <input type=button value="검색" class="btn btn-sm btn-primary" v-on:click="foodFind()">
     </div>
     <div style="height: 50px"></div>
     <div class="row">
         <div class="col-md-4" v-for="vo in food_list">
		    <div class="thumbnail">
		      <a :href="'../food/food_detail_vue.do?fno='+vo.fno">
		        <img :src="vo.poster" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>{{vo.name}}</p>
		        </div>
		      </a>
		    </div>
		  </div>
     </div>
     <div style="height: 20px"></div>
     <div class="row">
       <div class="text-center">
         <input type=button class="btn btn-sm btn-danger" v-on:click="prev()" value=이전>
         {{curpage}} page / {{totalpage}} pages
         <input type=button class="btn btn-sm btn-success" v-on:click="next()" value=다음>
       </div>
     </div>
   </div>
   <script>
     new Vue({
    	 el:'.container',
    	 data:{
    		 curpage:1,
             totalpage:0,
             ss:'강남',
             food_list:[]
    	 },
    	 // vue_find.do?ss=강남&page=1
         // data:{no:1,pwd:''},
         // success:function(result)
    	 mounted:function(){
    		 // window.onload => main
    		 // http://localhost:8080/web/food/vue_find.do?ss=%EA%B0%95%EB%82%A8&page=1
    		 this.send();
    	 },
    	 methods:{
    		 send:function(){
    			 axios.get('http://localhost:8080/web/food/vue_find.do',{
        			 params:{
        				 ss:this.ss,
        				 page:this.curpage
        			 }
        		 }).then(result=>{
        			 // function(result){}
        			 console.log(result)
        			 this.food_list=result.data;
        			 this.curpage=this.food_list[0].curpage;
        			 this.totalpage=this.food_list[0].totalpage;
        		 })
    		 },
    		 foodFind:function(){
    			 if(this.ss==="")
    			 {
    				 alert("검색어를 입력하세요");
    				 this.$refs.ss.focus();
    				 return;
    			 }
    			 this.send();
    		 },
    		 prev:function(){
    			 //alert("1");
    			 this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			 this.send();
    		 },
    		 next:function(){
    			 //alert("2");
    			 this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			 //alert("page="+this.curpage)
    			 this.send();
    		 }
    	 }
     })
   </script>
</body>
</html>
</body>
</html>