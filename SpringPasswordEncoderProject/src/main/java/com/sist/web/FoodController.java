package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// 구조화된 프로그램 ==> 재사용
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodController {
   // 스프링에 저장된 객체 주소를 받는다 
   @Autowired
   private FoodDAO dao;
   
   // 사용자 요청 처리  ==> 구분 (GetMapping,PostMapping,RequestMapping)
   // 1. 교재 (흐름) ==> 2. 구글링 (소스) ===> 응용 ==> 확장 
   // 자바 => C#,파이썬 , 스칼라 
   @GetMapping("food/food_list.do")
   public String food_list(int cno,Model model)
   {
	   // food_list에서 출력할 데이터 전송 (DAO)
	   List<FoodVO> list=dao.foodCategoryListData(cno);
	   for(FoodVO vo:list)
	   {
		   String addr=vo.getAddress();
		   addr=addr.substring(0,addr.lastIndexOf("지"));
		   vo.setAddress(addr);
		   
		   String poster=vo.getPoster();
		   poster=poster.substring(0,poster.indexOf("^"));
		   vo.setPoster(poster);
	   }
	   CategoryVO vo=dao.categoryInfoData(cno);
	   
	   model.addAttribute("cvo", vo);
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../food/food_list.jsp");
	   return "main/main";
   }
   
   @GetMapping("food/detail.do")
   public String food_detail(int fno,Model model)
   {
	   model.addAttribute("fno", fno);
	   model.addAttribute("main_jsp", "../food/food_detail.jsp");
	   return "main/main";
   }
   
}


















