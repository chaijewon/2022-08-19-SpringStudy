package com.sist.web;
/*
 *   // 댓글 요청 
     // 댓글 수정
     // 댓글 삭제 
     // 댓글 쓰기 
 */
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.vo.*;
import com.sist.dao.*;

@RestController //VueJS와 연동 
public class ReplyRestController {
   @Autowired
   private ReplyDAO dao;
   
   @GetMapping("seoul/reply_list.do")
   public String reply_list(int cno,int type)
   {
	   String result="";
	   ReplyVO vo=new ReplyVO();
	   vo.setCno(cno);
	   vo.setType(type);
	   List<ReplyVO> list=dao.replyListData(vo);
	   
	   JSONArray arr=new JSONArray();
	   for(ReplyVO rvo:list)
	   {
		   JSONObject obj=new JSONObject();
		   
	   }
	   
	   return result;//JSON
   }
}












