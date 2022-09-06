package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;
@RestController
public class MemberRestController {
    @Autowired
    private GoodsDAO dao;
    
    @PostMapping(value = "member/login_ok.do",produces = "text/html;charset=utf-8")
    public String member_login_ok(String id,String pwd,HttpSession session)
    {
    	String result="";
    	MemberVO vo=dao.memberLogin(id, pwd);
    	if(vo.getMsg().equals("NOID"))
    	{
    		result="<script>"
    			  +"alert(\"아이디가 존재하지 않습니다!!\");"
    			  +"history.back();"
    			  +"</script>";
    	}
    	else if(vo.getMsg().equals("NOPWD"))
    	{
    		result="<script>"
      			  +"alert(\"비밀번호가 틀립니다!!\");"
      			  +"history.back();"
      			  +"</script>";
    	}
    	else
    	{
    		session.setAttribute("id", id);
    		session.setAttribute("name", vo.getName());
    		//이동 
    		result="<script>"
    			  +"location.href=\"../main/main.do\";"
    			  +"</script>";
    	}
    	return result;
    }
}
