<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.row1 {
   margin:0px auto;
   width: 800px;
   height: 650px;
}
h1 {
   text-align: center
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <h1>상세보기</h1>
     <div class="row row1">
      <table class="table">
        <tr>
         <th width=20% class="text-center warning">번호</th>
         <td width=30% class="text-center">{{vo.no}}</td>
         <th width=20% class="text-center warning">작성일</th>
         <td width=30% class="text-center">{{vo.dbday }}</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">이름</th>
         <td width=30% class="text-center">{{vo.name }}</td>
         <th width=20% class="text-center warning">조회수</th>
         <td width=30% class="text-center">{{vo.hit }}</td>
        </tr>
        <tr>
         <th width=20% class="text-center warning">제목</th>
         <td colspan="3">{{vo.subject }}</td>
        </tr>
        <tr>
          <td colspan="4" class="text-left" valign="top" height="200">
           <pre style="white-space: pre-wrap;border:none;background-color: white;">{{vo.content }}</pre>
          </td>
        </tr>
        <tr>
          <td colspan="4" class="text-right">
            <a href="#" class="btn btn-xs btn-info">수정</a>
            <a href="#" class="btn btn-xs btn-warning">삭제</a>
            <a href="../board/list.do" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
      </table>
     </div>
   </div>
   <script>
    new Vue({
    	el:'.container',
    	data:{
    		vo:{},
    		no:${no}
    	},
    	mounted:function(){
    		let _this=this;
    		// 요청 
    		axios.get("http://localhost:8080/web/board/detail_vue.do",{
    			params:{
    				no:_this.no
    			}
    		// 요청 처리 결과값 읽기 => 데이터값 변경 (상태변경) 상태 관리 프로그램 
    		}).then(function(result){
    			_this.vo=result.data;
    		})
    	}
    })
   </script>
</body>
</html>







