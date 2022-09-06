package com.sist.web;

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
}
