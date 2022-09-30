package com.sist.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.board.dao.*;
import com.sist.board.entity.*;
@RestController //DispatcherServlet와통신(사용자 요청 데이터) ==> Javascript에 데이터 전송 , Kotlin...
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   
   @PostMapping("/update_ok")
   public String board_update_ok(BoardEntity vo)
   {
	   System.out.println("no="+vo.getNo());
	   BoardEntity en=dao.findByNo(vo.getNo());
	   String result="";
	   if(en.getPwd().equals(vo.getPwd()))
	   {
		   dao.save(vo);// 수정
		   result="<script>"
				 +"location.href=\"/detail?no="+vo.getNo()+"\";"
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   System.out.println(result);
	   return result;
   }
   @PostMapping("/delete_ok")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   BoardEntity vo=dao.findByNo(no);
	   if(pwd.equals(vo.getPwd()))
	   {
		   dao.delete(vo);
		   result="<script>"
				 +"location.href=\"/\";"
				 +"</script>";
	   }
	   else
	   {
		   result="<script>"
				 +"alert(\"비밀번호가 틀립니다!!\");"
				 +"history.back();"
				 +"</script>";
	   }
	   return result;
   }
}









