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
.images:hover{
  cursor: pointer;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row row1">
      <div class="col-sm-8">
       <template id="food_template">
        <div class="col-md-4" v-for="vo in food_data">
            <%--
                v-on:click  = @click
                v-bind:src  = :src : Vue의 변수와 연결 
                v-model = 양방향 통신 
                
                vue / react 
                === 양방향,단방향 
                
             --%>
		    <div class="thumbnail">
		        <img :src="vo.poster" alt="Lights" style="width:100%" class="images" v-on:click="detailData(vo.fno)">
		        <div class="caption">
		          <p>{{vo.name }}</p>
		        </div>
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
      
      <div class="col-sm-4" v-show="isShow" v-if="isShow===true">
        <table class="table">
          <tr>
            <td class="text-center" v-for="img in food_detail.poster.split('^')">
             <img :src="img" style="width:100%">
            </td>
          </tr>
        </table>
        <div style="height: 10px"></div>
        <table class="table">
          <tr>
           <td colspan="2"><h3>{{food_detail.name}}<span style="color:orange">{{food_detail.score}}</span></h3></td>
          </tr>
        </table>
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
         fno:0,
         isShow:false
	 },
	 mounted:function(){
		 console.log("Vue:this="+this)//Vue(object)
		 let _this=this;
		 axios.get("http://localhost:8080/web/food/food_all_vue.do",{
			 params:{
				 page:_this.curpage
			 }
		 }).then(function(result){
			 console.log("function=>this="+_this)//Window
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
		 },
		 detailData:function(no){
			 
			 let _this=this;
			 _this.isShow=true
			 // vue.do?fno=1&gno=10
		     /*
		           public String detail(int gno,int fno)
		     */
			 axios.get("http://localhost:8080/web/food/detail_vue.do",{
				 params:{
					 fno:no
				 }
			 }).then(function(result){
				 console.log(result)
				 _this.food_detail=result.data;
			 })
		 }
	 }
   })
  </script>
</body>
</html>








