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
    <div class="row">
      <table class="table">
        <tr>
          <td v-for="image in vo.poster.split('^')">
           <img :src="image" style="width:100%">
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <td colspan="2"><h3>{{vo.name}}</h3>&nbsp;<span style="color:orange"></span></td>
        </tr>
        <tr>
          <td width=20% style="color:gray">주소</td>
          <td width=80%>{{vo.address}}</td>
        </tr>
        <tr>
          <td width=20% style="color:gray">전화</td>
          <td width=80%>{{vo.tel}}</td>
        </tr>
        <tr>
          <td width=20% style="color:gray">음식종류</td>
          <td width=80%>{{vo.type}}</td>
        </tr>
        <tr>
          <td width=20% style="color:gray">가격대</td>
          <td width=80%>{{vo.price}}</td>
        </tr>
        <tr>
          <td width=20% style="color:gray">영업시간</td>
          <td width=80%>{{vo.time}}</td>
        </tr>
        <tr>
          <td width=20% style="color:gray">주차</td>
          <td width=80%>{{vo.parking}}</td>
        </tr>
        <tr v-show="vo.menu!='no'">
          <td width=20% style="color:gray">메뉴</td>
          <td width=80%>
            <ul>
              <li v-for="m in vo.menu.split('원')">{{m}}</li>
            </ul>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <script>
  /* const myDetail={
		 data(){
			 return {
				 fno:${fno},
			  		vo:{}
			 }
		 },
		 mounted(){
		  
			   axios.get("http://localhost:8080/web/food/detail_vue.do",{
			  			params:{
			  				fno:this.fno
			  			}
			  }).then(result=>{
			  			console.log(result.data);
			  			this.vo=result.data;
			  })
		  
		 }
  }
  Vue.createApp(myDetail).mount('.container'); */
  new Vue({
	  	el:'.container',
	  	data:{
	  		fno:${fno},
	  		vo:{}
	  	},
	  	mounted:function(){
	  		axios.get("http://localhost:8080/web/food/detail_vue.do",{
	  			params:{
	  				fno:this.fno
	  			}
	  		}).then(result=>{
	  			console.log(result.data);
	  			this.vo=result.data;
	  		})
	  	}
	  })
	  
  </script>
</body>
</html>






