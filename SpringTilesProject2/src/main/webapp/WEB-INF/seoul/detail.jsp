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
          <td>
           <img src="${vo.poster }" style="width: 800px;height: 350px">
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.title }</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.msg }</h3>
          </td>
        </tr>
        <tr>
          <td>
            <h3>${vo.address }</h3>
          </td>
        </tr>
        <tr>
          <td class="text-right">
            <a href="../seoul/list.do?tab=${tab }" class="btn btn-sm btn-primary">목록</a>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>