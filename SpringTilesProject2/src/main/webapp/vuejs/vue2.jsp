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
      <table class="table">
        <tr>
          <td>
           <input type=text size=30 class="input-sm" v-model="msg" ref="msg">
           <input type=button class="btn btn-sm btn-danger" value="입력" @click="myclick()">
           <%--
              v-on:이벤트 
              -----
                @
            --%>
          </td>
        </tr>
        <tr>
          <td>{{msg}}</td>
        </tr>
      </table>
    </div>
  </div>
  <script>
    /*
         const myApp={
    	    data(){
    	    	return {
    	    		message:'Hello Vue3'
    	    	}
    	    }	
         }
         Vue.createApp('myApp').mount('.container')
    */
    new Vue({
    	el:'.container',
    	data:{
    		msg:'' /*멤버변수 : 사용시에는 반드시 this.데이터*/
    	},
    	// 생성주기 함수 => 자동으로 호출되는 함수 
    	beforeCreate:function(){
    		console.log("beforeCreate:Vue 객체 생성전...")
    	},
    	created:function(){
    		console.log("created:Vue객체가 생성...")
    	},
    	beforeMount:function(){
    		console.log("beforeMount:가상 메모리에 돔을 만들기 전상태...")
    		// componentWillMount()
    	},
    	// 가장 많이 사용되는 함수 => 스프링에서 데이터 읽기 
    	mounted:function(){
    		console.log("mounted:메모리에 HTML이 저장된 상태 : window.onload... $(function(){})")
    		// componentDidMount()
    	},
    	beforeUpdate:function(){
    		// 상태가 변경된 상태  ==> data값 
    		console.log("beforeUpdate:상태(state)가 변경되기 직전...")
    		// React : state , Vue : data 
    		// Vue2 => Vue3
    	},
    	updated:function(){
    		console.log("updated: 변경된 상태..")
    	},
    	beforeDestory:function(){
    		console.log("beforeDestory:메모리 해제 전...")
    	},
    	destoryed:function(){
    		console.log("destoryed:메모리 해제 된 상태...") // cookie,session
    	},
    	methods:{
    		myclick:function(){
    			// data에 설정된 변수는 멤버변수 = 반드시 시용시에는 this.msg
    			if(this.msg==='') // ES6 ==> 같다 (===) , 같지않다 (!==) 권장 
    			{
    				alert("데이터를 입력하세요!!");
    				this.$refs.msg.focus(); // 참조 변수 ==> 반드시 ref속성을 이용한다 
    				// $refs 
    			}
    		}
    	}
    })
  </script>
</body>
</html>






