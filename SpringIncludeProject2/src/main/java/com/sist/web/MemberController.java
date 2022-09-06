package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.*;
@Controller
public class MemberController {
    @Autowired
    private GoodsDAO dao;
    
    @GetMapping("member/login.do")
    public String member_login()
    {
    	return "member/login";
    }
    @GetMapping("member/ajax_login.do")
    public String member_ajax_login()
    {
    	return "member/ajax_login";
    }
    @GetMapping("member/vue_login.do")
    public String member_vue_login()
    {
    	return "member/vue_login";
    }
    
    @GetMapping("member/logout.do")
    public String member_logout(HttpSession session)
    {
    	session.invalidate();
    	return "redirect:../main/main.do";
    }
}
