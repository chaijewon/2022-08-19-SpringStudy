package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.dao.*;
@Controller
public class ReplyController {
   @Autowired
   private ReplyDAO dao;
   
   @PostMapping("reply/reply_insert.do")
   public String reply_insert(ReplyVO vo,HttpSession session) throws Exception
   {
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   dao.replyInsert(vo);
	   String uri="";
	   if(vo.getType()==1)
	   {
		   uri="../goods/all_detail.do?no="+vo.getBno();   
	   }
	   else if(vo.getType()==2)
	   {
		   uri="../goods/new_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==3)
	   {
		   uri="../goods/special_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==4)
	   {
		   uri="../goods/best_detail.do?no="+vo.getBno();
	   }
	   
	   return "redirect:"+uri;
   }
   @PostMapping("reply/reply_update.do")
   public String reply_update(ReplyVO vo)
   {
	   // DAO 
	   dao.replyUpdate(vo);
	   // 화면 이동 
	   String uri="";
	   if(vo.getType()==1)
	   {
		   uri="../goods/all_detail.do?no="+vo.getBno();   
	   }
	   else if(vo.getType()==2)
	   {
		   uri="../goods/new_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==3)
	   {
		   uri="../goods/special_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==4)
	   {
		   uri="../goods/best_detail.do?no="+vo.getBno();
	   }
	   
	   return "redirect:"+uri;
   }
   @PostMapping("reply/reply_reply_insert.do")
   public String reply_reply_insert(int pno,ReplyVO vo,HttpSession session)
   {
	   
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   //DAO연결 
	   dao.replyReplyInsert(pno, vo);
	   String uri="";
	   if(vo.getType()==1)
	   {
		   uri="../goods/all_detail.do?no="+vo.getBno();   
	   }
	   else if(vo.getType()==2)
	   {
		   uri="../goods/new_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==3)
	   {
		   uri="../goods/special_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==4)
	   {
		   uri="../goods/best_detail.do?no="+vo.getBno();
	   }
	   
	   return "redirect:"+uri;
   }
   // reply/reply_delete.do?no=${rvo.no }&bno=${rvo.bno}&type=${rvo.type}
   @GetMapping("reply/reply_delete.do")
   public String reply_delete(ReplyVO vo)
   {
	   //DAO연동
	   
	   String uri="";
	   if(vo.getType()==1)
	   {
		   uri="../goods/all_detail.do?no="+vo.getBno();   
	   }
	   else if(vo.getType()==2)
	   {
		   uri="../goods/new_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==3)
	   {
		   uri="../goods/special_detail.do?no="+vo.getBno();
	   }
	   else if(vo.getType()==4)
	   {
		   uri="../goods/best_detail.do?no="+vo.getBno();
	   }
	   
	   return "redirect:"+uri;
   }
}






