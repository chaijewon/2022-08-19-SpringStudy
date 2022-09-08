package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.sist.vo.*;
import com.sist.service.*;
@Controller
public class RecipeController {
    @Autowired
    private RecipeService service;
    
    @GetMapping("recipe/list.do")
    public String recipe_list(String page,Model model)
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
    	List<RecipeVO> list=service.recipeListData(map);
    	for(RecipeVO vo:list)
    	{
    		String s=vo.getTitle();
    		if(s.length()>23)
    		{
    			s=s.substring(0,23)+"...";
    			vo.setTitle(s);
    		}
    		vo.setTitle(s);
    	}
    	// 총페이지 
    	int totalpage=service.recipeTotalPage();
    	// 블록 나누기 
    	final int BLOCK=10;
    	// [1]~~[10]
    	int startPage=((curpage-1)/BLOCK*BLOCK)+1; // 1 ~ 11 ~ 21
    	/*
    	 *   curpage 1~10   ==> startPage  = 1
    	 *   curpage 11~20  ==> startPage = 11
    	 */
    	int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;// 10,20,30...
    	if(endPage>totalpage)
    		endPage=totalpage;
    	
    	// 예  totalpage 13  ==> 1,2,3,4~10 , 11 12 13
    	
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	model.addAttribute("startPage", startPage);
    	model.addAttribute("endPage", endPage);
    	model.addAttribute("list", list);
    	return "recipe/list";
    }
}








