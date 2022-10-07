package com.sist.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.web.dao.*;
import com.sist.web.entity.*;

// react => class/function (hooks)
@RestController
@CrossOrigin("http://localhost:3000")

// port가 다른 경우 반드시 사용해서 => 허용
public class MainRestController {
  @Autowired
  private FoodCategoryDAO dao;
  
  @Autowired
  private FoodDAO fdao;
  
  @GetMapping("/food/category_react")
  public List<FoodCategoryEntity> foodCategoryListData(int no)
  {
	 
	  int start=0;
	  int end=0;
	  if(no==1)
	  {
		  start=0;
		  end=12;
	  }
	  else if(no==2)
	  {
		  start=12;
		  end=6;
	  }
	  else if(no==3)
	  {
		  start=18;
		  end=12;
	  }
	  
	  List<FoodCategoryEntity> list=dao.foodCategoryListData(start, end);
	  return list;
  }
  @GetMapping("/food/food_list_react") //[]
  public List<FoodEntity> food_list(int cno)
  {
	  List<FoodEntity> list=fdao.findByCno(cno);
	  for(FoodEntity vo:list)
	  {
		  String poster=vo.getPoster();
		  poster=poster.substring(0,poster.indexOf("^"));
		  vo.setPoster(poster);
		  
		  String address=vo.getAddress();
		  address=address.substring(0,address.lastIndexOf("지"));
		  vo.setAddress(address);
	  }
	  
	  return list;
  }
  
  @GetMapping("/food/info_react") //{}
  public FoodCategoryEntity food_info(int cno)
  {
	  FoodCategoryEntity vo=dao.findByCno(cno);
	  return vo;
  }
  
  @GetMapping("/food/detail_react")
  public FoodEntity food_detail(int fno)
  {
	  FoodEntity vo=fdao.findByFno(fno);
	  return vo;
  }
}







