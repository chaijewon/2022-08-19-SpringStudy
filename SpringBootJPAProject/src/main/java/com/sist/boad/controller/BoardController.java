package com.sist.boad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.board.entity.*;
import com.sist.board.dao.*;
@Controller  // DispatcherServlet과 통신 
public class BoardController {
  @Autowired
  private BoardDAO dao;
  
  @GetMapping("/")
  public String board_list(String page,Model model)
  {
	  if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   
	   int rowSize=10;
	   int start=(rowSize*curpage)-rowSize;  // 0번부터 시작 , rownum => 1
	   // VO = Entity
	   List<BoardEntity> list=dao.boardListData(start);
	   int totalpage=(int)(Math.ceil(dao.boardRowCount()/10.0));
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   
	   int count=dao.boardRowCount();
	   count=count-((curpage*rowSize)-rowSize);
	   model.addAttribute("count", count);
	   return "list";
  }
}
