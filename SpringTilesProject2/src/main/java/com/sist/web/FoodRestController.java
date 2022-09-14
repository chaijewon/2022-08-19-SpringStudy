package com.sist.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.sist.service.*;
import com.sist.vo.*;
@RestController
public class FoodRestController {
    @Autowired
    private FoodService service;
    
    @GetMapping(value = "food/vue_find.do",produces = "text/plain;charset=UTF-8")//JSON
    public String food_find(String ss,String page)
    {
    	System.out.println("ss="+ss);
    	System.out.println("page="+page);
    	String result="";
    	try
    	{
    		if(page==null)
    			page="1";
    		if(ss==null)
    			ss="강남";
    		
    		int curpage=Integer.parseInt(page);
    		Map map=new HashMap();
    		int rowSize=12;
    		int start=(rowSize*curpage)-(rowSize-1);
    		int end=(rowSize*curpage);
    		map.put("start", start);
    		map.put("end", end);
    		map.put("address", ss);
    		
    		List<FoodVO> list=service.foodFindData(map);
    		int totalpage=service.foodLocationTotalPage(ss);
    		
    		JSONArray arr=new JSONArray(); //List  => [] => 자바스크립트 객체표현법 
    		// FoodVO ==> JSONObject  => {}
    		// [{},{},{}...]
    		int k=0;
    		for(FoodVO vo:list)
    		{
    			JSONObject obj=new JSONObject(); //{"fno":1,"name":"ddd"}
    			obj.put("fno", vo.getFno());
    			obj.put("name", vo.getName());
    			obj.put("poster", vo.getPoster().substring(0,vo.getPoster().indexOf("^")));
    			if(k==0)
    			{
    				obj.put("curpage", curpage);
    				obj.put("totalpage", totalpage);
    			}
    			
    			arr.add(obj);
    			k++;
    		}
    		result=arr.toJSONString();
    	}catch(Exception ex){}
    	return result;
    }
    
    @GetMapping(value="food/detail_vue.do",produces = "text/plain;charset=UTF-8")
    public String detail_vue(int fno)
    {
    	String result="";
    	try
    	{
    		FoodVO vo=service.foodDetailVueData(fno);
    		JSONObject obj=new JSONObject();
    		obj.put("fno", vo.getFno());
    		obj.put("name", vo.getName());
    		obj.put("poster", vo.getPoster());
    		obj.put("address", vo.getAddress());
    		obj.put("tel", vo.getTel());
    		obj.put("type", vo.getType());
    		obj.put("time", vo.getTime());
    		obj.put("parking", vo.getParking());
    		obj.put("price", vo.getPrice());
    		obj.put("menu", vo.getMenu());
    		
    		result=obj.toJSONString();
    	}catch(Exception ex) {}
    	return result;
    }
    
}









