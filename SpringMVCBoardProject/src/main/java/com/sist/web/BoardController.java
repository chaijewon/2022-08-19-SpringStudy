package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// request에 값을 담아서 JSP로 전송 
import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardController {
    @Autowired
    private BoardDAO dao;
    
    // 목록 
    @GetMapping("board/list.do")
    public String board_list(String page,Model model)
    {
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	Map map=new HashMap();
    	map.put("start", (curpage*10)-9);
    	map.put("end",curpage*10);
    	List<BoardVO> list=dao.boardListData(map);
    	int totalpage=dao.boardTotalPage();
    	
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("list", list);
    	
    	return "board/list";
    }
    // 추가 => 입력 폼 보여주기 
    @GetMapping("board/insert.do")
    public String board_insert()
    {
    	return "board/insert";
    }
    // @RequestMapping => Get/Post (Spring 4.3이상)
    // 사용자가 전송하는 모든 데이터는 DispatcherServlet => 매개변수를 이용해서 데이터를 주입 
    // 일반 데이터형 (int , String , double)
    // VO단위 
    // 배열 
    // List
    @PostMapping("board/insert_ok.do")
    public String board_insert_ok(BoardVO vo)
    {
    	// vo ==> 커맨드 객체 *****
    	dao.boardInsert(vo);
    	return "redirect:list.do";
    }
    // http://localhost:8080/web/     board/list.do
    // detail.do?no=${vo.no }
    @GetMapping("board/detail.do")
    public String board_detail(int no,Model model)
    {
    	BoardVO vo=dao.boardDetailData(no);
    	model.addAttribute("vo", vo);
    	return "board/detail";
    }
    // update.do?no=${vo.no}
    @GetMapping("board/update.do")
    // @ResponseBody = 승격 @RestController
    // Javscript => 어노테이션 
    public String board_update(int no,Model model)
    {
    	BoardVO vo=dao.boardUpdateData(no);
    	model.addAttribute("vo", vo);
    	return "board/update";
    }
    
}







