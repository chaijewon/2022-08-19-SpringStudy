package com.sist.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
   @RequestMapping("main/main.do")
   public String main_main()
   {
	   return "main";
   }
   @RequestMapping("board/list.do")
   public String board_list()
   {
	   return "board/list";// */*
   }
   @RequestMapping("notice/list.do")
   public String notice_list()
   {
	   return "notice/list"; // */*
   }
   @RequestMapping("admin/main/list.do")
   public String admin_main()
   {
	   return "admin/main/list"; // */*/*
   }
}
