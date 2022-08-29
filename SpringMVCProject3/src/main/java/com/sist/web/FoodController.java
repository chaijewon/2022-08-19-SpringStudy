package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   // 필요한 객체를 멤버로 생성해서 주소값을 받는다 
   // 스프링에서 생성된 객체를 받아서 사용 => 자동으로 주소값을 얻어 온다 
   @GetMapping("food/list.do")
   public String food_list(String page,Model model)
   {
	   //                  ============
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=12;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   map.put("start", start);
	   map.put("end", end);
	   List<FoodVO> list=dao.foodListData(map);
	   int totalpage=dao.foodTotalPage();
	   ////////////////////////////////////////////////////////
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("list", list);
	   model.addAttribute("totalpage", totalpage);
	   ///////////////////////////////////////////////////////
	   return "list";
   }
}
