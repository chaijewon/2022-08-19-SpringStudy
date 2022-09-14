<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      회원가입 ==> ID,PWD (암호화)
      로그인 처리 ==> ID,PWD를 복호화 
      회원 => 권한 부여 (접근)
   ============================= security 
 --%>
<c:choose>
  <c:when test="${vo.msg=='NOID' }">
    <script>
     alert("아이디가 존재하지 않습니다");
     history.back();
    </script>
  </c:when>
  <c:when test="${vo.msg=='NOPWD' }">
    <script>
     alert("비밀번호가 틀립니다");
     history.back();
    </script>
  </c:when>
  <c:otherwise>
    <script>
     location.href="../main/main.do";
    </script>
  </c:otherwise>
</c:choose>