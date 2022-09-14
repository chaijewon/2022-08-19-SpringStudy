package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@Controller
public class FoodController {
     @Autowired
     private FoodService service;
     
     @Autowired
     private RecipeService rServ;
     
     @GetMapping("food/food_list.do")
     public String food_list(int cno,Model model)
     {
    	 // DAO
    	 List<FoodVO> list=service.foodListData(cno);
    	 CategoryVO vo=service.categoryInfoData(cno);
    	 model.addAttribute("list", list);
    	 model.addAttribute("cvo", vo);
    	 return "food/food_list";
     }
     
     @GetMapping("food/food_detail.do")
     public String food_detail(int fno,Model model)
     {
    	 //DAO
    	 FoodVO vo=service.foodDetailData(fno);
    	 model.addAttribute("vo", vo);
    	 
    	 String ss=vo.getType();
    	 ss=ss.replace("/", "|").replace(" ", "").replace("기타", "");
    	 // 탕 | 찌개 | 전골
    	 List<RecipeVO> rList=rServ.recipeFindData(ss);
    	 model.addAttribute("rList", rList);
    	 return "food/food_detail";
     }
     
     @RequestMapping("food/food_find.do")
     public String food_find(String ss,Model model)
     {
    	 
    	 return "food/food_find";// */*
     }
   
}








