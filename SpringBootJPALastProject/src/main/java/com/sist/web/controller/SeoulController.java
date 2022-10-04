package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
@Controller
public class SeoulController {
   @Autowired
   private SeoulLocationDAO dao;
   
   @GetMapping("/seoul/location")
   public String seoul_location(String page,Model model)
   {
	   if(page==null)
		   page="1";
	   
	   int curpage=Integer.parseInt(page);
	   int rowSize=12;
	   int start=(rowSize*curpage)-rowSize;
	   List<SeoulLocationEntity> list=dao.seoulLocationListData(start);
	   int totalpage=dao.seoulLocationTotalPage();
	   
	   final int BLOCK=10;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "seoul/location");
	   return "main";
   }
   @GetMapping("/seoul/nature")
   public String seoul_nature(Model model)
   {
	   model.addAttribute("main_content", "seoul/nature");
	   return "main";
   }
   @GetMapping("/seoul/shop")
   public String seoul_shop(Model model)
   {
	   model.addAttribute("main_content", "seoul/shop");
	   return "main";
   }
}
