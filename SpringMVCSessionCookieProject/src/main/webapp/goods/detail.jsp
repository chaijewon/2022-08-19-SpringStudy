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
   margin-top: 50px;
}
.row {
   margin: 0px auto;
   width: 800px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td width=30% class="text-center" rowspan="5">
            <img src="${vo.goods_poster }" style="width: 100%">
          </td>
          <td width=70%>
            <h3>${vo.goods_name }</h3>
          </td>
        </tr>
        <tr>
          <td width=30%>${vo.goods_sub }</td>
        </tr>
        <tr>
          <td width=30%><span style="color:orange">${vo.goods_discount }%&nbsp;</span>${vo.goods_price}</td>
        </tr>
        <tr>
          <td width=30%>첫구매할인가&nbsp;<span style="color:green">${vo.goods_first_price }</span></td>
        </tr>
        <tr>
          <td width=30%>배송:${vo.goods_delivery }</td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
            <a href="list.do" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>