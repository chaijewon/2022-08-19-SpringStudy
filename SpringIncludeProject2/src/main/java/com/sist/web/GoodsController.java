package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.dao.*;
@Controller
public class GoodsController {
  @Autowired
  private GoodsDAO dao;
  
  @GetMapping("goods/best.do")
  public String goods_best(String page,Model model)
  {
	  CommonsController.commonsData("goods_best", page, model, dao);
	  model.addAttribute("main_jsp", "../goods/best.jsp");
	  return "main/main";
  }
  @GetMapping("goods/special.do")
  public String goods_special(String page,Model model)
  {
	  CommonsController.commonsData("goods_special", page, model, dao);
	  model.addAttribute("main_jsp", "../goods/special.jsp");
	  return "main/main";
  }
  @GetMapping("goods/new.do")
  public String goods_new(String page,Model model)
  {
	  CommonsController.commonsData("goods_new", page, model, dao);
	  model.addAttribute("main_jsp", "../goods/new.jsp");
	  return "main/main";
  }
  
  @GetMapping("goods/all_detail.do")
  public String all_detail(int no,Model model)
  {
	  CommonsController.goodsDetailData("goods_all", no, model, dao);
	  model.addAttribute("main_jsp", "../goods/all_detail.jsp");
	  return "main/main";
  }
  @GetMapping("goods/best_detail.do")
  public String best_detail(int no,Model model)
  {
	  CommonsController.goodsDetailData("goods_best", no, model, dao);
	  model.addAttribute("main_jsp", "../goods/best_detail.jsp");
	  return "main/main";
  }
  @GetMapping("goods/special_detail.do")
  public String special_detail(int no,Model model)
  {
	  CommonsController.goodsDetailData("goods_special", no, model, dao);
	  model.addAttribute("main_jsp", "../goods/special_detail.jsp");
	  return "main/main";
  }
  @GetMapping("goods/new_detail.do")
  public String new_detail(int no,Model model)
  {
	  CommonsController.goodsDetailData("goods_new", no, model, dao);
	  model.addAttribute("main_jsp", "../goods/new_detail.jsp");
	  return "main/main";
  }
}
