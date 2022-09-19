<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
   <div id="seoul_list">
    <div class="row">
      <div class="text-center">
        <input type=button class="btn btn-lg btn-warning" value="서울 명소" @click="seoulChange(1)">
        <input type=button class="btn btn-lg btn-success" value="서울 자연" @click="seoulChange(2)">
        <input type=button class="btn btn-lg btn-info" value="서울 쇼핑" v-on:click="seoulChange(3)">
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row" >
       <div class="col-md-4" v-for="vo in seoul_list">
		    <div class="thumbnail">
		      <a :href="'../seoul/detail_before.do?no='+vo.no+'&type='+type">
		        <img :src="vo.poster" alt="Lights" style="width:350px;height:250px;">
		        <div class="caption">
		          <p>{{vo.title }}</p>
		        </div>
		      </a>
		    </div>
		  </div>
    </div>
    <div class="row">
       <div class="text-center">
         <input type=button class="btn btn-lg btn-warning" value="이전" @click="prev()">
          {{curpage}} page / {{totalpage}} pages
         <input type=button class="btn btn-lg btn-success" value="다음" @click="next()">
       </div>
    </div>
   </div>
    <div style="height: 20px"></div>
    <div class="row" id="seoul_cookie">
    
    </div>
  </div>
  <script>
    const list=new Vue({
    	el:'#seoul_list',
    	data:{
    		curpage:1,
    		totalpage:0,
    		seoul_list:[],
    		type:1
    	},
    	mounted:function(){
    		this.send()
    	},
    	methods:{
    		send:function(){
    			let _this=this;
        		axios.get("http://localhost:8080/web/seoul/list_vue.do",{
        			params:{
        				page:_this.curpage,
        				type:_this.type
        			}
        		}).then(function(result){
        			_this.seoul_list=result.data;
        			_this.curpage=result.data[0].curpage;
        			_this.totalpage=result.data[0].totalpage;
        			_this.type=result.data[0].type;
        		})
    		},
    		seoulChange:function(no){
    			this.type=no;
    			this.curpage=1;
    			this.send();
    		},
    		prev:function(){
    			this.curpage=this.curpage>1?this.curpage-1:this.curpage;
    			this.send();
    		},
    		next:function(){
    			this.curpage=this.curpage<this.totalpage?this.curpage+1:this.curpage;
    			this.send();
    		}
    	}
    })
    const cook=new Vue({
    	el:'#seoul_cookie',
    	data:{
    		seoul_cook:[]
    	}
    })
  </script>
</body>
</html>











