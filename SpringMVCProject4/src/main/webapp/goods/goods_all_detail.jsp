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
            <img src="${vo.poster }" style="width: 100%">
          </td>
          <td width=70%>
            <h3>${vo.name }</h3>
          </td>
        </tr>
        <tr>
          <td width=30%>${vo.sub }</td>
        </tr>
        <tr>
          <td width=30%><span style="color:orange">${vo.discount }%&nbsp;</span>${vo.price}</td>
        </tr>
        <tr>
          <td width=30%>첫구매할인가&nbsp;<span style="color:green">${vo.first_price }</span></td>
        </tr>
        <tr>
          <td width=30%>배송:${vo.delivery }</td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
            <a href="goods_all.do" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>















