package com.sist.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.board.service.*;
import com.sist.board.vo.BoardVO;
/*
 *    1차 ==> MVC,DataBase (CURD) / Jquery(Ajax)
 *    2차 ==> Spring MVC , MyBatis / VueJS
 *    ================================================================== AWS
 *    3차 ==> Spring Boot , JPA / Thymeleaf  ==========> Controller
 *           Spring Boot , JPA / React(Redux) ========> RestController
 *    =================================================================
 */
@Controller
public class BoardController {
   @Autowired
   private BoardService service;
   
   // 사용자 요청 
   @GetMapping("/")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-rowSize;  // 0번부터 시작 , rownum => 1
	   map.put("start", start);
	   List<BoardVO> list=service.boardListData(map);
	   int totalpage=service.boardTotalPage();
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   
	   int count=service.boardRowCount();
	   count=count-((curpage*rowSize)-rowSize);
	   model.addAttribute("count", count);
	   /*
	    *    4
	    *    3
	    *    2
	    *    1
	    */
	   return "list";
   }
   @GetMapping("/insert")
   public String board_insert()
   {
	   return "insert";
   }
   @PostMapping("/insert_ok")
   public String board_insert_ok(BoardVO vo)
   {
	   return "redirect:/";
   }
}










