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
    	return "redirect:../board/list.do";
    }
    
    @GetMapping("board/detail.do")
    public String board_detail(int no,Model model)
    {
    	model.addAttribute("main_jsp", "../board/detail.jsp");
    	return "main/main";
    }
}
