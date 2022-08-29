package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.dao.FoodDAO;
import com.sist.dao.FoodVO;

import java.util.*;
@RestController
public class FoodRestController {
   @Autowired
   private FoodDAO dao;
   
   @GetMapping(value="food/food_find_vue.do",produces = "text/plain;charset=UTF-8")
   public String food_find(int page,String loc)
   {
	   String result="";
	   try
	   {
		   int rowSize=9;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=(rowSize*page);
		   Map map=new HashMap();
		   map.put("start", start);
		   map.put("end", end);
		   map.put("address", loc);
		   List<FoodVO> list=dao.foodFindData(map);
		   //List ==> []
		   // VO  ==> {}
		   JSONArray arr=new JSONArray(); //[]
		   for(FoodVO vo:list)
		   {
			   JSONObject obj=new JSONObject();
			   obj.put("fno", vo.getFno());
			   obj.put("name", vo.getName());
			   obj.put("poster", vo.getPoster());
			   arr.add(obj); //[{},{},{}...]
		   }
		   result=arr.toJSONString();
	   }catch(Exception ex){}
	   return result;
   }
}
