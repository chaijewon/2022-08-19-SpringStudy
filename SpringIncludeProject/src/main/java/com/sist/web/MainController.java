package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// Model => 기능 처리 (요청 처리) ==> HandlerMapping (@Controller,@RestController)
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.dao.*;
@Controller
public class MainController {
   @Autowired
   private SeoulDAO dao;
   @GetMapping("main/main.do")
   public String main_main(Model model)
   {
	   List<SeoulVO> list=dao.locationData();
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
}
