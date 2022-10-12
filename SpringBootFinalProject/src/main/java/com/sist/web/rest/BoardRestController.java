package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.entity.*;
import com.sist.web.dao.*;
/*
 *   JSP
 *   Spring
 *   Spring-Boot 
 *   -------------------------  JSP , ThymeLeaf , Vue  : CURD (게시판)
 */
@RestController
@CrossOrigin("http://localhost:3000")
public class BoardRestController {
   @Autowired
   private BoardDAO dao;
   
   @GetMapping("/board/list_react")
   public List<BoardEntity> board_list(int page)
   {
	   return dao.boardListData((page*10)-10);
   }
   @GetMapping("/board/total_react")
   public int board_total()
   {
	   return dao.boardTotalPage();
   }
   @GetMapping("/board/insert_react")
   public String board_insert(BoardEntity vo)
   {
	   dao.save(vo);
	   return "ok";
   }
   @GetMapping("/board/detail_react")
   public BoardEntity board_detail(int no)
   {
	   BoardEntity vo=dao.findByNo(no);
	   // 조회수 증가  save ==> 추가,수정 
	   vo.setHit(vo.getHit()+1);
	   dao.save(vo);
	   
	   vo=dao.findByNo(no);
	   return vo;
   }
}










