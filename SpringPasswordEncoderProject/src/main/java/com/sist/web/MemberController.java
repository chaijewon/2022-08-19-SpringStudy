package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.dao.*;
import com.sist.vo.*;
// 커스터마이징 , 리팩토링  
@Controller
public class MemberController {
   @Autowired
   private MemberDAO dao;
   
   @Autowired
   private BCryptPasswordEncoder encoder;
   
   @GetMapping("member/join.do")
   public String member_join(Model model)
   {
	   model.addAttribute("main_jsp", "../member/join.jsp");
	   return "main/main";//forward => request를 전송 
   }
   
   @PostMapping("member/join_ok.do")
   public String member_join_ok(MemberVO vo)
   {
	   vo.setTel(vo.getTel1()+"-"+vo.getTel2());
	   String en=encoder.encode(vo.getPwd());// 암호화 
	   //encoder.encode(vo.getId())
	   vo.setPwd(en);
       dao.memberJoinInsert(vo);	   
	   return "redirect:../main/main.do"; //재전송 (sendRedirect()) => request초기화 
   }
   
   @PostMapping("member/idcheck.do")
   @ResponseBody
   // JSP파일명 , .do 전송 ==> 일반 데이터, JSON ==> @RestController
   public String member_idcheck(String id)
   {
	   String result="";
	   int count=dao.memberIdCheck(id);
	   if(count==0)
	   {
		   result="YES";
	   }
	   else
	   {
		   result="NO";
	   }
	   return result;
   }
   
   @GetMapping("member/login.do")
   public String member_login(Model model)
   {
	   model.addAttribute("main_jsp", "../member/login.jsp");
	   return "main/main";
   }
   
   @PostMapping("member/login_ok.do")
   @ResponseBody
   public String member_login_ok(String id,String pwd,boolean ck,HttpSession session,HttpServletResponse response)
   {
	   String result="";
	   int count=dao.memberIdCheck(id);
	   if(count==0)
	   {
		   result="NOID";
	   }
	   else
	   {
		   MemberVO vo=dao.memberJoinInfoData(id);
		   if(encoder.matches(pwd, vo.getPwd()))// 암호된 비밀번호 / 일반 비밀번호 비교 
		   {
			   session.setAttribute("id", id);
			   session.setAttribute("name", vo.getName());
			   session.setAttribute("role", vo.getRole());
			   if(ck==true)
			   {
				   Cookie cookie=new Cookie("id", id);
				   cookie.setPath("/");
				   cookie.setMaxAge(60*60*24);
				   response.addCookie(cookie);
				   ////////////////////////////////
				   cookie=new Cookie("name", vo.getName());
				   cookie.setPath("/");
				   cookie.setMaxAge(60*60*24);
				   response.addCookie(cookie);
				   ///////////////////////////////
				   cookie=new Cookie("role", vo.getRole());
				   cookie.setPath("/");
				   cookie.setMaxAge(60*60*24);
				   response.addCookie(cookie);
			   }
			   result="OK";
		   }
		   else
		   {
			   result="NOPWD";
		   }
	   }
	   return result;
   }
   
   @GetMapping("member/logout.do")
   public String member_logout(HttpSession session)
   {
	   session.invalidate();
	   return "redirect:../main/main.do";
   }
   
   @GetMapping("member/join_before.do")
   public String member_before(Model model)
   {
        model.addAttribute("main_jsp", "../member/join_before.jsp");
        return "main/main";
   }
   @GetMapping("member/join_before_ok.do")
   @ResponseBody
   public String member_before_ok(String pwd,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   String result="";
	   String db_pwd=dao.memberGetPassword(id);
	   if(encoder.matches(pwd, db_pwd))
	   {
		   result="yes";
	   }
	   else
	   {
		   result="no";
	   }
	   return result;
   }
   @GetMapping("member/join_update.do")
   public String join_update(Model model,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   MemberVO vo=dao.memberUpdateData(id);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../member/join_update.jsp");
	   return "main/main";
   }
}



































