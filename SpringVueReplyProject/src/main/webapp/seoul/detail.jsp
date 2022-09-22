<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width:700px
}

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.min.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
   <div class="container">
     <div class="row" id="seoul_detail">
       <table class="table">
         <tr>
           <td class="text-center">
            <img :src="seoul_detail.poster" style="width: 700px;height: 250px">
           </td>
         </tr>
         <tr>
           <td><h3>{{seoul_detail.title}}</h3></td>
         </tr>
         <tr>
           <td><h5>{{seoul_detail.msg}}</h5></td>
         </tr>
         <tr>
           <td><h4>{{seoul_detail.address}}</h4></td>
         </tr>
         <tr>
           <td class="text-right">
             <a href="../seoul/list.do" class="btn btn-xs btn-primary">목록</a>
           </td>
         </tr>
       </table>
     </div>
     <div style="height: 20px"></div>
     <div class="row" id="seoul_reply">
        <table class="table">
          <tr>
           <td>
             <%-- [{JSONObject:~VO},{},{},{}] --%>
             <table class="table" v-for="re in reply_list">
               <tr>
                 <td class="text-left">◑&nbsp;{{re.name}}&nbsp;({{re.dbday}})</td>
                 <td class="text-right">
                   <%--
                         <c:if test="${sessionScope.id==re.id}">
                    --%>
                   <input type=button class="btn btn-xs btn-info ups" v-if="re.id===sessionId" value="수정" @click="replyUpdate_temp(re.no)" :id="'up'+re.no">
                   <input type=button class="btn btn-xs btn-warning" v-if="re.id===sessionId" value="삭제" v-on:click="replyDelete(re.no)">
                 </td>
               </tr>
               <tr>
                 <td colspan="2" valign="top" class="text-left"><pre style="white-space: pre-wrap;border: none;background-color: white">{{re.msg}}</pre></td>
               </tr>
               <tr :id="'u'+re.no" class="updates" style="display:none">
                 <td colspan="2">
	                   <table class="table">
				          <tr>
				            <td>
				              <input type=hidden name="cno" :value="cno">
				              <input type=hidden name="type" :value="type">
				              <input type=hidden name="no" :value="re.no">
				              <textarea rows="5" cols="70" ref="msg" style="float:left" id="msg">{{re.msg}}</textarea>
				              <input type=submit value="댓글수정" class="btn btn-sm btn-primary"
				                style="height: 105px">
				            </td>
				          </tr>
				        </table>
                 </td>
               </tr>
             </table>
           </td>
          </tr>
        </table>
        <c:if test="${sessionScope.id!=null }">
	        <table class="table"> <%-- null,''이 아닌 경우에 실행 --%>
	          <tr>
	            <td>
	              <textarea rows="5" cols="78" ref="msg" style="float:left" v-model="msg"></textarea>
	              <input type=button value="댓글쓰기" class="btn btn-sm btn-primary"
	                style="height: 105px" @click="replyWrite()">
	            </td>
	          </tr>
	        </table>
        </c:if>
     </div>
   </div>
   <script>
    new Vue({
    	el:'#seoul_detail',
    	data:{
    		no:${no},
    		type:${type},
    		seoul_detail:{}
    	},
    	mounted:function(){
    		let _this=this;
    		axios.get("http://localhost:8080/web/seoul/detail_vue.do",{
    			params:{
    				no:_this.no,
        			type:_this.type
    			}
    		}).then(function(result){
    			_this.seoul_detail=result.data
    		})
    	}
    })
    
    new Vue({
    	el:'#seoul_reply',
    	data:{
    		cno:${no},
    		type:${type},
    		reply_list:[],
    		sessionId:'',
    		msg:'',
    		isShow:false,
    		no:0
    	},
    	mounted:function(){
    		
    		let _this=this;
    		axios.get("http://localhost:8080/web/seoul/reply_list.do",{
    			params:{
    				cno:_this.cno,
    				type:_this.type
    			}
    		}).then(function(result){
    			console.log(result.data)
    			_this.reply_list=result.data;
    			_this.sessionId=result.data[0].sessionId
    		})
    		
    		
    	},
    	methods:{
    		replyWrite:function(){
    			if(this.msg==="")
    			{
    				this.$refs.msg.focus();
    				return;
    			}
    			let _this=this;
    			axios.get("http://localhost:8080/web/seoul/reply_insert.do",{
        			params:{
        				cno:_this.cno,
        				type:_this.type,
        				msg:_this.msg
        			}
        		}).then(function(result){
        			_this.msg="";
        			console.log(result.data)
        			_this.reply_list=result.data;
        			_this.sessionId=result.data[0].sessionId
        		})
    		},
    		replyDelete:function(no){
    			let _this=this;
    			axios.get("http://localhost:8080/web/seoul/reply_delete.do",{
        			params:{
        				cno:_this.cno,
        				type:_this.type,
        				no:no
        			}
        		}).then(function(result){
        			console.log(result.data)
        			_this.reply_list=result.data;
        			_this.sessionId=result.data[0].sessionId
        		})
    		},
    		replyUpdate_temp:function(no){
    			$('.updates').hide();
    			if(this.no==0)
    			{
    				$('#u'+no).show();
    				$('#up'+no).val("취소");
    				this.no=1;
    			}
    			else
    			{
    				$('#u'+no).hide();
    				$('#up'+no).val("수정");
    				this.no=0;
    			}
    			
    			
    		}/* ,
    		replyUpdate:function(no){
    			
    			alert("msg="+this.msg)
    			if(this.msg==="")
    			{
    				this.$refs.msg.focus();
    				return;
    			}
    			let _this=this;
    			axios.get("http://localhost:8080/web/seoul/reply_update.do",{
        			params:{
        				cno:_this.cno,
        				type:_this.type,
        				msg:_this.msg
        			}
        		}).then(function(result){
        			_this.msg="";
        			console.log(result.data)
        			_this.reply_list=result.data;
        			_this.sessionId=result.data[0].sessionId
        		})
    		} */
    	}
    })
   </script>
</body>
</html>










