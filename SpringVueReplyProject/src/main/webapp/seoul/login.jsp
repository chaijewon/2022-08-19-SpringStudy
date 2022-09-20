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
   width:420px;
}

</style>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
    <div class="container">
      <h1 class="text-center">Login</h1>
      <%--
           *1. 비밀번호 암호화 / 복호화 
           *2. 권한 부여 
           *3. 자동 로그인 
           *4. 메소드 보안 
           5. Task 
           6. Validation 
       --%>
       <div class="row">
         <table class="table">
          <tr>
           <th width=30% class="text-right">ID</th>
           <td width=70%>
             <input type=text size=15 ref="id" class="input-sm" v-model="id">
           </td>
          </tr>
          <tr>
           <th width=30% class="text-right">PWD</th>
           <td width=70%>
             <input type=password size=15 ref="pwd" class="input-sm" v-model="pwd">
           </td>
          </tr>
          <tr>
            <td class="text-center" colspan="2">
              <input type=button value="로그인" class="btn btn-sm btn-danger" @click="login()">
              <input type=button value="회원가입" class="btn btn-sm btn-primary" @click="join()">
            </td>
          </tr>
         </table>
       </div>
    </div>
    <%--
        Vue , React = 자바스크립트 (문법,데이터,함수)
        ============ 라이브러리 
                     자바스크립트
                          데이터형
                = let , const , var (자동 지정 변수)
                  let a=''  => a:String
                  let a=""  => a:String 
                  let a=10  => a:Number ==> int
                  let a=10.5 => a:Number ==> double  
                  let a={}   => a:Object ==> ~VO
                  let a=[]   => a:Object ==> Array  ==> List
                  let a=true => a:Boolean 
                        연산자    =  비교연산자 (=== 같다 , !== 같지않다) ==> vscode / 웹스톰 / 아톰 (==,!= 경고)
                        제어문    =  map , forEach ==> for문 
                        함수
               function func_name(매개변수...){}  => 매개변수는 이름만 (let a) ==> (a)
               let func_name=function(매개변수){} 
               let function=>(){}
                          ---- 리턴형 / function을 제거  
           vue / react => 자바스크립트 
           Vue 의 장점 , MVVM , 가상돔 
           Vue/React 비교  
     --%>
    <script>
      new Vue({
    	  el:'.container',  //el (element = 태그) 
    	  data:{
    		  id:'',
    		  pwd:'',
    		  res:''
    	  },
    	  // 사용자 정의 함수 => 자바스크립트 문법 적용 
    	  methods:{
    		  // login(){}
    		  login:function(){
    			  if(this.id.trim()==="")
    			  {
    				  this.$refs.id.focus();
    				  return;
    			  }
    			  if(this.pwd.trim()==="")
    			  {
    				  this.$refs.pwd.focus();
    				  return;
    			  }
    			  // 데이터 전송 (스프링 서버) => 전송 / 응답 
    			  let _this=this;
    			  axios.get("http://localhost:8080/web/member/login_vue.do",{
    				  params:{
    					  id:_this.id,
    					  pwd:_this.pwd
    				  }
    			  }).then(function(result){ // callback (시스템에 의해 자동 호출 success:function(result))
    				  if(result==='NOID')
    				  {
    					  alert("ID가 존재하지 않습니다!!");
    					  this.id="";
    					  this.pwd="";
    					  this.$refs.id.focus();
    				  }
    				  else if(result==='NOPWD')
    				  {
    					  alert("비밀번호가 틀립니다!!");
    					  this.pwd="";
    					  this.$refs.pwd.focus();
    				  }
    				  else
    				  {
    					  location.href="../seoul/list.do";
    				  }
    			  })
    		  }
    	  }
      })
    </script>
</body>
</html>








