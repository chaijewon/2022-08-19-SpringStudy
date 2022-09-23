<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
     <table border=1 bordercolor=black width=900 height="700">
      <tr>
        <td width=100% height=100 colspan="2"><tiles:insertAttribute name="header"/></td>
      </tr>
      <tr>
         <td width=30% height="500"><tiles:insertAttribute name="side"/></td>
         <td width=70% height=500><tiles:insertAttribute name="content"/></td>
      </tr>
      <tr>
         <td width=100% height=100 colspan="2"><tiles:insertAttribute name="footer"/></td>
      </tr>
     </table>
   </center>
</body>
</html>