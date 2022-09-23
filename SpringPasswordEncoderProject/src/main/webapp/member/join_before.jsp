<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1 {
   margin: 0px auto;
   width: 350px;
}
</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
  <div class="container">
    <div class="row row1">
      <table class="table">
        <tr>
         <td>
           비밀번호:<input type=password ref=pwd size=15 class="input-sm" v-model="pwd">
         </td>
        </tr>
        <tr>
          <td class="text-center">
            <input type=button value="확인" class="btn btn-sm btn-warning" v-on:click="ok()">
            <input type=button value="취소" class="btn btn-sm btn-info"
              onclick="javascript:history.back()"
            >
          </td>
        </tr>
      </table>
    </div>
  </div>
  <script>
    new Vue({
    	el:'.container',
    	data:{
    		pwd:''
    	},
    	methods:{
    		ok:function(){
    			if(this.pwd==="")
    			{
    				this.$refs.pwd.focus();//$('#id명').focus()
    				return;
    			}
    			
    			// 비밀번호 입력
    			let _this=this;
    			//axios.post() axios.get()
    			axios.get('http://localhost:8080/web/member/join_before_ok.do',{
    				params:{
    					pwd:this.pwd
    				}
    			}).then(function(result){
    				let res=result.data;
    				if(res==='yes')
    				{
    					location.href="../member/join_update.do";
    				}
    				else
    				{
    					alert("비밀번호가 틀립니다");
    					_this.pwd="";
    					_this.$refs.pwd.focus();
    				}
    			})
    		}
    	}
    })
  </script>
</body>
</html>







