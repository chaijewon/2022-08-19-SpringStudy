package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;
import com.sist.vo.*;
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
    	
    	int curpage=Integer.parseInt(page);
    	Map map=new HashMap();
    	int rowSize=10;
    	int start=(rowSize*curpage)-(rowSize-1);
    	int end=rowSize*curpage;
    	map.put("start", start);
    	map.put("end", end);
    	
    	List<BoardVO> list=dao.boardListData(map);
    	int totalpage=(int)(Math.ceil(dao.boardRowCount()/10.0));
    	// 삭제 => 번호(X)
    	
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("list", list);
    	model.addAttribute("main_jsp", "../board/list.jsp");
    	return "main/main";
    }
    
    @GetMapping("board/insert.do")
    public String board_insert(Model model)
    {
    	model.addAttribute("main_jsp", "../board/insert.jsp");
    	return "main/main";
    }
    
    @PostMapping("board/insert_ok.do")
    public String board_insert_ok(BoardVO vo)
    {
    	dao.boardInsert(vo);
    	return "redirect:../board/list.do";
    }
    
    @GetMapping("board/detail.do")
    public String board_detail(int no,Model model)
    {
    	BoardVO vo=dao.boardDetail(no);
    	System.out.println("num="+vo.getNum());
    	BoardVO pvo=new BoardVO();
    	BoardVO nvo=new BoardVO();
    	int count=dao.boardRowCount();
    	if(vo.getNum()==1)
    	{
    		pvo.setSubject("");
    		pvo.setNo(0);
    		
    	}
    	else
    	{
    		pvo=dao.boardPNData(vo.getNum()-1);
    	}
    	
    	if(vo.getNum()==count)
    	{
    		nvo.setSubject("");
    		nvo.setNo(0);
    	}
    	else
    	{	
    		nvo=dao.boardPNData(vo.getNum()+1);
    	}
    	
    	
    	model.addAttribute("pvo", pvo);
    	model.addAttribute("nvo", nvo);
    	model.addAttribute("vo", vo);
    	model.addAttribute("main_jsp", "../board/detail.jsp");
    	return "main/main";
    }
}









