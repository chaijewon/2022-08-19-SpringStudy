<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="container">
    <div class="row">
     <table class="table">
       <tr>
         <td width=30% class="text-center" rowspan="4">
           <img src="${vo.goods_poster }" style="width: 100%">
         </td>
         <td width=70%><h3>${vo.goods_name }</h3>
           <sub style="color:gray">${vo.goods_sub }</sub>
         </td>
       </tr>
       <tr>
         <td width=70%><span style="color:orange">${vo.goods_discount }%</span>&nbsp;${vo.goods_price }</td>
       </tr>
       <tr>
         <td width=70% style="color:green">첫구매할인가 &nbsp;${vo.goods_first_price }</td>
       </tr>
       <tr>
         <td width=70%>배송:${vo.goods_delivery }</td>
       </tr>
       <tr>
         <td colspan="2" class="text-right">
          <input type=button value="목록" class="btn btn-sm btn-primary"
            onclick="javascript:history.back()"
          >
         </td>
       </tr>
     </table>
    </div>
  </div>
</body>
</html>