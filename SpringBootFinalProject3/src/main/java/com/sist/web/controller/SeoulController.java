package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;
@Controller
public class SeoulController {
   @Autowired
   private LocationDAO dao;
   
   @GetMapping("/seoul/detail")
   public String seoul_detail(int no,Model model)
   {
	   System.out.println("detail");
	   LocationEntity vo=dao.findByNo(no);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_content", "seoul/detail");
	   return "main";
   }
}
