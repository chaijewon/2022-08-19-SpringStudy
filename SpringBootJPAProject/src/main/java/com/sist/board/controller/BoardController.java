package com.sist.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
  @GetMapping("/insert")
  public String board_insert()
  {
	  return "insert";
  }
  @PostMapping("/insert_ok")
  public String board_insert_ok(BoardEntity vo)
  {
	  dao.save(vo);
	  // insert into board (content, hit, name, pwd, regdate, subject, no) values (?, ?, ?, ?, ?, ?, ?)
	  return "redirect:/";
  }
  @GetMapping("/detail")
  public String board_detail(int no,Model model)
  {
	  BoardEntity vo=dao.findByNo(no); 
	  vo.setHit(vo.getHit()+1);
	  dao.save(vo); // update,insert (save()동일)
	  //// ==> 조회수 증가 
	  vo=dao.findByNo(no);
	  model.addAttribute("vo", vo);
	  return "detail";
  }
  // 수정 
  @GetMapping("/update")
  public String board_update(int no,Model model)
  {
	  BoardEntity vo=dao.findByNo(no);
	  model.addAttribute("vo", vo);
	  return "update";
  }
  @GetMapping("/delete")
  public String board_delete(int no,Model model)
  {
	  model.addAttribute("no", no);
	  return "delete";
  }
}







