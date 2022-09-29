package com.sist.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.board.service.*;
import com.sist.board.vo.*;
/*
 *   SpringFramework => JSP/MyBatis 
 *   SpringBoot => Html/JPA
 *   ----------------------- 데이터베이스 , JSP => 사용이 가능 
 *   
 *   SELECT * FROM table_name WHERE name=#{name}
 *   
 *   findByNameLike(String name) 
 *   
 *   save() . save()
 */
/*
 *   @Controller ==> 화면 변경 
 *   @RestController ==> JSP안에 필요한 데이터만 전송이 가능 
 */
@RestController
public class BoardRestController {
   @Autowired
   private BoardService service; // 같은 객체 (메모리 주소가 동일) = 싱글턴 (70%) 
   
   /*
    *   스프링 사용하는 디자인 패턴 : 싱글턴 , 팩토리 (Container=클래스 관리) 
    *   클래스는 3개이상 => 역할분담 (데이터베이스(Repository) , 값(VO) , JSP연결(Controller))
    */
   // 자바스크립트 전송 , 일반문자열 , JSON 
   @PostMapping("/update_ok")
   public String board_update_ok(BoardVO vo)
   {
	   String result="";
	   String db_pwd=service.boardGetPassword(vo.getNo());
	   if(db_pwd.equals(vo.getPwd())) // 수정 
	   {
		   service.boardUpdate(vo);
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
	   return result;
   }
   
   @PostMapping("/delete_ok")
   public String board_delete_ok(int no,String pwd)
   {
	   String result="";
	   String db_pwd=service.boardGetPassword(no);
	   if(db_pwd.equals(pwd)) // 수정 
	   {
		   service.boardDelete(no);
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








