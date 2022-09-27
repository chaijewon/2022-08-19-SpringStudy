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
        <td width="30%" rowspan="4" class="text-center">
         <img src="${vo.goods_poster }" style="width: 100%">
        </td>
        <td width=70%><h3><b>${vo.goods_name }</b></h3>
          <sub>${vo.goods_sub }</sub>
        </td>
      </tr>
    </table>
   </div>
  </div>
</body>
</html>