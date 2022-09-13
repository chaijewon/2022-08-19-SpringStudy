package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@Controller
public class SeoulController {
   @Autowired
   private SeoulService service;
   private String[] tables={"","seoul_location","seoul_nature","seoul_shop"};
   @GetMapping("seoul/list.do")
   public String seoul_list(String page,int tab,Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   map.put("table_name", tables[tab]);
	   List<SeoulVO> list=service.seoulListData(map);
	   int totalpage=service.seoulTotalPage(map);
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   return "seoul/"+tables[tab];
   }
   
   @GetMapping("seoul/detail.do")
   public String seoul_detail(int tab,int no,Model model)
   {
	   Map map=new HashMap();
	   map.put("table_name", tables[tab]);
	   map.put("no", no);
	   SeoulVO vo=service.seoulDetailData(map);
	   model.addAttribute("vo", vo);
	   model.addAttribute("tab", tab); //tab => 구분
	   return "seoul/detail";
   }
}







