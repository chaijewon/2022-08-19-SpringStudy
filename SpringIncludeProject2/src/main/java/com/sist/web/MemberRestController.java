package com.sist.web;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sist.dao.*;

import oracle.jdbc.proxy.annotation.Post;
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
    
    @PostMapping(value = "member/ajax_login_ok.do",produces = "text/html;charset=utf-8")
    public String member_ajax_login(String id,String pwd,HttpSession session)
    {
    	String result="";
    	MemberVO vo=dao.memberLogin(id, pwd);
    	result=vo.getMsg();
    	if(vo.getMsg().equals("OK"))
    	{
    		session.setAttribute("id", id);
    		session.setAttribute("name", vo.getName());
    		result=vo.getName();
    	}
    	return result;
    }
    
    @GetMapping(value="member/vue_login_ok.do",produces = "text/plain;charset=utf-8")
    // text/plain(json)  , text/html (일반문자열 , script)
    public String member_vue_login(String id,String pwd,HttpSession session)
    {
    	String result="";
    	MemberVO vo=dao.memberLogin(id, pwd);
    	if(vo.getMsg().equals("OK"))
    	{
    		session.setAttribute("id", id);
    		session.setAttribute("name", vo.getName());
    	}
    	JSONObject obj=new JSONObject(); // {}
    	obj.put("msg", vo.getMsg());
    	obj.put("name",vo.getName());
    	result=obj.toJSONString();
    	return result;
    }
}








