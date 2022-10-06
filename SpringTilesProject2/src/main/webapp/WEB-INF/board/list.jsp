<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
  width: 960px;
  height: 650px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <h1 class="text-center">VueJS를 이용한 목록 출력</h1>
    <div class="row row1">
      <table class="table">
       <tr>
         <td>
          <a href="../board/insert.do" class="btn btn-sm btn-primary">새글</a>
         </td>
       </tr>
      </table>
      <table class="table">
        <tr>
          <th width=10% class="text-center">번호</th>
          <th width=45% class="text-center">제목</th>
          <th width=15% class="text-center">이름</th>
          <th width=20% class="text-center">작성일</th>
          <th width=10% class="text-center">조회수</th>
        </tr>
        <tr v-for="vo in board_list">
          <th width=10% class="text-center">{{vo.no}}</th>
          <%--
                ../board/detail/1 => react
           --%>
          <th width=45%><a :href="'../board/detail.do?no='+vo.no">{{vo.subject}}</a></th>
          <th width=15% class="text-center">{{vo.name}}</th>
          <th width=20% class="text-center">{{vo.dbday}}</th>
          <th width=10% class="text-center">{{vo.hit}}</th>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td class="text-center">
           <input type=button value="이전" class="btn btn-sm btn-danger">
           {{curpage}} page / {{totalpage}} pages
           <input type=button value="다음" class="btn btn-sm btn-warning">
          </td>
        </tr>
      </table>
    </div>
  </div>
  <%--
         public class B
         {
         }
         public class A
         {
             B b=new B(){
                this ==> B
             }
             public A()
             {
                this = A
             }
         }
   --%>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		board_list:[],
    		curpage:1,
    		totalpage:0
    	},
    	mounted:function(){
    		let _this=this;
    		axios.get("http://52.78.101.41/board/list_vue.do",{
    			params:{
    				page:_this.curpage
    			}
    		}).then(function(result){
    			console.log(result.data);
    			_this.board_list=result.data;
    			_this.curpage=result.data[0].curpage;
    			_this.totalpage=result.data[0].totalpage;
    		})
    	}
    })
  </script>
</body>
</html>