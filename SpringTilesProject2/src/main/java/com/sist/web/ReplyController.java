package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class ReplyController {
    @Autowired
    private ReplyDAO dao;
    
    @PostMapping("reply/insert.do")
    public String reply_insert(ReplyVO vo,HttpSession session,RedirectAttributes  ra)
    {
    	/*
    	 *    forward =>  데이터 전송(Model) 
    	 *    redirect => 데이터전송(RedirectAttributes)
    	 */
    	// int tab,int no
    	/*
    	 *   INSERT INTO spring_reply2 VALUES(
			      (SELECT NVL(MAX(no)+1,1) FROM spring_reply2),
			      pCno,pType,pId,pName,pMsg,SYSDATE
			    );
    	 */
    	String id=(String)session.getAttribute("id");
    	String name=(String)session.getAttribute("name");
    	
    	vo.setId(id);
    	vo.setName(name);
    	
    	dao.replyInsert(vo);
    	
    	ra.addAttribute("tab", vo.getType());
    	ra.addAttribute("no", vo.getCno());
    	return "redirect:../seoul/detail.do";
    }
    // reply/delete.do?no=${rvo.no }&type=${tab}&cno=${vo.no}
    @GetMapping("reply/delete.do")
    public String reply_delete(ReplyVO vo,RedirectAttributes ra)
    {
    	dao.replyDelete(vo.getNo());
    	ra.addAttribute("tab", vo.getType());
    	ra.addAttribute("no", vo.getCno());
    	return "redirect:../seoul/detail.do";
    }
}











