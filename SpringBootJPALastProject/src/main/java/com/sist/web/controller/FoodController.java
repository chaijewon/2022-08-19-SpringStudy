package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.vo.*;
@Controller
public class FoodController {
   @Autowired
   private FoodDAO dao;
   
   @Autowired
   private FoodCategoryDAO cdao;
   
   @GetMapping("/food/category_list")
   public String food_category_list(int cno,Model model)
   {
	   List<FoodEntity> list=dao.categoryFoodListData(cno);
	   for(FoodEntity vo:list)
	   {
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   vo.setPoster(poster);
		   String address=vo.getAddress();
		   address=address.substring(0,address.lastIndexOf("지"));
		   vo.setAddress(address.trim());
	   }
	   
	   CategoryEntity cvo=cdao.findByCno(cno);
	   model.addAttribute("cvo", cvo);
	   model.addAttribute("list", list);
	   model.addAttribute("main_content", "food/category_list");
	   return "main";
   }
   
   @GetMapping("/food/detail")
   public String food_detail(int fno,Model model)
   {
	   FoodEntity vo=dao.findByFno(fno);
	   String poster=vo.getPoster();
	   List<String> list=new ArrayList<String>();
	   StringTokenizer st=new StringTokenizer(poster,"^");
	   while(st.hasMoreTokens())
	   {
		   list.add(st.nextToken());
	   }
	   String addr1=vo.getAddress();
	   addr1=addr1.substring(0,addr1.lastIndexOf("지"));
	   model.addAttribute("addr1", addr1);
	   model.addAttribute("list", list);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_content", "food/detail");
	   return "main";
   }
}







