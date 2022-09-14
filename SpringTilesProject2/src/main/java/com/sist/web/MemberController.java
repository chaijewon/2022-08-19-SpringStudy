package com.sist.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.vo.MemberVO;
import com.sist.dao.*;

@Controller
public class MemberController {
   @Autowired
   private MemberDAO dao;
   
   @GetMapping("member/login.do")
   public String member_login()
   {
	   return "member/login";
   }
   
   @PostMapping("member/login_ok.do")
   public String member_login_ok(String id,String pwd,HttpSession session,Model model)
   {
	   // DB연동 
	   MemberVO vo=dao.isLogin(id, pwd);
	   if(vo.getMsg().equals("OK"))
	   {
		   session.setAttribute("id", id);
		   session.setAttribute("name", vo.getName());
	   }
	   model.addAttribute("vo", vo);
	   return "member/login_ok";
   }
   @GetMapping("member/logout.do")
   public String member_logout(HttpSession session)
   {
	   session.invalidate();
	   return "redirect:../main/main.do";
   }
}
