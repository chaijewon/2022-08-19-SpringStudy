package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
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
}



































