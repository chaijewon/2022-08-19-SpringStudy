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
   <div class="row" style="height: 700px">
    <table class="table">
      <tr>
        <td width="30%" rowspan="4" class="text-center">
         <img src="${vo.goods_poster }" style="width: 100%">
        </td>
        <td width=70%><h3><b>${vo.goods_name }</b></h3>
          <sub>${vo.goods_sub }</sub>
        </td>
      </tr>
      <tr>
        <td width=70%><h3><span style="color:red">${vo.goods_discount }%</span>&nbsp;${vo.goods_price }</h3></td>
      </tr>
      <tr>
        <td width=70%><span style="color:green;font-size: 9px">첫구매할인가</span>&nbsp;${vo.goods_first_price }</td>
      </tr>
      <tr>
        <td width=70%>배송:${vo.goods_delivery }</td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>








