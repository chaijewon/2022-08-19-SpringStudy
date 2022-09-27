package com.sist.goods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.goods.service.*;
import com.sist.goods.vo.*;

import java.util.*;
@Controller
public class MainController {
	@Autowired
	private GoodsService dao;
	
	   @GetMapping("/main/main")
	   public String main_main(Model model)
	   {
		   // 데이터 출력 
		   //1.베스트
		   Map map=new HashMap();
		   map.put("table_name","goods_best");
		   List<GoodsVO> bList=dao.goodsMainData(map);
		   //2.신상품 
		   map.put("table_name","goods_new");
		   List<GoodsVO> nList=dao.goodsMainData(map);
		   //3.특가상품 
		   map.put("table_name","goods_special");
		   List<GoodsVO> sList=dao.goodsMainData(map);
		   
		   model.addAttribute("bList", bList);
		   model.addAttribute("nList", nList);
		   model.addAttribute("sList", sList);
		   model.addAttribute("main_jsp", "../goods/home.jsp");
		   return "main/main";
	   }
}
