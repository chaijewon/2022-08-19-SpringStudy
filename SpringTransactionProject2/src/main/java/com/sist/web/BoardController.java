package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping("board/list.do")
  public String board_list(String page,Model model)
  {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page); //400 (bad request) => 모든 데이터 String
	   Map map=new HashMap();
	   map.put("start", curpage*10-10);
	   map.put("end", curpage*10);
	   List<BoardVO> list=dao.boardLisData(map);
	   int totalpage=dao.boardTotalPage();
	   model.addAttribute("list", list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   
	   int count=dao.boardCount();
	   count=count-((10*curpage)-10);
	   
	   model.addAttribute("count", count);
	   return "board/list";
  }
  
  @GetMapping("board/insert.do")
  public String board_insert() //입력 폼 
  {
	   return "board/insert";
  }
  
  @PostMapping("board/insert_ok.do")
  public String board_insert_ok(BoardVO vo)
  {
	   dao.boardInsert(vo);
	   return "redirect:list.do";// 재전송 (request를 전소아지 않는다 => sendRedirect())
  }
  
  @GetMapping("board/detail.do")
  public String board_detail(int no,Model model)
  {
	   // DB 연동
	   BoardVO vo=dao.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "board/detail";
  }
}
