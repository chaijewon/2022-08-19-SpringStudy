<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String id = request.getParameter("id");
    String passwd = request.getParameter("passwd");
    //check박스는 check가 있으면 true로 반환되지만 check가 없으면 false가 아닌 null이된다.
    String loginChk = request.getParameter("loginChk");
    
    
    //기존 db상의 사용자 아이디, pw라고 가정
    String dbId="Park";
    String dbPasswd="1234";
    
    //문자열 같다 equals()로 비교, 폼의 아이디와  DB의 아이디 비번 비교후 일치시 통과
    //로그인 작업 ->세션생성 "id" id/ 이동 sessionMain.jsp
    //pw비교 틀리면 패스워드 틀림
    if(id.equals(dbId)){
        if(passwd.equals(dbPasswd)){
            //로그인 작업 -> 세션 생성
            session.setAttribute("id", id);
            System.out.println(loginChk);
            //로그인 유지처리
            if(loginChk.equals("true")){
                Cookie cookie = new Cookie("id", id);
                cookie.setMaxAge(60*60*7*24);
                cookie.setPath("/");
                response.addCookie(cookie);
                
            }
            
            %>
            <script>
            alert('로그인 되었습니다.\n메인페이지로 이동합니다.');
            location.href = 'session_Main.jsp';
            </script>
            <%
        }
        else{
            out.println("비밀번호가 틀렸습니다.<br>");
        }
    }
    else{
        //out.println("해당 아이디가 없습니다<br>");
        //br태그나 JS이용하기 위해 스크립트릿을 여닫는다.중간에 끊어지는거는 알아서 하는 모양이다.
        %>
        아이디 없음<br>
        
        <%
    }
%>
</body>
</html>
