<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row1{
  margin: 0px auto;
  width:100%
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row row1">
      <div class="col-sm-8">
       <template id="food_template">
        <div class="col-md-4" v-for="vo in food_data">
		    <div class="thumbnail">
		      <a href="#">
		        <img :src="vo.poster" alt="Lights" style="width:100%">
		        <div class="caption">
		          <p>{{vo.name }}</p>
		        </div>
		      </a>
		    </div>
		  </div>
       </template>
       <div style="height: 20px"></div>
       <div class="text-center">
         <button class="btn btn-sm btn-info" v-on:click="prev()">이전</button>
          {{curpage}} page / {{totalpage}} pages
         <button class="btn btn-sm btn-info" v-on:click="next()">다음</button>
       </div>
      </div>
      
      <div class="col-sm-4">
        
      </div>
    </div>
  </div>
  <script>
   new Vue({
	 el:'.row',
	 data:{
		 curpage:1,
		 totalpage:0,
		 food_data:[],
		 food_detail:{},
         fno:0
	 },
	 mounted:function(){
		 let _this=this;
		 axios.get("http://localhost:8080/web/food/food_all_vue.do",{
			 params:{
				 page:_this.curpage
			 }
		 }).then(function(result){
			 console.log(result);
			 _this.food_data=result.data;
			 _this.curpage=result.data[0].curpage;
			 _this.totalpage=result.data[0].totalpage;
		 })
	 },
	 methods:{
		 prev:function(){
			 this.curpage=this.curpage>1?this.curpage-1:this.curpage;
			 let _this=this;
			 axios.get("http://localhost:8080/web/food/food_all_vue.do",{
				 params:{
					 page:_this.curpage
				 }
			 }).then(function(result){
				 console.log(result);
				 _this.food_data=result.data;
				 _this.curpage=result.data[0].curpage;
				 _this.totalpage=result.data[0].totalpage;
			 })
		 },
		 next:function(){
			 this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
			 let _this=this;
			 axios.get("http://localhost:8080/web/food/food_all_vue.do",{
				 params:{
					 page:_this.curpage
				 }
			 }).then(function(result){
				 console.log(result);
				 _this.food_data=result.data;
				 _this.curpage=result.data[0].curpage;
				 _this.totalpage=result.data[0].totalpage;
			 })
		 }
	 }
   })
  </script>
</body>
</html>








