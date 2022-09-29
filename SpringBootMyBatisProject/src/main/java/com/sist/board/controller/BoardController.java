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
	   service.boardInsert(vo);
	   return "redirect:/";
   }
   
   @GetMapping("/detail")
   public String board_detail(int no, Model model)
   {
	   BoardVO vo=service.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "detail";
   }
   // 요청 확인   @GetMapping("/detail")
   // 요청 데이터 받기 board_detail(int no, Model model)
   // 결과을 모아서  model.addAttribute("vo", vo);
   // 보여줄 화면으로 이동 return "detail";
   @GetMapping("/update")
   public String board_update(int no,Model model)
   {
	   BoardVO vo=service.boardUpdateData(no);
	   model.addAttribute("vo", vo);// 데이터 전송
	   return "update";
   }
   // WebFlux front=flux (MVC)
   // vue => vuex , react = redux
   // MVC ==> 사용자 요청 ==> Controller == 전송 === JSP
   // 보내는 데이터 : 구분자 (primary key) , 검색 
   @GetMapping("/delete")
   public String board_delete(int no,Model model)
   {
	   model.addAttribute("no", no);
	   return "delete";
   }
}










