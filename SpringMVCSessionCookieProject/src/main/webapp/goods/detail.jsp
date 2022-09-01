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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#account').change(function(){
		let count=$(this).val();
		let price=$(this).attr("data-price");
		let total=count*price;
		$('#total').text(total)
		
		$('#goods_account').val(count);
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
        <tr>
          <td width=30% class="text-center" rowspan="6">
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
          <td width=30%>
                      수량:<input type=number id="account" max="10" min="1" data-price="${vo.price }">:<span style="color:blue;" id="total">${vo.price }</span>원
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-right">
            <form method="post" action="session_insert.do">
              <input type=hidden name="no" id="goods_no" value="${vo.no }">
              <input type=hidden name="account" id="goods_account">
              <button class="btn btn-sm btn-primary">장바구니</button>
              <a href="list.do" class="btn btn-sm btn-primary">목록</a>
            </form>
            
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>